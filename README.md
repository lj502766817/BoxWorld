# 盒子世界

#### 碰到的问题

##### mybatis:

>*springboot项目,不使用*
    
      ```xml
      <dependency>
          <groupId>org.mybatis.spring.boot</groupId>
         <artifactId>mybatis-spring-boot-starter</artifactId>
         <version>2.1.0</version>
     </dependency>
     ```
     
     *直接而引入mybatis-spring和mybatis的包的话,`@Mapper`会失效接口无法扫描到spring的容器中.是mybatis-spring-boot-starter中有mybatis-spring和mybatis没有的jar导致的?*
     



