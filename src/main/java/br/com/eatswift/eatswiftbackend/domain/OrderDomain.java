package br.com.eatswift.eatswiftbackend.domain;


import br.com.eatswift.eatswiftbackend.resources.dto.OrderDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pedidos")
public class OrderDomain {

    @Id
    private String id;
    private String address;
    private String uid;
    private Double totalPrice;

    @DBRef(lazy = true)
    private EstablishmentDomain establishment;

    @Builder.Default
    private List<ProductOrderDomain> productsOrders = new ArrayList<>();


    public OrderDomain(OrderDto dto, EstablishmentDomain establishment){
        this.id = dto.getId();
        this.uid = dto.getUid();
        this.address = dto.getAddress();
        this.establishment = establishment;
        this.productsOrders = new ArrayList<>();
    }


    public Double addProduct(ProductDomain productDomain, Integer amount){
        var subtotal = productDomain.getPrice() * amount;
        ProductOrderDomain productOrderDomain = new ProductOrderDomain(productDomain, amount, subtotal);
        this.productsOrders.add(productOrderDomain);
        return subtotal;
    }


    public Double getTotalPrice(){
        return this.productsOrders.stream().mapToDouble(ProductOrderDomain::getSubtotal).sum();
    }


    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductOrderDomain {

        @DBRef(lazy = true)
        private ProductDomain productDomain;
        private Integer amount;
        private Double subtotal;

    }




}
