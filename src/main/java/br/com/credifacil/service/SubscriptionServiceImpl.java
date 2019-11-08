package br.com.credifacil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.credifacil.dto.SubscriptionDto;
import br.com.credifacil.dto.mapper.SubscriptionMapper;
import br.com.credifacil.model.Subscription;
import br.com.credifacil.repository.SubscriptionRepository;

@Component
public class SubscriptionServiceImpl implements SubscriptionService{
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Override
	public SubscriptionDto store(Subscription subscription) {
		return SubscriptionMapper.toSubscritpionDto(subscriptionRepository.save(subscription));
	}

}
