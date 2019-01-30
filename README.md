# IOC
反射+XML解析模仿Spring写了个控制反转和依赖注入
  
### Explain  
模仿了Spring实现了基本的控制反转和依赖注入
* 可以将创建对象的部分交给底层代码，通过XML配置文件读取并动态的创建对象，实现了控制反转  
* XML配置文件里每个bean节点下可以书写若干property节点，代表该对象的属性，实现了将其value值或ref值注入到该对象的成员属性中   

![](https://i.imgur.com/JI6O0BN.png)  
![](https://i.imgur.com/l1ZU44Z.png)  
<br>
<br>
<br>
<br>
<br>

`依赖的jar包`  
[dom4j](https://github.com/dom4j/dom4j) --- 解析XML  
[CrudUtils](https://github.com/skypyb/CrudUtils) --- 使用了其中的类型转换方法
