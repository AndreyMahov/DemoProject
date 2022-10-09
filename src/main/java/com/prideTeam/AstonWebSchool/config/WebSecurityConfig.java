package com.prideTeam.AstonWebSchool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER).and()
                .authorizeRequests()
                .antMatchers("/rest/users*").hasAuthority("ROLE_ADMIN")

                .antMatchers("/rest/groups*").hasAuthority("ROLE_ADMIN")
                .antMatchers("/rest/lessons*").hasAnyAuthority("ROLE_TEACHER", "ROLE_ADMIN")
                .antMatchers("/rest/students**/logs*").hasAuthority("ROLE_STUDENT")
                .antMatchers("/rest/students**/notify*").hasAuthority("ROLE_STUDENT")
                .antMatchers("/rest/students*").hasAnyAuthority("ROLE_TEACHER", "ROLE_ADMIN")
                .antMatchers("/rest/roles*").hasAuthority("ROLE_ADMIN")
                .antMatchers("/rest/teachers*").hasAuthority("ROLE_TEACHER");
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsService userDetailsService) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}
