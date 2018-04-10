package cc.ifnot.demo.util.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configuration
class CustomCorsConfiguration2 : WebMvcConfigurerAdapter() {

    override fun addCorsMappings(registry: CorsRegistry?) {
        //registry.addMapping("/api/**").allowedOrigins("http://localhost:8080");
    }
}
