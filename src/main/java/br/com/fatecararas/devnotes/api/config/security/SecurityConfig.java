//package br.com.fatecararas.devnotes.api.config.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    //Create securityfilterchain bean responsible for all security
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/api/v1/**").permitAll()
////                        .anyRequest().authenticated()
//                )
//                .httpBasic(AbstractHttpConfigurer::disable)
//                .csrf(AbstractHttpConfigurer::disable);
////                .formLogin((form) -> form
////                        .loginPage("/login")
////                        .permitAll()
////                )
////                .logout((logout) -> logout.permitAll());
//
//        return http.build();
//    }
//}