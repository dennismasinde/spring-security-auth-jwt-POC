package io.maddennis.authjwt.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Security Auth POC",
                version = "1.0.0",
                description = """
                        User Endpoints documentation.\n
                        A list available endpoints
                        """
        ),
        servers= {
                @Server(
                        url="http://localhost:8080"
                )
        }
)
public class SwaggerConfig {
}
