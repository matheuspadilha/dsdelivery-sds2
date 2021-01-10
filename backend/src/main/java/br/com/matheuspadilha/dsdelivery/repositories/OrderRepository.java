package br.com.matheuspadilha.dsdelivery.repositories;

import br.com.matheuspadilha.dsdelivery.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
