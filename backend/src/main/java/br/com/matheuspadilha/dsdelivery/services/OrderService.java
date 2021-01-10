package br.com.matheuspadilha.dsdelivery.services;

import br.com.matheuspadilha.dsdelivery.dto.OrderDTO;
import br.com.matheuspadilha.dsdelivery.entities.Order;
import br.com.matheuspadilha.dsdelivery.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> list = repository.findOrdersWithProducts();

        return list.stream().map(OrderDTO::new).collect(Collectors.toList());
    }
}
