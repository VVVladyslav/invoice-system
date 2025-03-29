package com.example.invoice_system.config;



import io.swagger.v3.oas.models.info.Info;  // Импортируйте правильный класс
import io.swagger.v3.oas.models.info.Contact;  // Импортируем контактную информацию
import org.springdoc.core.GroupedOpenApi;  // Импортируем GroupedOpenApi для группировки API
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public-api")  // Группа API, которая будет отображаться в Swagger UI
                .pathsToMatch("/api/**")  // Все пути, начинающиеся с /api/
                .addOpenApiCustomiser(openApi -> openApi.info(new Info()  // Используем правильную реализацию Info
                        .title("Invoice System API")  // Заголовок API
                        .version("v1")  // Версия API
                        .description("API для работы с системой инвойсов")  // Описание API
                        .contact(new Contact()  // Контактная информация
                                .name("Your Name")
                                .email("your.email@example.com")
                                .url("https://yourwebsite.com"))
                ))
                .build();
    }
}
