package com.nivose.dlabphoto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	@Autowired
    private AccessDeniedHandler accessDeniedHandler;
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	http.authorizeRequests()
        	.antMatchers("/index").permitAll()
        	.antMatchers("/").permitAll()
		        .antMatchers("/admin/**").hasAnyRole("ADMIN")
		        .antMatchers("/user/**").hasAnyRole("USER")
				.anyRequest().permitAll()/*.authenticated()*/
				.and()
				  .formLogin()
				  	.loginPage("/login").permitAll()
				  	.defaultSuccessUrl("/home")
				  	.usernameParameter("username")
				  	.passwordParameter("password")
				  	.failureUrl("/login?error")
				.and()
				  .logout()
		        	.invalidateHttpSession(true)
		        	.deleteCookies("JSESSIONID")
		        	.clearAuthentication(true)
		        	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		        	.logoutSuccessUrl("/login?logout").permitAll()
		        .and()
		          .exceptionHandling()
		          .accessDeniedHandler(accessDeniedHandler)
				.and()
				  .csrf();
//	    	 http.sessionManagement().maximumSessions(1).expiredUrl("/login?expired");
//	    	 http.requiresChannel().antMatchers("/login*").requiresSecure(); add https
		}
	 
    @Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/fonts/**");
	}
    // create two users, admin and user
/*    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("user")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
    }
    
	@Configuration
	static class CacheableThymeleafConfiguration {
		@Bean
		public ServletContextTemplateResolver templateResolver() {
			ServletContextTemplateResolver resolver =  new ServletContextTemplateResolver();
			resolver.setPrefix("/ressources/templates/");
			resolver.setSuffix(".html");
			resolver.setTemplateMode("HTML5");
			resolver.setCacheable(false);
			return resolver;
		}

	}

		@Bean
		public ReloadableResourceBundleMessageSource messageSource() {
			ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
			messageSource.setBasename("classpath:messages");
			messageSource.setDefaultEncoding("UTF-8");
			return messageSource;
		}*/
  
}
