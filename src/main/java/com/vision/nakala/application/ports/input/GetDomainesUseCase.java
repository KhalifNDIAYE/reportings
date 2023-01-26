package com.vision.nakala.application.ports.input;

import com.vision.nakala.domain.model.Domaines;

public interface GetDomainesUseCase {

	Domaines getDomainesById(Long id);
}
