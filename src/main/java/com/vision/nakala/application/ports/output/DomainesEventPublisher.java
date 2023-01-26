package com.vision.nakala.application.ports.output;

import com.vision.nakala.domain.event.DomainesEvent;

public interface DomainesEventPublisher {

	void publishDomainesEvent(DomainesEvent event);
}
