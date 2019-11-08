package br.com.credifacil.dto.mapper;

import org.springframework.stereotype.Component;

import br.com.credifacil.dto.ResultDto;
import br.com.credifacil.model.Result;

@Component
public class ResultMapper {

	public static ResultDto toResultDto(Result result) {
		
		return new ResultDto(
				result.getApproved(),
				result.getLimit(),
				result.getResultMessage(),
				SubscriptionMapper.toSubscritpionDto(result.getSubscription())
		);
		
	}
}
