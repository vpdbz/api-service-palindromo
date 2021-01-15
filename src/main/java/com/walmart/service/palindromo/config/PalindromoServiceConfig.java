package com.walmart.service.palindromo.config;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.walmart.service.palindromo.business.PalindromoServiceFactory;

@Configuration
public class PalindromoServiceConfig {

	@Bean
	public ServiceLocatorFactoryBean slfbForPalindromoServiceFactory() {
		ServiceLocatorFactoryBean slfb = new ServiceLocatorFactoryBean();
		slfb.setServiceLocatorInterface(PalindromoServiceFactory.class);
		return slfb;
	}

}