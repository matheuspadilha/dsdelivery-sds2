package br.com.matheuspadilha.dsdelivery.dto;

import br.com.matheuspadilha.dsdelivery.entities.Order;
import br.com.matheuspadilha.dsdelivery.entities.OrderStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String address;
    private Double latitude;
    private Double longitude;
    private Instant moment;
    private OrderStatus status;

    @Setter(value = AccessLevel.NONE)
    private List<ProductDTO> products = new ArrayList<>();

    public OrderDTO() {}

    public OrderDTO(Long id, String address, Double latitude, Double longitude, Instant moment, OrderStatus status) {
        this.id = id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.moment = moment;
        this.status = status;
    }

    public OrderDTO(Order entity) {
        id = entity.getId();
        address = entity.getAddress();
        latitude = entity.getLatitude();
        longitude = entity.getLongitude();
        moment = entity.getMoment();
        status = entity.getStatus();
        products = entity.getProducts().stream().map(ProductDTO::new).collect(Collectors.toList());
    }
}
