package com.vision.nakala.infrastructure.adapters.input.rest.data.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DomainesUpdateRequest {

	@NotNull(message = "L'id ne peut pas être nul")
    private Long id;
	
    @NotEmpty(message = "Le nom ne peut pas être vide")
    private String name;

    @NotEmpty(message = "La description ne peut pas être vide")
    private String description;

}