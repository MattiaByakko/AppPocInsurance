package pocInsurance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Disabilita CSRF perché stiamo usando JWT
                .csrf(csrf -> csrf.disable())
                // Configura autorizzazioni
                .authorizeHttpRequests(auth -> auth
                        // Swagger e OpenAPI pubblici
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/v3/api-docs/**"
                        ).permitAll()
                        // Solo utenti autenticati possono accedere alle API
                        .requestMatchers("/api/**").authenticated()
                        // Tutto il resto libero (o personalizza)
                        .anyRequest().permitAll()
                )
                // Configurazione Resource Server per JWT
                .oauth2ResourceServer(oauth2 ->
                        oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter()))
                );

        return http.build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        // Converte i ruoli Keycloak in GrantedAuthority di Spring
        converter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());
        return converter;
    }
}
