#dubbbo
##dubbo的搭建
建立maven的空工程作为父工程
在此工程上建立三个子工程
加入依赖 抽取出interface层的接口

###负载均衡策略
可用于dubbo的@Service注解上主要有四种
随机模式@Service（loadbalance="Random"）<br>
轮询模式@Service（loadbalance="roundrobin"）<br>
最少活跃调用数@Service（loadbalance="LeastActive"）<br>
一致Hash@Service（loadbalance="ConsistentHash"）<br>

随机模式：按权重设置随机概率
轮询模式：按公约后的权重设置轮询比例，响应慢的服务提供者清请求会累计
最少活跃调用数：快速响应的提供者请求越来越多，响应慢的请求越来越少
一致hash，根据服务提供者的ip设置hash环，携带相同的参数总是发送的统一个
服务提供者，若服务挂了，则会基于虚拟节点平摊到其他提供者上

在项目启动初期会有降权的预热
负载均衡源码解读:

[https://dubbo.apache.org/zh-cn/docs/source_code_guide/loadbalance.html] <br>
RandomLoadBalance 是加权随机算法的具体实现，它的算法思想很简单。假设我们有一组服务器 servers = [A, B, C]，
他们对应的权重为 weights = [5, 3, 2]，权重总和为10。现在把这些权重值平铺在一维坐标值上，[0, 5) 区间属于服务器 A，[5, 8) 
区间属于服务器 B，[8, 10) 区间属于服务器 C。接下来通过随机数生成器生成一个范围在 [0, 10) 之间的随机数，然后计算这个随机数
会落到哪个区间上。比如数字3会落到服务器 A 对应的区间上，此时返回服务器 A 即可。权重越大的机器，在坐标轴上对应的区间范围就越
大，因此随机数生成器生成的数字就会有更大的概率落到此区间内。只要随机数生成器产生的随机数分布性很好，在经过多次选择后，每个服
务器被选中的次数比例接近其权重比例。比如，经过一万次选择后，服务器 A 被选中的次数大约为5000次，服务器 B 被选中的次数约为3000次，
服务器 C 被选中的次数约为2000次。

`public class RandomLoadBalance extends AbstractLoadBalance {
 
     public static final String NAME = "random";
 
     private final Random random = new Random();
 
     @Override
     protected <T> Invoker<T> doSelect(List<Invoker<T>> invokers, URL url, Invocation invocation) {
         int length = invokers.size();
         int totalWeight = 0;
         boolean sameWeight = true;
         // 下面这个循环有两个作用，第一是计算总权重 totalWeight，
         // 第二是检测每个服务提供者的权重是否相同
         for (int i = 0; i < length; i++) {
             int weight = getWeight(invokers.get(i), invocation);
             // 累加权重
             totalWeight += weight;
             // 检测当前服务提供者的权重与上一个服务提供者的权重是否相同，
             // 不相同的话，则将 sameWeight 置为 false。
             if (sameWeight && i > 0
                     && weight != getWeight(invokers.get(i - 1), invocation)) {
                 sameWeight = false;
             }
         }
         
         // 下面的 if 分支主要用于获取随机数，并计算随机数落在哪个区间上
         if (totalWeight > 0 && !sameWeight) {
             // 随机获取一个 [0, totalWeight) 区间内的数字
             int offset = random.nextInt(totalWeight);
             // 循环让 offset 数减去服务提供者权重值，当 offset 小于0时，返回相应的 Invoker。
             // 举例说明一下，我们有 servers = [A, B, C]，weights = [5, 3, 2]，offset = 7。
             // 第一次循环，offset - 5 = 2 > 0，即 offset > 5，
             // 表明其不会落在服务器 A 对应的区间上。
             // 第二次循环，offset - 3 = -1 < 0，即 5 < offset < 8，
             // 表明其会落在服务器 B 对应的区间上
             for (int i = 0; i < length; i++) {
                 // 让随机值 offset 减去权重值
                 offset -= getWeight(invokers.get(i), invocation);
                 if (offset < 0) {
                     // 返回相应的 Invoker
                     return invokers.get(i);
                 }
             }
         }
         
         // 如果所有服务提供者权重值相同，此时直接随机返回一个即可
         return invokers.get(random.nextInt(length));
     }
 }`
 
 最少活跃数调用
