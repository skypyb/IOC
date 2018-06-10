# IOC
反射+XML解析模仿Spring写了个控制反转和依赖注入
  
<br>
<br>
<br>
  
## change log

#### v1.0.0(2018-06-10)  
刚码出来热乎的代码
<br>
<br>
<br>
## Explain
模仿了Spring的控制反转和依赖注入
* 可以将创建对象的部分交给底层代码，通过XML配置文件读取并动态的创建对象，实现了控制反转  
* XML配置文件里每个bean节点下可以书写若干property节点，代表该对象的属性，实现了将其value值或ref值注入到该对象的成员属性中   

![](https://pyb001.oss-cn-shenzhen.aliyuncs.com/IOC/root.PNG?x-oss-process=style/blogImg)  
![](https://pyb001.oss-cn-shenzhen.aliyuncs.com/IOC/test1.PNG?x-oss-process=style/blogImg)  
<br>
<br>
<br>
<br>
<br>

`依赖的jar包`  
dom4j --- 解析XML  
[pybutil](https://github.com/skypyb/crudUtils) --- 使用了其中的类型转换方法
