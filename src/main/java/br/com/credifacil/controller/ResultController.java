package br.com.credifacil.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.credifacil.dto.ResultDto;
import br.com.credifacil.model.Response;
import br.com.credifacil.model.Subscription;
import br.com.credifacil.repository.SubscriptionRepository;
import br.com.credifacil.service.ResultService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/result")
public class ResultController {

	@Autowired
	private ResultService resultService;
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@GetMapping("/{cpf}")
	public ResponseEntity<Response<ResultDto>> show(@PathVariable(value="cpf") String cpf){
		
		Subscription subs = subscriptionRepository.findByDocument(cpf);
		
		if (subs == null) {
			List<String>  errors = new ArrayList<>();
			errors.add("Proposta não encontrada.");
			return ResponseEntity.ok().body(new Response<>(null, errors));
		}
		
		
		
		return ResponseEntity.ok().body(new Response<>(resultService.show(subs.getId()), null));
	
		
	}
	
}
