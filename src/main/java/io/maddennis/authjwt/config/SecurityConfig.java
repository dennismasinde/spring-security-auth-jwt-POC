package io.maddennis.authjwt.config;

import io.maddennis.authjwt.exception.AuthEntryPointJwt;
import io.maddennis.authjwt.service.UserDetailsServiceImpl;
import io.maddennis.authjwt.service.jwt.AuthTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static io.maddennis.authjwt.util.Util.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;
    private final DaoAuthenticationProvider authenticationProvider;
    private final AuthTokenFilter authTokenFilter;
    private final AuthEntryPointJwt unauthorizedHandler;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(ENDPOINTS_WHITELIST).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage(SIGNIN_URL)
                        .loginProcessingUrl(SIGNUP_URL));
        return http.build();
    }
}
