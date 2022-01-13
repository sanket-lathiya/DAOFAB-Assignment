package com.assignment.daofab.service;

import java.util.List;
import java.util.Optional;

import com.assignment.daofab.model.ParentTransaction;
import com.assignment.daofab.response.ChildTransactionsResponse;
import com.assignment.daofab.response.ParentTransactionsResponse;

/**
 * 
 * @author Sanket Lathiya
 *
 */
public interface ITransactionService {

	List<ParentTransactionsResponse> getParentTransactions(int page, int size);

	List<ChildTransactionsResponse> getChildTransactions(ParentTransaction parentTransaction);

	Optional<ParentTransaction> getParentTransaction(long parentId);

}
