package com.congreso.backend.config.security;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.HttpHeaders;

@OpenAPIDefinition(
        info = @Info(
                title = "API ASTRO",
                description = "API's proyecto PRUEBITA",
                termsOfService = "www.astro.com",
                version = "1.0.0",
                contact = @Contact(
                        name = "Octavio Aguilar",
                        url = "www.astro.com",
                        email = "octavioa111@gmail.com"
                ),
                license = @License(
                        name = "Standar software User License",
                        url = "www.astro/license"
                )
        ),
        servers = {
//                @Server(
//                        description = "DEV SERVER",
//                        url = "http://localhost:8080"
//                )
                @Server(
                        description = "PROD SERVER",
                        url = "https://astro-sp.onrender.com"
                )
        },
        security = @SecurityRequirement(
                name = "Security token"
        )
)
@SecurityScheme(
        name = "Security token",
        description = "Access token for my API",
        type = SecuritySchemeType.HTTP,
        paramName = HttpHeaders.AUTHORIZATION,
        in = SecuritySchemeIn.HEADER,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class SwaggerConfig {
}
