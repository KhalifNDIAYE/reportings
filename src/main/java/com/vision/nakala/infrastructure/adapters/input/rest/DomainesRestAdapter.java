package com.vision.nakala.infrastructure.adapters.input.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vision.nakala.application.ports.input.CreateDomainesUseCase;
import com.vision.nakala.application.ports.input.GetDomainesUseCase;
import com.vision.nakala.application.ports.input.ListDomainesUseCase;
import com.vision.nakala.application.ports.input.UpdateDomainesUseCase;
import com.vision.nakala.domain.model.Domaines;
import com.vision.nakala.infrastructure.adapters.input.rest.data.request.DomainesCreateRequest;
import com.vision.nakala.infrastructure.adapters.input.rest.data.request.DomainesUpdateRequest;
import com.vision.nakala.infrastructure.adapters.input.rest.data.response.DomainesQueryResponse;
import com.vision.nakala.infrastructure.adapters.input.rest.data.response.DomainesResponse;
import com.vision.nakala.infrastructure.adapters.input.rest.mapper.DomainesRestMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/reportings")
@RequiredArgsConstructor
public class DomainesRestAdapter {

	private final CreateDomainesUseCase createDomainesUseCase;

	private final GetDomainesUseCase getDomainesUseCase;

	private final UpdateDomainesUseCase updateDomainesUseCase;

	private final ListDomainesUseCase listDomainesUseCase;

	private final DomainesRestMapper domainesRestMapper;

	@PostMapping(value = "/domaines")
	public ResponseEntity<DomainesResponse> createDomaines(
			@RequestBody @Valid DomainesCreateRequest domainesCreateRequest) {
		// Requete vers domaine
		Domaines domaines = domainesRestMapper.toDomaines(domainesCreateRequest);

		domaines = createDomainesUseCase.createDomaines(domaines);

		// Domaine vers reponse
		return new ResponseEntity<>(domainesRestMapper.toDomainesResponse(domaines), HttpStatus.CREATED);
	}

	@PutMapping(value = "/domaines")
	public ResponseEntity<DomainesResponse> updateDomaines(
			@RequestBody @Valid DomainesUpdateRequest domainesUpdateRequest) {
		// Requete vers domaine
		Domaines domaines = domainesRestMapper.toDomaines(domainesUpdateRequest);

		domaines = updateDomainesUseCase.updateDomaines(domaines);

		// Domaine vers reponse
		return new ResponseEntity<>(domainesRestMapper.toDomainesResponse(domaines), HttpStatus.OK);
	}

	@GetMapping(value = "/domaines/{id}")
	public ResponseEntity<DomainesQueryResponse> getDomaines(@PathVariable Long id) {
		Domaines domaines = getDomainesUseCase.getDomainesById(id);
		return new ResponseEntity<>(domainesRestMapper.toDomainesQueryResponse(domaines), HttpStatus.OK);
	}

	@GetMapping(value = "/domaines")
	public ResponseEntity<List<DomainesQueryResponse>> listDomaines() {
		List<Domaines> domaines = listDomainesUseCase.listDomaines();
		return new ResponseEntity<>(domainesRestMapper.toListDomainesQueryResponse(domaines), HttpStatus.OK);
	}

}