package br.com.eatswift.eatswiftbackend.repository;

import br.com.eatswift.eatswiftbackend.domain.CategoryDomain;
import br.com.eatswift.eatswiftbackend.domain.ProductDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductDomain, String> {}
