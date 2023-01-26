package com.vision.nakala.infrastructure.adapters.input.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.vision.nakala.domain.model.Domaines;
import com.vision.nakala.infrastructure.adapters.input.rest.data.request.DomainesCreateRequest;
import com.vision.nakala.infrastructure.adapters.input.rest.data.request.DomainesUpdateRequest;
import com.vision.nakala.infrastructure.adapters.input.rest.data.response.DomainesQueryResponse;
import com.vision.nakala.infrastructure.adapters.input.rest.data.response.DomainesResponse;

@Mapper
public interface DomainesRestMapper {

	Domaines toDomaines(DomainesCreateRequest domainesCreateRequest);

	Domaines toDomaines(DomainesUpdateRequest domainesUpdateRequest);

	DomainesResponse toDomainesResponse(Domaines domaines);

	DomainesQueryResponse toDomainesQueryResponse(Domaines domaines);

	List<DomainesQueryResponse> toListDomainesQueryResponse(List<Domaines> domaines);

}