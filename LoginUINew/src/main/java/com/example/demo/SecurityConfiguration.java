package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	private DataSource datasource;
	private final String USER_QUERY="select email,pwd,active from user where email=?";
	private final String ROLE_query="select * from u inner join"
			+ "";
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.jdbcAuthentication()
		.usersByUsernameQuery(USER_QUERY)
		.authoritiesByUsernameQuery(ROLE_query)
		.passwordEncoder(bCryptPasswordEncoder);

	}
	
	
	 protected void configure(HttpSecurity http) throws Exception{
	  http.authorizeRequests()
	   .antMatchers("/").permitAll()
	   .antMatchers("/login").permitAll()
	   .antMatchers("/signup").permitAll()
	   .antMatchers("/home/**").hasAuthority("ADMIN").anyRequest()
	   .authenticated().and().csrf().disable()
	   .formLogin().loginPage("/login").failureUrl("/login?error=true")
	   .defaultSuccessUrl("/home/home")
	   .usernameParameter("email")
	   .passwordParameter("password")
	   .and().logout()
	   .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	   .logoutSuccessUrl("/")
	   .and().rememberMe()
	   .tokenRepository(persistentTokenRepository())
	   .tokenValiditySeconds(60*60)
	   .and().exceptionHandling().accessDeniedPage("/access_denied");
	 }
	 
	 @Bean
	 public PersistentTokenRepository persistentTokenRepository() {
	  JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
	  db.setDataSource(datasource);
	  
	  return db;

}}
