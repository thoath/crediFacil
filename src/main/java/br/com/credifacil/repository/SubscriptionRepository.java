package br.com.credifacil.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.credifacil.model.Subscription;

public interface SubscriptionRepository extends MongoRepository<Subscription, String>{
	
	Subscription findByDocument(String document);

}
