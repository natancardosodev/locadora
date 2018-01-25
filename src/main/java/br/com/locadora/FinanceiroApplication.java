package br.com.locadora;

import java.util.Locale;

import javax.jms.Queue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import org.apache.activemq.command.ActiveMQQueue;

@SpringBootApplication
public class FinanceiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceiroApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt","BR"));
	}
	
	@Bean
    public Queue queue() {
        return new ActiveMQQueue("queue");
    }
}
