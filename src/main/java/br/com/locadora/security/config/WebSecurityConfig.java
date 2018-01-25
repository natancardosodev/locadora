/**
 * 
 */
package br.com.locadora.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author cbarbosag
 *
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	private UserDetailsService usuarioDetailsService;	

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.
			authorizeRequests()
				.antMatchers("/usuarios").hasAnyRole("MASTER")
				.antMatchers("/addUsuario").hasAnyRole("ADMIN")
				.anyRequest()
				.authenticated()
			.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
			.and()
			.logout()
				.logoutSuccessUrl("/login?logout")
				.permitAll();
	}
	
	@Override
	  protected void configure(AuthenticationManagerBuilder builder) throws Exception {
	    builder
	        .userDetailsService(usuarioDetailsService)
	        .passwordEncoder(new BCryptPasswordEncoder());
	  }
	
}
