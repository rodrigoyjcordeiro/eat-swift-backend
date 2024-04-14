package br.com.eatswift.eatswiftbackend.repository;

import br.com.eatswift.eatswiftbackend.domain.CategoryDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<CategoryDomain, String> {}
