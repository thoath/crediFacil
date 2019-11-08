package br.com.credifacil.service;

import br.com.credifacil.dto.ResultDto;
import br.com.credifacil.model.Result;

public interface ResultService {
	
	double minIncome = 1000;
	int percentageMin = 20;
	int percentageMax = 45;
	int minAge = 21;
	
	Boolean store(Result result);
	ResultDto show(String subscription);

}
