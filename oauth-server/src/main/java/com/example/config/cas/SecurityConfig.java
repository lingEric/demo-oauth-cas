package com.example.config.cas;

import org.jasig.cas.client.session.SingleSignOutFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.cas.web.CasAuthenticationFilter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.logout.LogoutFilter;

import java.util.Collections;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationProvider authenticationProvider;
    private AuthenticationEntryPoint authenticationEntryPoint;
    private SingleSignOutFilter singleSignOutFilter;
    private LogoutFilter logoutFilter;


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    public SecurityConfig(CasAuthenticationProvider casAuthenticationProvider, AuthenticationEntryPoint eP, LogoutFilter lF, SingleSignOutFilter ssF) {
        this.authenticationProvider = casAuthenticationProvider;
        this.authenticationEntryPoint = eP;

        this.logoutFilter = lF;
        this.singleSignOutFilter = ssF;

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .authenticationEntryPoint(authenticationEntryPoint)

                .and()
                .logout().logoutSuccessUrl("/logout")

                .and()
                .addFilterBefore(singleSignOutFilter, CasAuthenticationFilter.class)
                .addFilterBefore(logoutFilter, LogoutFilter.class);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected AuthenticationManager authenticationManager() {
        return new ProviderManager(Collections.singletonList(authenticationProvider));
    }

    @Bean
    public CasAuthenticationFilter casAuthenticationFilter(ServiceProperties sP) {
        CasAuthenticationFilter filter = new CasAuthenticationFilter();
        filter.setServiceProperties(sP);
        filter.setAuthenticationManager(authenticationManager());
        return filter;
    }

}