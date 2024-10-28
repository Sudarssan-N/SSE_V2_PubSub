package com.example.sse_server;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class CorsConfig implements WebFluxConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/sse/**")
                .allowedOrigins(
                        "https://whlsecentralsup--temp2.sandbox.lightning.force.com",
                        "https://wise-hawk-hdi2dp-dev-ed.trailblaze.lightning.force.com",  // Your Salesforce domain
                        "https://llama-upright-possibly.ngrok-free.app",                  // Your ngrok custom domai
                        "http://localhost:8080"                                           // Localhost for local testing
                )
                .allowedMethods("GET", "POST", "OPTIONS")
                .allowedHeaders("Content-Type", "Authorization")
                .allowCredentials(true)  // Allow cookies and credentials
                .maxAge(3600);  // Cache the CORS preflight request for 1 hour
    }
}
