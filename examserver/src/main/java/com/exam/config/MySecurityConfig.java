package com.exam.config;

import com.exam.services.implclass.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig{
    @Autowired
    private UserDetailsServiceImpl usp;

    @Bean
    public BCryptPasswordEncoder pswd() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider provider() {
        DaoAuthenticationProvider dap = new  DaoAuthenticationProvider();
        dap.setUserDetailsService(this.usp);
        dap.setPasswordEncoder(pswd());
        return dap;
    }
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        HttpSecurity disable = http.authorizeRequests().requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasRole("USER")
                .requestMatchers("/**").permitAll().and().formLogin().loginPage("/register").loginProcessingUrl("/login").defaultSuccessUrl("/user/index").and().csrf().disable();

        http.formLogin().defaultSuccessUrl("/user/index", true);

        return http.build();
    }
}
