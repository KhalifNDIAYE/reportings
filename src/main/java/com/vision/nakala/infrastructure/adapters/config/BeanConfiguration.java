package com.vision.nakala.infrastructure.adapters.config;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.vision.nakala.domain.service.DomainesService;
import com.vision.nakala.infrastructure.adapters.output.eventpublisher.DomainesEventPublisherAdapter;
import com.vision.nakala.infrastructure.adapters.output.persistence.DomainesPersistenceAdapter;
import com.vision.nakala.infrastructure.adapters.output.persistence.mapper.DomainesPersistenceMapper;
import com.vision.nakala.infrastructure.adapters.output.persistence.repository.DomainesRepository;


@Configuration
@ComponentScan(basePackages = { "com.*" })
public class BeanConfiguration {

	@Bean
	public DomainesPersistenceAdapter domainesPersistenceAdapter(DomainesRepository domainesRepository,
			DomainesPersistenceMapper domainesPersistenceMapper) {
		return new DomainesPersistenceAdapter(domainesRepository, domainesPersistenceMapper);
	}

	@Bean
	public DomainesEventPublisherAdapter domainesEventPublisherAdapter(
			ApplicationEventPublisher applicationEventPublisher) {
		return new DomainesEventPublisherAdapter(applicationEventPublisher);
	}

	@Bean
	public DomainesService domainesService(DomainesPersistenceAdapter domainesPersistenceAdapter,
			DomainesEventPublisherAdapter domainesEventPublisherAdapter) {
		return new DomainesService(domainesPersistenceAdapter, domainesEventPublisherAdapter);
	}

}
