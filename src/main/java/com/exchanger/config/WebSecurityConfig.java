package com.exchanger.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.DefaultLoginPageConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .authorizeRequests()
                    .antMatchers("/admin/","admin/**/*.*").access("hasRole('ADMIN')")
                    .antMatchers("/login").anonymous()
                    .antMatchers("/user/","user/**/*.*").access("hasRole('USER')")
                    .antMatchers( "/registration","/registration/**","/error").permitAll()
                .and()
                    .authorizeRequests()
                    .anyRequest().authenticated()
                .and()
                    .formLogin().successHandler(savedRequestAwareAuthenticationSuccessHandler())
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll()
                 .and()
                    .rememberMe().tokenRepository(persistentTokenRepository())
                    .tokenValiditySeconds(1209600);
                    http.removeConfigurer(DefaultLoginPageConfigurer.class);;
    }
    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler savedRequestAwareAuthenticationSuccessHandler() {
        SavedRequestAwareAuthenticationSuccessHandler auth = new SavedRequestAwareAuthenticationSuccessHandler();
        auth.setTargetUrlParameter("targetUrl");
        return auth;
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select login, password, enabled from users where login =?")
                .authoritiesByUsernameQuery("select u.login, ur.role from users u inner join user_role ur on u.id = ur.id where u.login=?");
    }
}
