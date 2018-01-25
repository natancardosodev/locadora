/**
 * 
 */
package br.com.locadora.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

/**
 * @author cbarbosag
 *
 */
//@Configuration
public class InMemorySecurityConfig {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder
			.inMemoryAuthentication()
			.withUser("carlos").password("123").roles("MASTER")
			.and()
			.withUser("flavio").password("123").roles("ADMIN");
	}
}
