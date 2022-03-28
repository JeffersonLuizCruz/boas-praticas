package com.restexception.restexception.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CustomerDTO {
	
	private Long id;
	
	@NotBlank(message = "{name.not.blank}")
	@NotNull(message = "{name.not.null}")
	private String name;
	
    @NotNull(message = "{description.not.blank}")
    @NotBlank(message = "{description.not.null}")
	private String description;
	
    @NotNull(message = "{observation.not.blank}")
    @NotBlank(message = "{observation.not.null}")
	private String observation;

}
