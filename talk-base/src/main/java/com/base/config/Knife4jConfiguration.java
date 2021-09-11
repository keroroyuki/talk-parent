package com.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 谭嘉乐
 */
@Configuration
@EnableSwagger2
public class Knife4jConfiguration {
    @Bean(value = "baseApi")
    public Docket recruitApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                    .description("基础微服务api")
                    .termsOfServiceUrl("www.talk.com")
                    .contact("1@qq.com")
                    .version("1.0")
                    .build())
                .groupName("1.0版本")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.base.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
