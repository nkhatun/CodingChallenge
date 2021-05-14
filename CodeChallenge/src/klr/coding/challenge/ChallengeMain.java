package klr.coding.challenge;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChallengeMain {

	public static void main(String[] args) throws Exception {
		System.out.println("Hey there!");
		List<Transaction> transactionList = new ArrayList<Transaction>();
		long epoch1 = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/03/2021 01:33:00").getTime() / 1000;
		long epoch2 = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/03/2021 01:33:50").getTime() / 1000;
		long epoch3 = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/03/2021 01:34:30").getTime() / 1000;
		long epoch4 = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/03/2021 01:36:00").getTime() / 1000;
		long epoch5 = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/03/2021 01:36:30").getTime() / 1000;

		long startTime = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/03/2021 01:00:00").getTime() / 1000;
		long endTime = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("04/03/2021 01:00:00").getTime() / 1000;

		Transaction transaction1 = new Transaction(1L,"source 1","traget 1",BigDecimal.valueOf(-60),"Spring",new Date(epoch1*1000));
		Transaction transaction2 = new Transaction(2L,"source 1","traget 1",BigDecimal.valueOf(-60),"Spring",new Date(epoch2*1000));
		Transaction transaction3 = new Transaction(3L,"source 1","traget 1",BigDecimal.valueOf(-60),"Spring",new Date(epoch3*1000));
		Transaction transaction4 = new Transaction(4L,"source 2","traget 2",BigDecimal.valueOf(-80),"Summer",new Date(epoch4*1000));
		Transaction transaction5 = new Transaction(5L,"source 2","traget 2",BigDecimal.valueOf(-80),"Summer",new Date(epoch5*1000));

		transactionList.add(transaction1);
		transactionList.add(transaction2);
		transactionList.add(transaction3);
		transactionList.add(transaction4);
		transactionList.add(transaction5);
		TransactionService service = new TransactionService();
		BigDecimal totalAmount = service.getAmountByCategoryInPeriod(transactionList, "Spring", new Date(startTime*1000), new Date(endTime*1000));
		System.out.println("Total Amount :"+totalAmount);
		List<List<Transaction>>  duplicateGroup =service.findDuplicateTransactions(transactionList);
		System.out.println("Duplicate Group:"+duplicateGroup);
		duplicateGroup.stream().forEach((superList)-> superList.stream().forEach((sub)->System.out.println(sub.getId())));

	}

}
