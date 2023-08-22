package cn.cnaworld.base.infrastructure.config.knife4j;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * 创建Swagger配置
 * @author Lucifer
 */
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("cnaworld api 接口文档")
                        .version("1.0")
                        .contact(new Contact()
                                .email("tntfyf@yeah.net")
                                .name("Lucifer")
                                .url("https://www.cnaworld.com.cn"))
                        .description( "cnaworld api 接口文档")
                        .termsOfService("https://www.cnaworld.com.cn")
                        .license(new License().name("")
                                .url("https://www.cnaworld.com.cn")));
    }
}

