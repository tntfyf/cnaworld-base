```
├─cn.cnaworld.base
│    │
│    ├─api   API接口层
│    │    ├─controller 控制器，对外提供（Restful）接口
│    │    └─model      视图模型,数据模型定义 vo/dto（大多数情況是一样的）
│    │
│    ├─application    应用层
│    │    ├─service   应用服务，负责领域间服务编排，胶水层
│    │    ├─assembler 装配器，实现模型转换DO到DTO、VO的转换
│    │    └─task      任务定义，协调领域模型
│    │
│    ├─domain   领域层
│    │    ├─order         订单领域
│    │    │    ├─event    领域事件
│    │    │    ├─factory  领域工厂
│    │    │    ├─gateway  领域网关
│    │    │    ├─model    模型层
│    │    │    │    ├─entity  实体
│    │    │    │    ├─root    聚合根
│    │    │    │    └─vo      值对象
│    │    │    └─service  领域服务，聚合服务，不能归与上述模型，如分页条件查询等可写在此处
│    │    │
│    │    ├─product  商品领域
│    │    │    ├─event    领域事件
│    │    │    ├─factory  领域工厂
│    │    │    ├─gateway  领域网关
│    │    │    ├─model    模型层
│    │    │    │    ├─entity  实体
│    │    │    │    ├─root    聚合根
│    │    │    │    └─vo      值对象
│    │    │    └─service  领域服务，聚合服务，不能归与上述模型，如分页条件查询等可写在此处
│    │    │
│    ├─infrastructure  基础设施层
│    │    ├─component  框架组件
│    │    │    ├─bus              领域消息总线
│    │    │    └─baseclass        基础类
│    │    │    └─exceptionhandler 统一异常处理 
│    │    ├─repository   仓储
│    │    │    ├─facade      仓储接口
│    │    │    ├─persistence 仓储持久化实现
│    │    │    └─orm         框架实现
│    │    ├─config      配置类，统一配置管理
│    │    └─utils       工具类	
│    │    
│    └─resources
│    │    ├─log4j2    日志配置
│    │    ├─redisson  缓存配置
│    │    ├─smart-doc 接口文档配置
│    │    ├─static
│    │    │    ├─doc      生成的静态接口文档
│    │    │    └─template 静态页面模板
│    │    ├─application.yml  全局配置文件
│    │    ├─application-site.yml 本地环境配置文件
│    │    ├─application-dev.yml  测试环境配置文件
│    │    └─application-prod.yml 生产环境配置文件
```

1. 集成基础功能组件 。

   ```xml
   <!--详细用法，请参见：https://github.com/tntfyf/cnaworld-spring-boot-starter-->
   <dependency>
     <groupId>cn.cnaworld.framework</groupId>
     <artifactId>cnaworld-spring-boot-starter</artifactId>
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