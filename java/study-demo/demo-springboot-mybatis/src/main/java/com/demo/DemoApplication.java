package com.demo;

import com.github.pagehelper.Page;
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


		Page<Order> orders = PageHelper.startPage(1, 2).doSelectPage(() -> orderMapper.queryOrder());
		System.out.println(orders.size());
		System.out.println(orders);
		for (Order o : orders) {
			System.out.println(o);
		}
	}
}
