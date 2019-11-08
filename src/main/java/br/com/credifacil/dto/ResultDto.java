package br.com.credifacil.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@SuppressWarnings("rawtypes")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultDto implements Comparable{

	private boolean approved;
	private String limit;
	private String resultMessage;
	private SubscriptionDto subscriptionDto;

	public ResultDto() {}
	
	
	public ResultDto(boolean approved, String limit, String resultMessage, SubscriptionDto subscriptionDto) {
		super();
		this.approved = approved;
		this.limit = limit;
		this.resultMessage = resultMessage;
		this.subscriptionDto = subscriptionDto;
	}


	/**
	 * @return the approved
	 */
	public boolean isApproved() {
		return approved;
	}

	/**
	 * @param approved the approved to set
	 */
	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	/**
	 * @return the limit
	 */
	public String getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(String limit) {
		this.limit = limit;
	}

	/**
	 * @return the resultMessage
	 */
	public String getResultMessage() {
		return resultMessage;
	}

	/**
	 * @param resultMessage the resultMessage to set
	 */
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	/**
	 * @return the subscriptionDto
	 */
	public SubscriptionDto getSubscriptionDto() {
		return subscriptionDto;
	}


	/**
	 * @param subscriptionDto the subscriptionDto to set
	 */
	public void setSubscriptionDto(SubscriptionDto subscriptionDto) {
		this.subscriptionDto = subscriptionDto;
	}

	@Override
	public int compareTo(Object o) {
		return this.getSubscriptionDto().getName().compareTo(((ResultDto) o).getSubscriptionDto().getName());
	}

	

}
