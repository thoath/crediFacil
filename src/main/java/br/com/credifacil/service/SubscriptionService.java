package br.com.credifacil.service;

import br.com.credifacil.dto.SubscriptionDto;
import br.com.credifacil.model.Subscription;

public interface SubscriptionService {
	
	SubscriptionDto store(Subscription subscription);

}
