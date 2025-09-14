package com.devsuperior.desafioum.service;

import com.devsuperior.desafioum.entites.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order) {
        double discount = order.getBasic() * (order.getDiscount() / 100.0);
        return order.getBasic() - discount + shippingService.shipment(order);
    }
}
