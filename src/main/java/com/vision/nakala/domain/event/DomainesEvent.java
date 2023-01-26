package com.vision.nakala.domain.event;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DomainesEvent {

	private Long id;

	private LocalDateTime date;

	public DomainesEvent(Long id) {
		this.id = id;
		this.date = LocalDateTime.now();
	}

}
