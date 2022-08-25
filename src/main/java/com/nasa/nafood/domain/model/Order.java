package com.nasa.nafood.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter 
@Getter
@Entity(name = "order_")
public class Order {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private BigDecimal subTotal;
	
	private BigDecimal fee;
	
	private BigDecimal totalAmount;
	
	@Enumerated(EnumType.STRING)
	@JsonProperty(access = Access.READ_ONLY)
	private StatusOrder status;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> items = new ArrayList<>();
	
	@ManyToOne
	private Payment payment;
	
	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "datetime")
	private LocalDateTime createdAt;
	
	private LocalDateTime confirmedAt;
	
	private LocalDateTime canceledAt;
	
	private LocalDateTime finishedAt;
}
