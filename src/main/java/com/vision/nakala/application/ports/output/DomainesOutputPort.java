package com.vision.nakala.application.ports.output;

import java.util.List;
import java.util.Optional;

import com.vision.nakala.domain.model.Domaines;

public interface DomainesOutputPort {

	Domaines saveDomaines(Domaines domaines);

	Domaines updateDomaines(Domaines domaines);

	List<Domaines> listDomaines();

	Optional<Domaines> getDomainesById(Long id);

}