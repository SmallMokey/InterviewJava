#### IOC 和 DI

##### IOC容器

Inversion of Control，具有依赖注入功能的容器，是可以创建对象的容器，IOC容器负责实例化、定位、配置应用程序中的对象及建立对象之间的关系
通常，new一个实例，控制权由程序员控制，而`IOC` 将new实例工作不由程序员来做而是交给Spring容器来做，在Spring中BeanFactory是IOC容器的实际代表，原有的方法会造成组件之间相互耦合度较高。

##### DI

Dependency injection:在容器创建对象后，处理对象之间的关系
通过反射机制，在实例化一个类时，通过反射机制调用类的set方法，将事先保存在HashMap中的类属性注入到类中。
Spring支持三种依赖注入方式：属性注入（set注入）、静态工厂的注入方式、构造方法注入、基于注解的方式

##### Bean

Spring中，那些组成应用的主体及由Spring IOC容器所管理的对象被称为Bean
Spring IOC容器通过反射机制实例化Bean并建立Bean之间的关系，Bean就是由Spring IOC容器初始化、装配及被管理的对象。
获取过程：先通过Resource加载配置文件并启动IOC容器，然后通过getBean方法获取Bean对象
作用范围：
`Singleton` :单例，Spring Ioc容器中只有一个共享的Bean。
`Prototype` :多例，每一个请求，会产生一个新的Bean实例
`Request` :请求，每一次http请求会产生一个新的Bean实例

##### AOP

面向切面编程，纵向的编程，完善spring的依赖注入（DI）
面向切面编程（AOP）是对面向对象编程(OOP)的补充

- 面向对象编程将程序分解成各个层次的对象
  面向切面编程将程序运行过程中分解成各个切面
- oop是静态的抽象
  aop是动态的抽象

如业务1和业务2都需要一个共同的操作，与其往每个业务中都添加同样的代码，不如写一遍代码，让两个业务共同使用这段代码。在日常有订单管理、商品管理、资金管理、库存管理等业务，都会需要到类似日志记录、事务控制、权限控制、性能统计、异常处理及事务处理等。AOP把所有共有代码全部抽取出来，放置到某个地方集中管理，然后在具体运行时，再由容器动态织入这些共有代码。
应用场景：性能检测、访问控制、日志管理、事务等
实现机制：

- 动态代理：利用截取消息的方式，对该消息进行装饰，以取代原有对象行为的执行（运行期）
- 静态织入：引入特定的语法创建“切面”，从而使得编译器子啊编译期间织入有关“切面”的代码（编译期）

如果目标类是接口，则使用JDK动态代理技术;如果目标对象没有实现接口，则会默认采用CGLIB代理

参考链接：

1. http://www.cnblogs.com/andy6163/p/Andy.html

##### 动态代理

代理类在程序运行时创建的代理方式被成为动态代理。 也就是说，这种情况下，代理类并不是在Java代码中定义的，而是在运行时根据我们在Java代码中的“指示”动态生成的。相比于静态代理， 动态代理的优势在于可以很方便的对代理类的函数进行统一的处理，而不用修改每个代理类的函数。  

实现步骤：

> 1. 定义MyInvoctionHandler类，实现InvocationHandler借口，作为一个帮助proxy的类
> 2. 调用Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject .getClass().getInterfaces(), handler)生成代理

MyInvocationHandler类：
```java
public class MyInvocationHandler implements InvocationHandler{
    //要代理的真实对象
    private Object subject;
    public MyInvocationHandler(Object subject){
        this.subject = subject;
    }
    //当代理的方法被调用时，代理会把这个调用转发给InvocationHandler。
    //不管代理被调用的事何种方法，处理器被调用的一定是invoke方法。
    @Override
    public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
        //在调用真实对象方法前我们可以添加一些自己的操作
        System.out.println("before rent house");
        System.out.println("Method:" + arg1);
        //通过Method类调用真实对象的方法
        arg1.invoke(subject, arg2);
        //在调用真实对象方法后我们也可以添加一些自己的操作
        System.out.println("after rent house");
        return null;
    }
}
```

Main函数

```java
public class Main {
    public static void main(String[] args){
        //我们要代理的真实对象
        Subject realSubject = new RealSubject();
        //InvocationHandler不是proxy，只是一个帮助proxy的类。proxy会把调用转发给它处理。
        InvocationHandler handler = new MyInvocationHandler(realSubject);
        /*
         * 通过Proxy的newProxyInstance方法来创建我们的动态代理对象。
         * 第一个参数 handler.getClass().getClassLoader()，传入被代理对象的类载入器。
         * 第二个参数realSubject.getClass().getInterfaces()，传入代理需要实现的接口
         * 第三个参数handler，传入调用处理器。
         */
        Subject subject = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject
                .getClass().getInterfaces(), handler);
        System.out.println(realSubject.getClass().getName());
        subject.rent();
        subject.hello("world");
   }
}
```

注：JDK的动态代理要使用到一个类Proxy用于创建动态代理对象，一个借口InvocationHandler用于监听代理对象的行为






#### 常问的问题

##### @Autowired和@Resource的区别

1. 都是注入属性（DI）,从容器中找对象注入到修饰的对象上，可以写在字段上或者是setter方法上
2. @A默认按照类型装配（属于Spring），默认情况下要求依赖对象必须存在
3. @R默认按照名称装配（属于J2EE），默认取字段名按照名次查找，如果写在setter上，默认取属性名进行装配。