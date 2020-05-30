### 1.碰到的问题:

###### mybatis的@Mapper注解问题:

  springboot项目,不使用

```xml
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
       <artifactId>mybatis-spring-boot-starter</artifactId>
       <version>2.1.0</version>
   </dependency>
```

  直接而引入`mybatis-spring`和`mybatis`的包的话,`@Mapper`会失效接口无法扫描到spring的容器中.是`mybatis-spring-boot-starter`中有`mybatis-spring`和`mybatis`没有的jar导致的?

------



### 杂谈:

1. 三目运算符的问题,Boolean?A:B的时候,如果A和B存在向上转换兼容的情况的时候,会自动向上兼容.比如 Object o = true?1:1.1d,最后o得到的结果是1d.


