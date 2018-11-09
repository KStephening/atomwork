# Class
## 方法解释
>getClass()：返回当前类的包名.类名
>
>getSimpleName()：返回当前类的类名
>
>getGenericSuperclass()：返回当前类父类的类型（即：包名.类名<具体类型>）
>
>getActualTypeArguments()：返回表示此类型实际类型参数的 Type 对象的数组。【一般不直接使用该方法，而是在该方法后加一个下标，如下两行】
>
>getActualTypeArguments()[0]：返回当前类父类泛型的第一个参数。
>
>getActualTypeArguments()[1]：返回当前类父类泛型的第二个参数

## 代码
```java
// 父类
public class T1<K,V> {}

// 子类
public class T2 extends T1<Integer,String>{}

// 测试类
public class TestApp {
    T2 t2 = new T2();
    @Test
    public void test() {
        // class com.czd.test.T2
        System.out.println("getClass():" + t2.getClass());

        // T2
        System.out.println("getClass().getSimpleName():" + t2.getClass().getSimpleName());

        // com.czd.test.T1<java.lang.Integer.Integer, java.lang.String>
        System.out.println("getGenericSuperclass():" + t2.getClass().getGenericSuperclass());

        // [Ljava.lang.reflect.Type;@443b7951
        System.out.println("getActualTypeArguments():" + ((ParameterizedType) t2.getClass().
                getGenericSuperclass()).getActualTypeArguments());

        // class java.lang.Integer
        System.out.println("getActualTypeArguments():" + ((ParameterizedType) t2.getClass().
                getGenericSuperclass()).getActualTypeArguments()[0]);

        // class java.lang.String
        System.out.println("getActualTypeArguments():" + ((ParameterizedType) t2.getClass().
                getGenericSuperclass()).getActualTypeArguments()[1]);

    }
}

//输出结果：
//getClass():class com.czd.test.T2
//getClass().getSimpleName():T2
//getGenericSuperclass():com.czd.test.T1<java.lang.Integer, java.lang.String>
//getActualTypeArguments():[Ljava.lang.reflect.Type;@443b7951
//getActualTypeArguments():class java.lang.Integer
//getActualTypeArguments():class java.lang.String

```
