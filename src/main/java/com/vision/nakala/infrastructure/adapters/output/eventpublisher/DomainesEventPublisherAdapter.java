package com.vision.nakala.infrastructure.adapters.output.eventpublisher;

import org.springframework.context.ApplicationEventPublisher;

import com.vision.nakala.application.ports.output.DomainesEventPublisher;
import com.vision.nakala.domain.event.DomainesEvent;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DomainesEventPublisherAdapter implements DomainesEventPublisher {

	private final ApplicationEventPublisher applicationEventPublisher;

	@Override
	public void publishDomainesEvent(DomainesEvent event) {
		applicationEventPublisher.publishEvent(event);
	}

}