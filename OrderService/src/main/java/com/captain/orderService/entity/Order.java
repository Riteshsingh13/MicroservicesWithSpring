package com.captain.orderService.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderID;
	
	@Column(name = "PRODUCT_ID")
	private long productID;
	
	@Column(name = "QUANTITY")
	private long quantity;
	
	@Column(name = "ORDER_DATE")
	private Instant orderDate;
	
	@Column(name = "ORDER_STATUS")
	private String orderStatus;
	
	@Column(name = "TOTAL_AMOUNT")
	private long amount;	
}
