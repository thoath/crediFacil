package br.com.credifacil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.credifacil.dto.ResultDto;
import br.com.credifacil.dto.mapper.ResultMapper;
import br.com.credifacil.model.Result;
import br.com.credifacil.repository.ResultRepository;

@Component
public class ResultServiceImpl implements ResultService{

	@Autowired
	private ResultRepository resultRepository;
	
	@Override
	public Boolean store(Result result) {
		
		try {
			resultRepository.save(result);
		} catch(Exception ex) {
			return Boolean.FALSE;
		}
		
		
		return Boolean.TRUE;
	}

	@Override
	public ResultDto show(String subscription) {
		return ResultMapper.toResultDto(resultRepository.findBySubscription(subscription));
	}

}
