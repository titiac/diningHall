package com.base.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: base
 * @description: 自动化接口文档配置类
 * @author: zhw
 * @created: 2022/11/16 23:37
 * http://localhost:3000/swagger-ui.html
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("RestfulApi")
                .select()
                // 包扫描范围（对指定的包下进行扫描，如果标注有相关swagger注解，则生成相应文档）
                //.apis(RequestHandlerSelectors.basePackage(SCAN_BASE_PACKAGE))
                // 过滤掉哪些path不用生成swagger
                .paths(PathSelectors.any())
                .build()
                // 忽略该参数在swagger上的显示
                .ignoredParameterTypes()
                // 配置swagger接口安全校验规则
                .securitySchemes(securitySchemes())
                // 配置swagger接口安全校验上下文中的信息（包含安全权限与安全校验生效的接口路径）
                .securityContexts(securityContexts())
                .apiInfo(apiInfo())
                // swagger生效
                .enable(true);
    }

    private List<ApiKey> securitySchemes() {
        return new ArrayList<ApiKey>(){{
            add(new ApiKey("Authorization", "Authorization", "header"));
        }};
    }

    private List<SecurityContext> securityContexts() {
        return new ArrayList<SecurityContext>(){{
            add(SecurityContext.builder()
                    .securityReferences(defaultAuth())
                    .forPaths(PathSelectors.any())
                    .build());
        }};
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(
                new SecurityReference("Authorization", authorizationScopes));
    }


    private ApiInfo apiInfo() {
        Contact contact = new Contact("联系人名字", "https://www.4399.com", "联系人邮箱");
        return new ApiInfo(
                "Base", // 标题
                "Base接口文档", // 描述
                "v1.0", // 版本
                "https://www.4399.com", // 组织链接
                contact, // 联系人信息
                "Apach 2.0 许可", // 许可
                "许可链接", // 许可连接
                new ArrayList<>()// 扩展
        );
    }
}

