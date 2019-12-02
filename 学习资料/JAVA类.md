#Object
![image](D:/Object.png)
简介：Object类是所有类的父类，任何类都默认继承Object
1.常用方法
## Clone()
该方法实现了对对象的浅复制。
###如何使用这个方法？
只有实现了Coneable接口才可以调用该方法，否则会抛出CloneNotSupportedException异常。
###深拷贝和浅拷贝的区别是什么？
Object类中的克隆方法就是浅拷贝，只是实现对象的引用的拷贝，当该引用指向的对象发生改变时，拷贝出来的“对象”里面的属性也跟着改变，你可以理解为浅拷贝就是再建一个引用指向要拷贝的对象，至始至终其实都是一个对象，所以对象改变时，必然影响所有浅拷贝出来的“对象”。而深拷贝需要重写clone方法，实现对原堆里的对象的复制及引用类型，这样原对象发生改变是不会影响到拷贝出来的对象的，因为在堆里有两份。
###clone方法的保护机制是什么？
由于Object类并不知道我们子类有哪些引用，显然Object实现深拷贝是做不到的。Object中clone()方法是protected的，这样我们想在其他地方调用某个子类的clone方法时，就必须去重写该类的clone方法，将修饰符改为public，这样在其他地方就可以访问了。
## equals()
### 如何防止空指针问题？
一般接收的的参数A要与已知的参数B进行比较时建议写成：B.equals(A) 这样可以防止传过来的A是null的时候发生的空指针问题：A.equals(B).
### 怎样的俩个对象在调用这个方法后会返回true？
Object类中的代码是<br>
```
public boolean equals(Object obj) {
                     return (this == obj);
                 }
```
代码很明显，要俩个引用指向同一个对象才返回true。
### 这个方法在其他类中有重写吗？是怎样重写的呢？
```
public boolean equals(Object anObject) {
         if (this == anObject) {
             return true;
         }
         if (anObject instanceof String) {
             String anotherString = (String)anObject;
             int n = value.length;
             if (n == anotherString.value.length) {
                 char v1[] = value;
                 char v2[] = anotherString.value;
                 int i = 0;
                 while (n-- != 0) {
                     if (v1[i] != v2[i])
                         return false;
                     i++;
                 }
                 return true;
             }
         }
         return false;
     }
 ```
String类里重写了这个方法，不同String对象只要其字符相同也会返回true。每个类都可以根据自己的需要来对equals方法进行重写。当然如果一个类重写了equals方法，那么这个类一般也会重写hashCode方法。
## finalize()
这个方法用于释放资源，由于JAVA的GC完全由JVM来进行，我们无法指定程序何时发生GC，我们只能显示的通知JVM要进行GC，所以finalize()这个方法什么时候调用是不确定的。
### 这个方法什么时候调用？运用的场景是怎样的？
当JVM对该对象进行GC回收时，就会调用该方法。
### 这个方法的用途是什么？
在对象被GC时，可以在这个方法里使这个对象“复活”，具体是：this = new Object();
### 如果运行这个方法抛异常了会怎么样？
这个方法如果抛异常了会终止对当前对象的回收。
## getClass()
返回调用此方法的对象的类的类型，final修饰，子类无法重写。想要获取父类的类型可以通过object.getClass().getSuperclass()来获取其中object是子类对象。
## hashCode()
返回对象的哈希码值，是个native方法，前面有说到重写equals()方法要重写HashCode()方法，在一些集合中有用HashCode来定位元素的位置，一般equals相等的俩个对象其HashCode的也是一样的，比如在HashMap中，但是当HashCode相同的对象，true;
###哪些类重写了？
String类重写了HashCode
```
 public int hashCode() {
         int h = hash;
         if (h == 0 && value.length > 0) {
             char val[] = value;
             for (int i = 0; i < value.length; i++) {
                 h = 31 * h + val[i];
             }
             hash = h;
         }
         return h;
     }
```
## notify()
该方法与wait()方法搭配使用，用来唤醒在该对象上等待的某个线程，必须在synchronized中使用。
## notifyAll()
该方法与wait()方法搭配使用，用来唤醒在该对象上等待的所有线程，必须在synchronized的同步方法或同步代码块中使用。
## registerNatives()
###这个方法做了什么？
让JVM找到本地的函数。
## toString()
```
public String toString() {
         return getClass().getName() + "@" + Integer.toHexString(hashCode());
     }
```
对象名+@+HashCode的十六进制表示。
## wait()
### 消耗cpu吗？
不消耗cpu。
### 会释放锁吗？
会释放锁资源，这里要和Thread类的sleep()方法区分，sleep()方法不会释放锁资源，一直到睡醒为止，继续拿着锁运行完同步代码块。
### 什么场景下使用
在synchronized的同步方法或同步代码块中才能使用,否则抛出IllegalMonitorStateException异常，通过其他方式(如ReentrantLock)实现的同步代码内使用wait()方法也会抛这个异常。
### 什么是lost wake up？
这个问题其实就是解释为什么wait()要在synchronized同步代码块中执行，在生产者消费者中，生产者：执行goods++;notify();消费者执行：if (goods <= 0) wailt();
如果在消费者判断if(goods <= 0) 成立后准备执行wait()时，cpu时间片到了，生产者执行goods++;notify();然后消费者再获取时间片执行wait()导致唤醒的消息丢失。这就是lost wake up 问题。

#Integer

##toHexString()
转16进制
```
  public static void main(String[] args){
        System.out.println(Integer.toHexString(100)); // 64
    }
```
转8进制
```$xslt
 public static void main(String[] args){
        System.out.println(Integer.toOctalString(100)); // 144
    }
```
转2进制
```$xslt
 public static void main(String[] args){
        System.out.println(Integer.toBinaryString(100)); // 1100100
    }
```
二进制最左边1取整其他全为零
```$xslt
    public static int highestOneBit(int i) {
        // HD, Figure 3-1
        i |= (i >>  1);
        i |= (i >>  2);
        i |= (i >>  4);
        i |= (i >>  8);
        i |= (i >> 16);
        return i - (i >>> 1);
    }
```

二进制最右边1取整其他全为0
```$xslt
    public static int lowestOneBit(int i) {
        // HD, Section 2-1
        return i & -i;
    }
```
最高不为零位前面的零的个数
```$xslt
    public static int numberOfLeadingZeros(int i) {
        // HD, Figure 5-6
        if (i == 0)
            return 32;
        int n = 1;
        if (i >>> 16 == 0) { n += 16; i <<= 16; }
        if (i >>> 24 == 0) { n +=  8; i <<=  8; }
        if (i >>> 28 == 0) { n +=  4; i <<=  4; }
        if (i >>> 30 == 0) { n +=  2; i <<=  2; }
        n -= i >>> 31;
        return n;
    }
```
