package br.com.credifacil.dto.mapper;

import org.springframework.stereotype.Component;

import br.com.credifacil.dto.SubscriptionDto;
import br.com.credifacil.model.Subscription;

@Component
public class SubscriptionMapper {
	
	public static SubscriptionDto toSubscritpionDto(Subscription subscription) {
		return new SubscriptionDto(
				subscription.getId(), 
				subscription.getName(),
				subscription.getAge(), 
				subscription.getGender(),
				subscription.getCivilStatus(),
				subscription.getState(),
				subscription.getDependents(), 
				subscription.getIncome());
				
	}

}
