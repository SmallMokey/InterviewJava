#### String

String：字符串常量，字符串长度不可变。Java中String是immutable(不可变)的。
String类包含了：

```java
private final char value[];
private final int offset;
private final int count;
```

用于存放字符的数组被声明为final的，因此只能赋值一次，不可再更改。

#### StringBuffer

字符串变量（Synchronized，线程安全），适合频繁对字符串内容进行修改的操作。Java.lang.StringBuffer是线程安全的可变字符序列。在任意时间点上它包含某种特定的字符序列，可将字符串缓冲区安全地用于多线程。
StringBuffer的主要操作是append和insert，append方法始终将需要添加的字符添加到缓冲区的末端，insert的方法在指定的位置添加字符。

#### StringBuilder  

字符串变量（非线程安全），在内部，StringBuilder对象被当做是一个包含字符序列的变长数组
`java.lang.StringBuilde`提供了一个与StringBuilder兼容的API，但不保证同步。被设计为StringBuilder的一个简易替换，用在字符串缓存区被单个线程使用的时候。不考虑线程的安全性。

#### 三者区别

String：每次对`String`类型进行改变的时候，都会生成一个新的`String`对象，然后将指针指向新的`Stirng`对象。
Stirng对象的字符串拼接其实被Java Compiler编译成了StringBuffer对象的拼接，所以速度和StringBuffer处理字符拼接的速度相近。但如果拼接的字符串来自另外的String对象，`Java Compiler`就不会自动转换了。
StringBuffer：每次操作都是对其本身进行的操作，不生成新的对象并改变对象引用。
StringBuilder：单线程，非线程安全的

#### 使用策略

1. 对于操作少量的数据，用`String`,单线程操作大量数据，用`StringBuffer`,多线程操作大量数据，用`StringBuilder`。
2. StringBuilder一般使用在方法内部来完成类似`+`的功能，因为线程不安全，所以用完以后可以丢弃。StringBuffer主要用在全局变量中。
3. 除非确定系统的瓶颈是在StringBufffer上，并且确定模块不会运行在多线程模式下，才可以采用StringBuilder，否在使用StringBuffer。