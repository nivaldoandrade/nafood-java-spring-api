package com.nasa.nafood.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class Address {
	
	@Column(name = "address_address")
	private String address;
	
	@Column(name = "address_number")
	private String number;
	
	@Column(name = "address_address2")
	private String address2;
	
	@Column(name = "address_district")
	private String district;
	
	@ManyToOne
	private City city;
}
