package cn.cnaworld.base;

import cn.cnaworld.base.infrastructure.component.baseclass.CnaWorldBaseEntity;
import cn.cnaworld.framework.infrastructure.component.mybatisplus.baseclass.mapper.CnaWorldBaseMapper;
import cn.cnaworld.framework.infrastructure.component.mybatisplus.baseclass.service.CnaWorldBaseService;
import cn.cnaworld.framework.infrastructure.component.mybatisplus.baseclass.service.impl.CnaWorldBaseServiceImpl;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.GeneratorBuilder;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;

public class CnaworldBaseCodeGenerator {
	
	public static void main(String[] args) {
		DataSourceConfig mysqlDataSourceConfig = new DataSourceConfig.Builder(
				"jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&useSSL=false&characterEncoding=utf8","root","root")
				.typeConvert(new MySqlTypeConvert())
				.keyWordsHandler(new MySqlKeyWordsHandler())
				.dbQuery(new MySqlQuery())
				.build();
		GlobalConfig globalConfig = GeneratorBuilder.globalConfigBuilder()
				.fileOverride()//是否覆盖已生成文件 默认值:false
				.openDir(false)//是否打开生成目录 默认值:true 
				.outputDir("D:\\CodeRepository\\github\\tntfyf\\cnaworld-base\\src\\main\\java\\")//指定输出目录 默认值: windows:D:// linux or mac : /tmp
				.author("Lucifer")//作者名 默认值:无
				//.enableKotlin()//是否生成kotlin 默认值:false
				.enableSwagger()//是否生成swagger注解 默认值:false
				.dateType(DateType.TIME_PACK)//时间策略 默认值: DateType.TIME_PACK
				.commentDate("yyyy-MM-dd")//注释日期 默认值: yyyy-MM-dd
				.build();
		PackageConfig packageConfig = new PackageConfig.Builder()
				.parent("cn.cnaworld.base.domain") //父包名 默认值:com.baomidou
				.moduleName("user") //父包模块名 默认值:无
				.entity("entity") //Entity包名 默认值:entity
				.service("service") //Service包名 默认值:service
				.serviceImpl("service.impl") //Service Impl包名 默认值:service.impl
				.mapper("mapper") //Mapper包名 默认值:mapper
				.xml("mapper.xml") //Mapper XML包名 默认值:mapper.xml
				.controller("controller") //Controller包名 默认值:controller
				.build();
		TemplateConfig templateConfig = new TemplateConfig.Builder().build(); // 激活所有默认模板
		//LikeTable likeTable=new LikeTable("operate_log");
		StrategyConfig strategyConfig = new StrategyConfig.Builder()
				.enableCapitalMode()//开启大写命名
				//.enableSkipView()//开启跳过视图
				//.disableSqlFilter()//禁用sql过滤
				//.likeTable(likeTable)//模糊表匹配(sql过滤)
				//.notLikeTable(null)//模糊表匹配(sql过滤)
				//.addFieldPrefix("")//增加表字段前缀
				.addInclude("sys_user")//增加表匹配(内存过滤)
				//.addInclude("email_account_manage")//增加表匹配(内存过滤)
				//.addExclude("")//增加表排除匹配(内存过滤)
				//.addTablePrefix("")//增加表前缀
				//实体策略配置
				.entityBuilder()//实体策略配置
					//.nameConvert(null)//名称转换实现
					.superClass(CnaWorldBaseEntity.class)//父类W
					//.enableColumnConstant()//开启生成字段常量W
					//.enableChainModel()//开启链式模型
					//.addSuperEntityColumns("")//添加父类公共字段
					//.addTableFills(new Column(null),new Column(null))//添加属性填充字段
					//.enableActiveRecord()//开启ActiveRecord模型
					//.convertFileName(null)//转换文件名称
					//.formatFileName(null)//格式化文件名称
					//.enableSerialVersionUID()//开启生成serialVersionUID
					.enableLombok()//开启lombok模型
					.addIgnoreColumns("deleted_db","create_by_db","update_by_db","create_time_db","update_time_db")
					.enableRemoveIsPrefix()//开启Boolean类型字段移除is前缀
					.enableTableFieldAnnotation()//开启生成实体时生成字段注解
					.versionColumnName("update_time_db")//乐观锁字段名(数据库)
					.versionPropertyName("updateTimeDb")//乐观锁属性名(实体)
					.logicDeleteColumnName("deleted_db")//逻辑删除字段名(数据库)
					.logicDeletePropertyName("deleteDB")//逻辑删除属性名(实体)
					.naming(NamingStrategy.underline_to_camel)//数据库表映射到实体的命名策略 默认:NamingStrategy.no_change
					.columnNaming(NamingStrategy.underline_to_camel)//数据库表字段映射到实体的命名策略
					.idType(IdType.ASSIGN_ID)//全局主键类型
				//controller策略配置
				.controllerBuilder()//controller策略配置
					//.superClass(CodeGenerator.class)//父类
					//.convertFileName(null)//转换文件名称
					//.formatFileName("")//格式化文件名称
					.enableHyphenStyle()//开启驼峰转连字符
					.enableRestStyle()//开启生成@RestController控制器
				//service策略配置
				.serviceBuilder()//service策略配置
					.superServiceClass(CnaWorldBaseService.class)//设置service接口父类
					.superServiceImplClass(CnaWorldBaseServiceImpl.class)//设置service实现类父类
					//.convertServiceFileName(null)//转换service接口文件名称
					//.convertServiceImplFileName(null)//转换service实现类文件名称
					//.formatServiceFileName(null)//格式化service接口文件名称
					//.formatServiceImplFileName(null)//格式化service实现类文件名称	
				//mapperBuilder
				.mapperBuilder()//mapperBuilder
					.superClass(CnaWorldBaseMapper.class)//设置父类
					//.cache(null)//设置缓存实现类
					//.formatMapperFileName("")//格式化mapper文件名称
					//.formatXmlFileName("")//格式化xml实现类文件名称
					//.convertMapperFileName(null)//转换mapper类文件名称
					//.convertXmlFileName(null)//转换xml文件名称
					.enableBaseResultMap()//启用BaseResultMap生成
					.enableBaseColumnList()//启用BaseColumnList
				.build();

		InjectionConfig injectionConfig = new InjectionConfig.Builder().build();
		// 代码生成器
		new AutoGenerator(mysqlDataSourceConfig).global(globalConfig).packageInfo(packageConfig)
				.strategy(strategyConfig)
				.template(templateConfig)
				.injection(injectionConfig)
				.execute();
	}
}