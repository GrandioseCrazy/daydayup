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
