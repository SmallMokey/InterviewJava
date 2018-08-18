#### Java集合类

Java集合类分为Set、List、Queue和Map四种体系，其中Set代表无序、不可重复的集合；List代表有序、可重复的集合；而Map代表具有映射关系的集合；Queue代表一种队列集合实现
和数组的区别：

- 数组是长度在初始化时指定，意味着只能保存定长的数据。集合可以保存不定长的数据，同时可以保存具有映射关系的数组
- 数组元素可以是基本类型的值，也可以是对象。集合只能保存对象（实际上只是保存对象的引用变量），基本数据类型的变量要转换成对应的包装类才能放入集合类中

##### Java集合类之间的继承关系

主要有Collection和Map两个接口派生出。List、Set、Queue的父接口是Collection
![](img/Java集合类.png)

- Collection是一个接口，包含了集合的基本操作和属性
  1. List是一个有序队列，每个元素都有索引，第一个索引值为0
     List的常用实现类有LinkedList、ArrayList、Vector、Stack
  2.  Set是一个不允许重复元素的集合
        常用实现类有HashSet、TreeSet。其中，HashSet依赖于HashMap，实际上是HashMap实现的；TreeSet依赖于TreeMap，实际上TreeSet是通过TreeMap实现的。
- Map是一个映射接口，即Key-Value键值对。Map中的每一个元素包含“一个Key”和“Key对应的value”
  常用实现类有HashMap，TreeMap，WeakHashMap，HashTable。前三者继承于AbstractMap,HashTable虽然继承于Dictionary，但它实现了Map接口。

##### List接口

元素有放入顺序，元素可以重复,常用：ArraryList、LinkedList、Vector、Stack

###### ArraryList

实现：用数组存储元素，这个数组可以动态创建，如果元素个数超过数组的容量，就创建一个更大的新数组，并将当前数组中的所有元素都复制新数组中。
特点：数组查找块，增删慢。非线程安全的,效率高

###### LinkedList

实现：底层基于链表来实现，链表内存是散乱的，每一个元素存储本身内存地址的同时还存储下一个元素的地址。
特点：链表增删块，查找慢。

###### Vector

和ArrayList比较，是线程安全的，效率低

##### Set接口

元素放入无顺序，但是不可重复，常用实现类：HashSet，LinkedHashSet，TreeSet
注：元素放入是无顺序的，但元素在set中的位置是由该元素的HashCode决定的，其位置其实是固定的。

###### HashSet

为快速查找设计的Set，存入HashSet的对象必须定义hashCode().

###### TreeSet

保证次序的Set，底层为树结构，使用它可以从Set中提取有序的序列

###### LinkedHashSet

具有HashSet的查询速度，并且内部时使用链表维护元素的顺序（插入次序）。于是在使用迭代器遍历Set时，结果会按照元素插入的顺序输出。

##### Map接口

保存一种映射关系，实现类：HashMap、HashTable、LinkedHashMap、TreeMap

###### HashMap

非线程安全的，高效，支持null
内部数据结构：基于哈希表+链表+红黑树的实现
两个重要的方法：key.hashCode(),key.equals()
工作原理：HashMap是具有hashing原理，在添加元素是，使用put(key，value)存储对象到HashMap中，使用get(key)从HashMap中获取对象。
存储过程：通过put方法，先对键调用hasCode()方法，返回hashCode用于找到bucket位置存储Entry对象，HashMap是在bucket中存储键对象和值对象，作为Map.Entry。当两个键key的hashCode一样时，此时发生hash冲突，HashMap采用链表的方式来解决hash冲突问题，当两个key的hash冲突时，他们的bucket位置相同，他们的Entry会存储在链表中，此时可以调用key.equals（）方法比较是否已存在此key，若不存在，则插入，若存在，则更新value值。当链表的长度大于8（默认时），则将链表转为红黑树。
多线程时会出现的问题：在HashMap扩容时，多线程环境下，会发生条件竞争问题，造成死循环
参考链接：

1. http://www.importnew.com/7099.html
2. http://www.importnew.com/20386.html

###### HashTable

线程安全的，低效，不支持null

###### TreeMap

非线程安全的，通过红黑树实现，适用于按照自然顺序或自定义顺序遍历键（key）。

###### HashMap和HashTable的区别

1. HashMap可以接受null(HashMap可以接受为null的键值(key)和值(value)，而Hashtable则不行)。
2. HashMap是非synchronized，而Hashtable是synchronized，这意味着Hashtable是线程安全的，多个线程可以共享一个Hashtable；而如果没有正确的同步的话，多个线程是不能共享HashMap的。Java 5提供了ConcurrentHashMap，它是HashTable的替代，比HashTable的扩展性更好。
3. HashMap的迭代器(Iterator)是fail-fast迭代器
   Hashtable的enumerator迭代器不是fail-fast的
   所以当有其它线程改变了HashMap的结构（增加或者移除元素），将会抛出ConcurrentModificationException，但迭代器本身的remove()方法移除元素则不会抛出ConcurrentModificationException异常。但这并不是一个一定发生的行为，要看JVM。这条同样也是Enumeration和Iterator的区别。
4. 由于Hashtable是线程安全的也是synchronized，所以在单线程环境下它比HashMap要慢。如果你不需要同步，只需要单一线程，那么使用HashMap性能要好过Hashtable。
5. HashMap不能保证随着时间的推移Map中的元素次序是不变的。

HashMap，ConcurrentHashMap与LinkedHashMap的区别

1. ConcurrentHashMap使用锁分段技术来保证线程安全
   锁分段技术：首先将数据分成一段一段的存储，然后给每一段数据配一把锁，当一个线程占用锁访问其中一个段数据的时候，其他段的数据也能被其他线程访问
2. ConcurrentHashMap 是在每个段（segment）中线程安全的
3. LinkedHashMap维护一个双链表，可以将里面的数据按写入的顺序读出

###### ConcurrentHashMap应用场景 

- 高并发，但是并不能保证线程安全，同步的HashMap是锁住整个容器，加锁之后ConcurrentHashMap不需要锁住整个容器，只需要锁住对应的Segment，所以可以保证高并发同步访问，提升了效率。
- 可以多线程写。ConcurrentHashMap把HashMap分成若干个Segmenet
  1. get时，不加锁，先定位到segment然后在找到头结点进行读取操作。而value是volatile变量，可以保证在竞争条件时保证读取最新的值，如果读到的value是null，则可能正在修改，调用ReadValueUnderLock函数，加锁保证读到的数据是正确的。

  2. Put时会加锁，一律添加到hash链的头部。

  3. Remove时也会加锁，由于next是final类型不可改变，所以必须把删除的节点之前的节点都复制一遍。

  4. ConcurrentHashMap允许多个修改操作并发进行，其关键在于使用了锁分离技术。它使用了多个锁来控制对Hash表的不同Segment进行的修改。

  5. ConcurrentHashMap的应用场景是高并发，但是并不能保证线程安全，而同步的HashMap和HashTable的是锁住整个容器，而加锁之后ConcurrentHashMap不需要锁住整个容器，只需要锁住对应的segment就好了，所以可以保证高并发同步访问，提升了效率。
#### Arrays和Collections 中sort实现原理

1. Arrays.sort()
   是一个经过调优的快速排序算法，在很多数据集上提供N*log(N)的性能，这导致其他快速排序会降低二次型性能 
2. Collections.sort() 
   是一个经过修改的合并排序算法（如果低子列表中的最高元素效益高子列表中的最低元素，则忽略合并）。可提供保证的N*log(N)的性能，此实现将指定列表转储到一个数组中，然后再对数组进行排序，在重置数组中相应位置处每个元素的列表上进行迭代。这避免了由于试图原地对链接列表进行排序而产生的n2log(n)性能 