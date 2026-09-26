package com.devsuperior.desafio_componentes_injecao.services;

import org.springframework.stereotype.Service;

import com.devsuperior.desafio_componentes_injecao.entities.Order;

@Service
public class ShippingService {

	public double shipment(Order order) {
		double valorBasico = order.getBasic();
		double frete = 0;
		
		if(valorBasico < 100) {
			frete = 20;
		}else if(valorBasico <= 200) {
			frete = 12;
		}
		
		return frete;
	}
	
}
