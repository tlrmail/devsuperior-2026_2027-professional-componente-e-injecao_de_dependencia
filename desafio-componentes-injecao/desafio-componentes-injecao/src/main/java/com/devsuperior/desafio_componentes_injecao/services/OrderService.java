package com.devsuperior.desafio_componentes_injecao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.desafio_componentes_injecao.entities.Order;

@Service
public class OrderService {

	@Autowired
	private ShippingService shippingService;

	public double total(Order order) {
		double basic = order.getBasic();
		double discount = order.getDiscount() / 100;
		double shipment = shippingService.shipment(order);
		
		return basic - (basic * discount) + shipment;
	}

}
