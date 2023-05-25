# Spring boot base 基础服务
## 1.0.0 版本

作用：

项目基于DDD领域模型进行的分层，api 接入层 、 domain 领域层 、  infrastructure 基础层。

目录

├─com.mashibing.ddd
│    │
│    ├─apis   API接口层
│    │    ├─model     视图模型,数据模型定义 vo/dto（大多数情況是一样的）
│    │    ├─assembler    装配器，实现模型转换eg. apiModel&#x3c;=> domainModel
│    │    └─controller   控制器，对外提供（Restful）接口
│    │
│    ├─application   应用层
│    │    ├─service  应用服务，非核心服务
│    │    ├─task     任务定义，协调领域模型
│    │    └─***      others
│    │
│    ├─domain   领域层
│    │    ├─common       公共代码抽取，限于领域层有效
│    │    ├─events       领域事件
│    │    ├─model        领域模型
│    │    │    ├─dict    领域划分的模块，可理解为子域划分
│    │    │    │    ├─DictVo.java       领域值对象
│    │    │    │    ├─DictEntity.java   领域实体，充血的领域模型，如本身的CRUD操作在此处
│    │    │    │    ├─DictAgg.java      领域聚合，通常表现为实体的聚合，需要有聚合根
│    │    │    │    └─DictService.java  领域服务，不能归与上述模型，如分页条件查询等可写在此处
│    │    │    ├─xxx
│    │    │    │    ├─xxxEntity.java
│    │    │    │    ├─bbbAgg.java
│    │    │    │    └─cccAgg.java
│    │    ├─service      领域服务类，一些不能归属某个具体领域模型的行为
│    │    └─factory      工厂类，负责复杂领域对象创建，封装细节
│    │
│    ├─infrastructure  基础设施层
│    │    ├─persistent   持久化机制
│    │    │    ├─po           持久化对象
│    │    │    └─repository   仓储类，持久化接口&实现，可与ORM映射框架结合
│    │    ├─general      通用技术支持，向其他层输出通用服务
│    │    │    ├─config       配置类
│    │    │    ├─toolkit      工具类
│    │    │    └─common       基础公共模块等
│    │
│    └─resources
│        ├─statics  静态资源
│        ├─template 系统页面
│        └─application.yml   全局配置文件

1. 集成基础功能组件 。

   ```xml
   <!--详细用法，请参见：https://github.com/tntfyf/cnaworld-core-->
   <dependency>
             <groupId>cn.cnaworld.framework</groupId>
             <artifactId>core</artifactId>
             <version>{latest}</version>
   </dependency>
   ```

2. 提供代码生成工具

    CnaworldBaseCodeGenerator 支持cnaworld-mybatis-plus的自定义扩展super-class。
   由于mybatis-plus自带的工具仅支持opneapi2.0的模板，所以CnaWorldBaseEntity，以及项目也仅依赖了knife4j的openapi2版本。此工具可自动生成controller、entity、mapper、service等并支持逻辑删除、逻辑恢复等自定义方法。

3. log4j2 支持

   替换logback 为 log4j2 ，并支持日志异步打印

   1. 轮动配置策略：日志先按照月归档一年最多12个文件夹，在按照天归档。历史日志最大60天、最大5GB、文件最大50MB等。

   2. 日志分层打印：

      sys-all.log 全部日志包括三方库

      sys-debug-all.log 本系统debug业务日志

      sys-error.log 本系统异常日志

      sys-info.log 本系统info日志

      sys-framework.log 二方库日志

   3. 日志格式优化

4. 接口文档

   1. knife4j-openapi2

       简单调试可使用 localhost:8080/doc.html#/home 。 但是对于泛型的参数如ResponseResult<List<Student>>其无法给出很好的支持。

   2. smart-doc 

      对于knife4j-openapi2泛型的参数如ResponseResult<List<Student>>其无法给出很好的支持问题，提供了smart-doc  。此工具是以插件的形式存在的，当执行maven compile 时，会自动在"./src/main/resources/static/doc" 目录下生成openapi.json ，可将此文件导入到apifox等工具中。由于smart-doc  采用的是泛型推导，所以可以形成完整的API 文档。
      
      由于smart-doc 是基于 java 原生注释,knife4j-openapi2是基于注解所以要是想两个功能都使用，可能要写两套注释。请自行斟酌。
5. 配置文件按照环境切换

   1. 提供基本的 spring 、 redis  、 knife4j 、mybatis-plus的上下文配置及site、dev、prod的环境切换功能。

6. 单元测试问题
   log4j2-spring.xml 中使用了系统变量
      ```xml
   <Property name="LOCAL_IP" value="${sys:LOCAL_IP}" />
   <property name="SERVER_NAME" value="${sys:SERVER_NAME}" />
      ```
   单元测试时由于无法找到这两个系统变量导致执行失败。
   解决方法：
   （1）将配置文件中的两个属性值写死

   ```xml
   <Property name="LOCAL_IP" value="127.0.0.1" />
   <property name="SERVER_NAME" value="base" />
   ```

   (2)重命名配置文件为log4j2-spring.xml.bak使配置文件失效。