package com.devsuperior.desafio_componentes_injecao;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.desafio_componentes_injecao.entities.Order;
import com.devsuperior.desafio_componentes_injecao.services.OrderService;

@SpringBootApplication
public class DesafioComponentesInjecaoApplication implements CommandLineRunner {

	@Autowired
	private OrderService service;
	
	public static void main(String[] args) {
		SpringApplication.run(DesafioComponentesInjecaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ENTRADA (dados do pedido: código, valor básico, porcentagem de desconto)");

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Integer code = sc.nextInt();
		double basic = sc.nextDouble();
		double discount = sc.nextDouble();
	
		Order order = new Order(code, basic, discount);
		
		double total = service.total(order);
		
		System.out.println("Pedido código: " + order.getCode());
		System.out.println("Valor total: " + total);
		
		sc.close();
	}

}
