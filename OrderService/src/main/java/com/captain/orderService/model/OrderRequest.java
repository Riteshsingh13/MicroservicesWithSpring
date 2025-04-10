package com.captain.orderService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {

	private long productId;
	private long quantity;
	private long totalAmount;
	private Payment paymentMode;
}
