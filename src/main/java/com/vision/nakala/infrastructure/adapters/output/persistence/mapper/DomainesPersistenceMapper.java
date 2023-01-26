package com.vision.nakala.infrastructure.adapters.output.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.vision.nakala.domain.model.Domaines;
import com.vision.nakala.infrastructure.adapters.output.persistence.entity.DomainesEntity;

@Mapper
public interface DomainesPersistenceMapper {

	DomainesEntity toDomainesEntity(Domaines domaines);

	Domaines toDomaines(DomainesEntity domainesEntity);

	List<Domaines> toListDomaines(List<DomainesEntity> domainesEntity);

}