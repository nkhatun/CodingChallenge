package klr.coding.challenge;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionService {
	public BigDecimal getAmountByCategoryInPeriod(List<Transaction> transactionsList,String category,Date startTime,Date  endTime){
		return transactionsList.stream()
		.filter((transaction)-> (transaction.getAmount().signum() == -1) && 
				(transaction.getCategory().equalsIgnoreCase(category)) && 
				withinTimeRange(transaction.getTime(), startTime, endTime))
		.map((map) -> map.getAmount())
		.reduce(BigDecimal.ZERO,BigDecimal::add);
	}
	
	private boolean withinTimeRange(Date transactionDate, Date startDate, Date endDate) {
		return transactionDate.getTime() >= startDate.getTime() &&
				transactionDate.getTime() <= endDate.getTime();
	}
	
	public  List<List<Transaction>> findDuplicateTransactions(List<Transaction> transactions){
		List<List<Transaction>> dupliactesGroupList  = new ArrayList<List<Transaction>>();
		//TODO time interval check for 1 min less
		//TODO grouping by distinct transaction group
		transactions.stream().forEach((transaction) ->{
			List<Transaction> duplicatesList = new ArrayList<Transaction>();
			boolean present = transactions.stream().anyMatch((trans) ->{ 
			    long elapsed = trans.getTime().getTime() - transaction.getTime().getTime() ; 
				int hours = (int) Math.floor(elapsed / 3600000);
	            int minutes = (int) Math.floor((elapsed - hours * 3600000) / 60000);
	            int seconds = (int) Math.floor((elapsed - hours * 3600000 - minutes * 60000) / 1000);
				return (!transaction.getId().equals(trans.getId()))
					 && (seconds >= 0 && seconds <= 60)
	        		  && (trans.getSourceAccount().equals(transaction.getSourceAccount())) 
	        		  && (trans.getTargetAccount().equals(transaction.getTargetAccount()))
	        		  && (trans.getAmount().equals(transaction.getAmount()))
	        		  && (trans.getCategory().equals(transaction.getCategory()));}
					);
			if(present) {
				System.out.println("transaction "+transaction);
				duplicatesList.add(transaction);
			}
			dupliactesGroupList.add(duplicatesList);
		});
		return dupliactesGroupList;
	}


}
