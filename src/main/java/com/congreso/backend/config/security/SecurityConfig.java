package com.congreso.backend.config.security;

import com.congreso.backend.config.security.filters.JwtTokenValidator;
import com.congreso.backend.config.security.jwt.JwtUtils;
import com.congreso.backend.service.Impl.UserDetailServiceImplS;
import com.congreso.backend.utils.CustomResponseBuilder;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private final JwtUtils jwtUtils;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HttpSession httpSession) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(autorize -> {
                    autorize.requestMatchers("/images/**").permitAll(); //permiso para servir imagenes
                    autorize.requestMatchers(HttpMethod.POST, "/auth/**").permitAll();
                    autorize.requestMatchers(HttpMethod.POST, "/reset/**").permitAll();
//                    autorize.requestMatchers("/auth/log-in", "/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll();
                    autorize.requestMatchers("/auth/**", "/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll();
                    autorize.anyRequest().authenticated();

                })
                .cors(cors -> cors.configurationSource(request -> { //oam
                    CorsConfiguration corsConfig = new CorsConfiguration();
//                    corsConfig.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
                    corsConfig.setAllowedOrigins(Arrays.asList(
//                            "http://localhost:8100", // Para desarrollo local
                            "http://localhost:4200", // Para desarrollo local
                            "https://tallerweb.uajms.edu.bo", // Para swagger
                            "https://inspiring-pithivier-5b81f7.netlify.app", // Para tu sitio de Netlify
                            "https://alexpc94.github.io" // Para tu página de GitHub Pages
                    ));
                    corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                    corsConfig.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "Accept"));
                    corsConfig.setExposedHeaders(Arrays.asList("Content-Disposition"));
                    corsConfig.setAllowCredentials(true);
                    return corsConfig;
                }))
                .sessionManagement(sesion -> {   //oam
                    sesion.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                /*
                .requiresChannel((channels) -> channels //oam
                      .anyRequest().requiresSecure()
                )*/
                .addFilterBefore(new JwtTokenValidator(jwtUtils), BasicAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailServiceImplS userDetailServiceImplS) throws Exception {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailServiceImplS);
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CustomResponseBuilder responseBuilder() {
        return new CustomResponseBuilder();
    }
    /*public static void main(String[]args){
        System.out.println(new BCryptPasswordEncoder().encode("1234"));
}*/
}
