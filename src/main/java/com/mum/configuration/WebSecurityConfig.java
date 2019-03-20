package com.mum.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mum.repository.UserRepository;




@Configuration
@EnableWebSecurity

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter   {
	
	
	
	
	  @Autowired
	    private BCryptPasswordEncoder bCryptPasswordEncoder;

	    @Autowired
	    private DataSource dataSource;

	    @Value("${spring.queries.users-query}")
	    private String usersQuery;

	    @Value("${spring.queries.roles-query}")
	    private String rolesQuery;
	    
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth)
	            throws Exception {
	        auth.
	                jdbcAuthentication()
	                .usersByUsernameQuery(usersQuery)
	                .authoritiesByUsernameQuery(rolesQuery)
	                .dataSource(dataSource)
	                .passwordEncoder(bCryptPasswordEncoder);
	       
	    }
	
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	 
	        http.authorizeRequests()
		        .antMatchers("/login","/h2-console/**","/font/**","/js/**","/css/**","/img/**").permitAll()
		        .antMatchers("faculty/**").hasAuthority("FACULTY").anyRequest()
		        .authenticated()
		        .and()
	            .authorizeRequests();
	        
	        http.csrf().disable();
	        
    		http.headers().frameOptions().disable()	     
		        .and().csrf().disable().formLogin()
		        .loginPage("/login").failureUrl("/login?error=true")
		        .defaultSuccessUrl("/dashboard")
		        .usernameParameter("username")
		        .passwordParameter("password")
		        .and().logout()
		        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		        .logoutSuccessUrl("/login").and().exceptionHandling()
		        .accessDeniedPage("/access-denied");
    		
    		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
	    }
	    
	    @Override
	    public void configure(WebSecurity web) throws Exception {
//	        web
//	                .ignoring()
//	                .antMatchers("/resources/**");
	    }
	    
	

	    

}
