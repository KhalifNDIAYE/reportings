package com.vision.nakala.infrastructure.adapters.output.persistence;

import java.util.List;
import java.util.Optional;

import com.vision.nakala.application.ports.output.DomainesOutputPort;
import com.vision.nakala.domain.model.Domaines;
import com.vision.nakala.infrastructure.adapters.output.persistence.entity.DomainesEntity;
import com.vision.nakala.infrastructure.adapters.output.persistence.mapper.DomainesPersistenceMapper;
import com.vision.nakala.infrastructure.adapters.output.persistence.repository.DomainesRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DomainesPersistenceAdapter implements DomainesOutputPort {

	private final DomainesRepository domainesRepository;

	private final DomainesPersistenceMapper domainesPersistenceMapper;

	@Override
	public Domaines saveDomaines(Domaines domaines) {
		DomainesEntity domainesEntity = domainesPersistenceMapper.toDomainesEntity(domaines);
		domainesEntity = domainesRepository.save(domainesEntity);
		return domainesPersistenceMapper.toDomaines(domainesEntity);
	}

	@Override
	public Optional<Domaines> getDomainesById(Long id) {
		Optional<DomainesEntity> domainesEntity = domainesRepository.findById(id);

		if (domainesEntity.isEmpty()) {
			return Optional.empty();
		}

		Domaines domaines = domainesPersistenceMapper.toDomaines(domainesEntity.get());
		return Optional.of(domaines);
	}

	@Override
	public Domaines updateDomaines(Domaines domaines) {
		DomainesEntity domainesEntity = domainesPersistenceMapper.toDomainesEntity(domaines);
		domainesEntity = domainesRepository.saveAndFlush(domainesEntity);
		return domainesPersistenceMapper.toDomaines(domainesEntity);
	}

	@Override
	public List<Domaines> listDomaines() {
		List<DomainesEntity> domainesEntities = domainesRepository.findAll();
		return domainesPersistenceMapper.toListDomaines(domainesEntities);
	}

}