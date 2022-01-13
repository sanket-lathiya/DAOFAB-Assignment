package com.assignment.daofab.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.daofab.exception.InvalidParentIdException;
import com.assignment.daofab.model.ParentTransaction;
import com.assignment.daofab.response.ChildTransactionsResponse;
import com.assignment.daofab.response.ParentTransactionsResponse;
import com.assignment.daofab.service.ITransactionService;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author Sanket Lathiya
 *
 */
@RestController
@RequestMapping("/daofab-api/v1")
public class TransactionController {
	
	@Autowired
	private ITransactionService transactionService;
	
	private Logger logger = LoggerFactory.getLogger(TransactionController.class);

	@GetMapping("/parent-transactions")
	public ResponseEntity<String> getParentTransactions(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size){
		String response;
        HttpStatus status = HttpStatus.OK;
        
		if(page == null)
			page = 0; //Default page number
		
		if(size == null)
			size = 2; //Default page size
		
		try {
			List<ParentTransactionsResponse> parentTransactions = transactionService.getParentTransactions(page, size);
			response = new GsonBuilder().serializeNulls().create().toJson(parentTransactions);
		} catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response = "Exception fetching parent transactions.";
			logger.error(response, e);
		}
		
		return ResponseEntity
				.status(status)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
	}
	
	@GetMapping("/child-transactions/{parentId}")
	public ResponseEntity<String> getChildTransactions(@PathVariable("parentId") long parentId){
		String response;
        HttpStatus status = HttpStatus.OK;
        
		try {
			Optional<ParentTransaction> parent = transactionService.getParentTransaction(parentId);
			
			if(!parent.isPresent()) {
				throw new InvalidParentIdException();
			}
			
			List<ChildTransactionsResponse> childTransactions = transactionService.getChildTransactions(parent.get());
			response = new GsonBuilder().serializeNulls().create().toJson(childTransactions);
		}catch (InvalidParentIdException e) {
			status = HttpStatus.BAD_REQUEST;
			response = "Invalid parent id.";
		}catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response = "Exception fetching child transactions.";
			logger.error(response, e);
		}
		
		return ResponseEntity
				.status(status)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
	}
}
