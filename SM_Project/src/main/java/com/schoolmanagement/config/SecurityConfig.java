package com.schoolmanagement.config;

import com.schoolmanagement.filter.JwtFilter;
import com.schoolmanagement.serviceImpl.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import java.lang.Object;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 1. allow "/authenticate" url only
     * 2. for "/" and "/addUsers" added xxxFilter
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.cors(); //Allow Angular to Access
    	http.csrf().disable().authorizeRequests().antMatchers(allowList())
                .permitAll().anyRequest().authenticated()
                .and().exceptionHandling().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
    /**
     * Allowed/Authenticated URL 
     * @return
     */
    private String[] allowList() {
		String[] allowList =
					{ "/authenticate" 
					,"/register"
					,"/swagger-ui.html", "/webjars/**","/swagger-resources/**","/v2/api-docs" //Swager enabled
					 ,"/rabi"  //TODO : Removed Later
					// ,"/allUsers"
					};
		return allowList;
	}
}
