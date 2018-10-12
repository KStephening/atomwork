# 运算符优先级及运算法则

##  例子1
```java
String userName = null != "2" ? "hhhhh" : "";
```
### 优先级
`!=`>`?:`>`=`
### 运算法则
`!=` 从左往右

`?:` ,`=` 从右往左
### 结果
`userName="hhhhh"`