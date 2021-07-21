package com.demo;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		OrderMapper orderMapper = context.getBean(OrderMapper.class);

		PageHelper.startPage(5, 3);
		List<Order> orders = orderMapper.queryOrder();
		System.out.println(orders.size());
		for (Order o : orders) {
			System.out.println(o);
		}
	}
}
