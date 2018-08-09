



#### OSI七层协议 和 TCP/IP五层协议

![网络分层模型即各层对应哪些协议](F:\找工作相关\Java知识点\计算机网络\img\网络分层模型即各层对应哪些协议.png)

#### OSI基本概念

OSI是Open System Interconnect的缩写，意为开放式系统互联。  OSI七层参考模型的各个层次的划分遵循下列原则：  1、同一层中的各网络节点都有相同的层次结构，具有同样的功能。
2、同一节点内相邻层之间通过接口（可以是逻辑接口）进行通信。  
3、七层结构中的每一层使用下一层提供的服务，并且向其上层提供服务。  
4、不同节点的同等层按照协议实现对等层之间的通信。 
物理层：传输单位是比特（bit）
数据链路层：传输的单位是帧（frame）,PPP,HDLG
网络层：传输的数据单位是数据包（packet）,ICMP,IGMP,IP,ARP,RIP,OSPF
传输层：传输的数据单位是数据报（datagrams）,协议：TCP,UDP
会话层，表示层没有协议
应用层：协议：HTTP,FTP等；

#### OSI和TCP/IP的区别

TCP/IP协议中的应用层处理开放式系统互联模型中的第五层、第六层和第七层的内容
TCP/IP协议中的传输层不能总是保证可靠地传输数据包，OSI可以做到。因为，TCP/IP协议中存在UDP传输协议，不稳定，不可靠，尽力而为的传输协议。

#### HTTP和HTTPS







链接：

1. https://blog.csdn.net/skyroben/article/details/77073834
2. https://blog.csdn.net/huangjin0507/article/details/51613561