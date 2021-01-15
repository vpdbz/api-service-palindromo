package com.walmart.service.palindromo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.google.common.collect.ImmutableList;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  @Autowired
  private ApiCustomCredentials credentials;

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
    .withUser(this.credentials.getUserName())
    .password(this.credentials.getPassword())
    .roles(this.credentials.getRole());
  }
    
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
    .cors().and() //Linea agregada para soportar CORS, pruebas locales
    .authorizeRequests()
    .antMatchers("/customers").authenticated()
    .antMatchers("/get/**").permitAll()
    .and()
    .httpBasic();
  }
  
  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
      final CorsConfiguration configuration = new CorsConfiguration();

//      configuration.setAllowedOrigins(ImmutableList.of("http://localhost:3000", "https://palindromo-web-react.herokuapp.com")); // www - obligatory
      configuration.setAllowedOrigins(ImmutableList.of("*"));  //set access from all domains
      configuration.setAllowedMethods(ImmutableList.of("GET", "POST", "PUT", "DELETE"));
      configuration.setAllowCredentials(true);
      configuration.setAllowedHeaders(ImmutableList.of("Authorization", "Cache-Control", "Content-Type"));

      final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      source.registerCorsConfiguration("/**", configuration);

      return source;
  }
  
}