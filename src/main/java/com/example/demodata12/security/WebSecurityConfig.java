package com.example.demodata12.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

  // tao tk trong bo nho memory
  @Bean
  public InMemoryUserDetailsManager userDetailService() {
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    UserDetails user = User.withDefaultPasswordEncoder()
        .username("user")
        .password("123")
        .roles("USER")
        .build();
    UserDetails admin = User.withDefaultPasswordEncoder()
        .username("admin")
        .password("123")
        .roles("ADMIN")
        .build();
    manager.createUser(user);
    manager.createUser(admin);
    return manager;
  }

  // xac thuc de log yeu cau
  @Configuration
  public static class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http
          .authorizeRequests()
          .requestMatchers(HttpMethod.GET, "/home").hasAnyRole("USER","ADMIN")
          .requestMatchers(HttpMethod.GET, "/admin").hasRole("ADMIN")
          .requestMatchers(HttpMethod.GET, "/api/id").hasRole("ADMIN")
          .requestMatchers(HttpMethod.GET, "/api/all").hasRole("ADMIN")
          .requestMatchers(HttpMethod.GET, "/api/username").hasRole("ADMIN")
          .requestMatchers(HttpMethod.GET, "/api/search").hasRole("ADMIN")
          .requestMatchers(HttpMethod.POST, "/api/user").hasRole("ADMIN")
          .requestMatchers(HttpMethod.DELETE, "/api/delete").hasRole("ADMIN")
          .anyRequest()
          .authenticated()
          .and()
          .httpBasic(Customizer.withDefaults());
      return http.build();
    }
  }
}
