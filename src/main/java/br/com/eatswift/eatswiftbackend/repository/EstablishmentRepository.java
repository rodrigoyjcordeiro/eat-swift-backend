package br.com.eatswift.eatswiftbackend.repository;

import br.com.eatswift.eatswiftbackend.domain.EstablishmentDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstablishmentRepository extends MongoRepository<EstablishmentDomain, String> {
    List<EstablishmentDomain> findByIdCategory(String id);

}
