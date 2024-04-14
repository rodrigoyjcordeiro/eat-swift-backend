package br.com.eatswift.eatswiftbackend.resources.dto;

import br.com.eatswift.eatswiftbackend.domain.OrderDomain;
import lombok.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private String id;
    private String uid;
    private String address;
    private String establishment;
    private Double totalPrice;
    private List<ProductOrderDto> productsOrders;

    public OrderDto(OrderDomain orderDomain){
        this.id = orderDomain.getId();
        this.uid = orderDomain.getUid();
        this.address = orderDomain.getAddress();
        this.establishment = orderDomain.getEstablishment().getName();
        this.totalPrice = orderDomain.getTotalPrice();
        this.productsOrders = orderDomain.getProductsOrders().stream().map(ProductOrderDto::new).collect(Collectors.toList());

    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductOrderDto {
        private String productId;
        private Integer amount;
        private Double subtotal;

        public ProductOrderDto(OrderDomain.ProductOrderDomain productOrderDomain){
            this.productId = productOrderDomain.getProductDomain().getId();
            this.amount = productOrderDomain.getAmount();
            this.subtotal = productOrderDomain.getSubtotal();
        }

    }
}
