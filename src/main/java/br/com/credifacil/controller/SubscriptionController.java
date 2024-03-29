package br.com.credifacil.controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.credifacil.dto.SubscriptionDto;
import br.com.credifacil.model.Response;
import br.com.credifacil.model.Result;
import br.com.credifacil.model.Subscription;
import br.com.credifacil.service.ResultService;
import br.com.credifacil.service.SubscriptionService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/subscription")
public class SubscriptionController {
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@Autowired
	private ResultService resultService;
	
	@PostMapping
	public ResponseEntity<Response<SubscriptionDto>> store(@RequestBody @Valid Subscription subscription, BindingResult result){
		
		if (result.hasErrors()) {
			return ResponseEntity
					.ok()
					.body(new Response<>(null, result
							.getAllErrors()
							.stream()
							.map(error -> error.getDefaultMessage())
							.collect(Collectors.toList())
						));
		}
		
		SubscriptionDto sbs = new SubscriptionDto();
		
		try {
			sbs = subscriptionService.store(subscription);
		} catch(DuplicateKeyException ex) { 
			
			List<String> error = new ArrayList<>();
			
			error.add("Não foi possivel processar sua proposta, verifique se seu CPF já está cadastrado.");
			
			return ResponseEntity
					.ok()
					.body(new Response<>(null, error));
		}
		
		
		
		resultService.store(processSubscription(subscription));
		
		return ResponseEntity.ok().body(new Response<>(sbs, null));
	
		
	}

	private Result processSubscription(@Valid Subscription subscription) {
		
		Result result = new Result();
		int shares = subscription.getDependents() + 1;
		Double income = subscription.getIncome();
		
		result.setSubscription(subscription);
		
		if (ResultService.minIncome > (income / shares)) {
			result.setApproved(false);
			result.setResultMessage("Renda insuficiente.");
			return result;
		}
		
		if (subscription.getAge() < ResultService.minAge) {
			result.setApproved(false);
			result.setResultMessage("Não aprovado devido regras de crédito.");
			return result;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("De ");
		sb.append(NumberFormat.getCurrencyInstance().format(income + (income*ResultService.percentageMin) / 100));
		sb.append(" até ");
		sb.append(NumberFormat.getCurrencyInstance().format(income + (income *ResultService.percentageMax) / 100));
		
		result.setApproved(true);
		result.setResultMessage(sb.toString());
		
		return result;
	}

}
