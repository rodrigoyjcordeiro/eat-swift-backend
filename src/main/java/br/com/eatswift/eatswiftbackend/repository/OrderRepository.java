package br.com.eatswift.eatswiftbackend.repository;

import br.com.eatswift.eatswiftbackend.domain.EstablishmentDomain;
import br.com.eatswift.eatswiftbackend.domain.OrderDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<OrderDomain, String> {

    List<OrderDomain> findByEstablishment(EstablishmentDomain establishmentDomain);
    List<OrderDomain> findByUid(String uid);

}
