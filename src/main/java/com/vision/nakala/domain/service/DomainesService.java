package com.vision.nakala.domain.service;

import java.util.List;

import com.vision.nakala.application.ports.input.CreateDomainesUseCase;
import com.vision.nakala.application.ports.input.GetDomainesUseCase;
import com.vision.nakala.application.ports.input.ListDomainesUseCase;
import com.vision.nakala.application.ports.input.UpdateDomainesUseCase;
import com.vision.nakala.application.ports.output.DomainesEventPublisher;
import com.vision.nakala.application.ports.output.DomainesOutputPort;
import com.vision.nakala.domain.event.DomainesEvent;
import com.vision.nakala.domain.exception.DomainesNotFound;
import com.vision.nakala.domain.model.Domaines;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DomainesService
		implements CreateDomainesUseCase, GetDomainesUseCase, ListDomainesUseCase, UpdateDomainesUseCase {

	private final DomainesOutputPort domainesOutputPort;

	private final DomainesEventPublisher domainesEventPublisher;

	@Override
	public Domaines getDomainesById(Long id) {
		return domainesOutputPort.getDomainesById(id)
				.orElseThrow(() -> new DomainesNotFound("Domaine non trouver avec l'id: " + id));
	}

	@Override
	public Domaines createDomaines(Domaines domaines) {
		domaines = domainesOutputPort.saveDomaines(domaines);
		domainesEventPublisher.publishDomainesEvent(new DomainesEvent(domaines.getId()));
		return domaines;
	}

	@Override
	public Domaines updateDomaines(Domaines domaines) {
		domaines = domainesOutputPort.updateDomaines(domaines);
		domainesEventPublisher.publishDomainesEvent(new DomainesEvent(domaines.getId()));
		return domaines;
	}

	@Override
	public List<Domaines> listDomaines() {
		return domainesOutputPort.listDomaines();
	}

}
