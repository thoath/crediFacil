package br.com.credifacil.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.credifacil.model.Result;

public interface ResultRepository extends MongoRepository<Result, String> {
	
	Result findBySubscription(String subscription);
	
}
