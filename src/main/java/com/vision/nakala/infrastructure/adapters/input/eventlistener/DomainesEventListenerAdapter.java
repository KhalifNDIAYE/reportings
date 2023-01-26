package com.vision.nakala.infrastructure.adapters.input.eventlistener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.vision.nakala.domain.event.DomainesEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DomainesEventListenerAdapter {

	@EventListener
	public void handle(DomainesEvent event) {
		log.info("Domaine cree ou mis a jour avec l'id " + event.getId() + " a " + event.getDate());
	}

}