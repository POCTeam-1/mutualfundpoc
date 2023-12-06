package com.valtech.poc.mutualfundportfolio.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.valtech.poc.mutualfundportfolio.services.CustomSuccessHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Autowired
    CustomSuccessHandler customSuccessHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//            .csrf().disable()
//            .authorizeRequests(authorizeRequests ->
//                authorizeRequests
//                    .requestMatchers("/user").hasAuthority("USER")
//                    .requestMatchers("/admin").hasAuthority("ADMIN")
//                    .requestMatchers("/register").permitAll()
//                    .anyRequest().authenticated()
//            )
            httpSecurity.csrf().disable().authorizeRequests()
    		.requestMatchers("/user").hasRole("USER")
    		.requestMatchers("/admin").hasRole("ADMIN")
    		.requestMatchers("/register").anonymous()
    		.anyRequest().authenticated();
            httpSecurity.formLogin(formLogin ->
                formLogin
                    .loginPage("/login")
                    .loginProcessingUrl("/login")
                    .successHandler(customSuccessHandler)
                    .permitAll()
            )
            .logout(logout ->
                logout
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login?logout")
                    .permitAll()
            );

        return httpSecurity.build();
    }
}


//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//	
//	@Autowired
//	CustomSuccessHandler customSuccessHandler;
//	
//
//
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//
//		httpSecurity.csrf(c -> c.disable())
//				.authorizeHttpRequests(request -> request.requestMatchers("/user").hasAuthority("USER")
//						.requestMatchers("/admin").hasAuthority("ADMIN").requestMatchers("/register").permitAll()
//						.anyRequest().authenticated())
//
//				.formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login")
//						.successHandler(customSuccessHandler).permitAll().permitAll())
//
//				.logout(form -> form.invalidateHttpSession(true).clearAuthentication(true)
//						.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout")
//						.permitAll());
//
//		return httpSecurity.build();
//
//	}
//
//}
