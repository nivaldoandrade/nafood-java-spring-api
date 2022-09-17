package com.nasa.nafood.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.nasa.nafood.domain.model.Cookery;

import lombok.Data;
import lombok.NonNull;

@JsonRootName("cookeries")
@Data
public class CookeryXmlWrapper {

	@JsonProperty("cookery")
//	@JacksonXmlElementWrapper(useWrapping = false)
	@NonNull
	private List<Cookery> cookeries;
}
