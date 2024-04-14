package br.com.eatswift.eatswiftbackend.service;

import br.com.eatswift.eatswiftbackend.domain.EstablishmentDomain;
import br.com.eatswift.eatswiftbackend.domain.OrderDomain;
import br.com.eatswift.eatswiftbackend.domain.ProductDomain;
import br.com.eatswift.eatswiftbackend.repository.EstablishmentRepository;
import br.com.eatswift.eatswiftbackend.repository.OrderRepository;
import br.com.eatswift.eatswiftbackend.repository.ProductRepository;
import br.com.eatswift.eatswiftbackend.resources.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final EstablishmentRepository establishmentRepository;
    private final ProductRepository productRepository;

    public OrderDto save(OrderDto orderDto){
        String establishmentId = orderDto.getEstablishment();
        Optional<EstablishmentDomain> establishmentDomainOptional = this.establishmentRepository.findById(establishmentId);

        if(establishmentDomainOptional.isPresent()){
            EstablishmentDomain establishmentDomain = establishmentDomainOptional.get();
            OrderDomain orderDomain = new OrderDomain(orderDto, establishmentDomain);

            orderDto.getProductsOrders().forEach(p-> {
                Optional<ProductDomain> optionalProductDomain = productRepository.findById(p.getProductId());
                if(optionalProductDomain.isPresent()){
                    ProductDomain productDomain = optionalProductDomain.get();
                    orderDomain.addProduct(productDomain, p.getAmount());
                }
            });
            Double totalPrice = orderDomain.getTotalPrice();
            log.info(" O preço total do pedido é: " + totalPrice);
            OrderDomain orderSaved = orderRepository.save(orderDomain);
            return new OrderDto(orderSaved);

        }
        return null;
    }

    public List<OrderDto> findAllByEstablishment(String establishmentId){
        Optional<EstablishmentDomain> establishmentDomain = this.establishmentRepository.findById(establishmentId);
        if(establishmentDomain.isPresent()){
            List<OrderDomain> orders = this.orderRepository.findByEstablishment(establishmentDomain.get());
            return orders.stream().map(OrderDto::new).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public List<OrderDto> findAllByUser(String userId){
        List<OrderDomain> orders= this.orderRepository.findByUid(userId);
        return orders.stream().map(OrderDto::new).collect(Collectors.toList());
    }


}
