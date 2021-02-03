package com.api.foodorder.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value= "bank-service", url = "http://localhost:8081/transferFund")
public interface CallToBankApplication {

	@GetMapping("/transferFunds")
	public String completePayment(@RequestParam String fromAccountNumber,@RequestParam String toAccountNumber,@RequestParam String amount);

}
