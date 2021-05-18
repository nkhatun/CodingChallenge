package klr.coding.challenge.trial1;

import java.util.logging.Logger;

public class NumberToOrdinal {
	   private static Logger log = Logger.getLogger(NumberToOrdinal.class.getName());

	   public static String numberToOrdinal( Integer number ) {
	     //Check the number if null
	     if(number == null ){
	           log.info("Throwing exception incase of null input");
	       throw new IllegalArgumentException("Invalid number "+number);
	     }  
	     //Check the number if zero
	     if(number == 0){
	       return Integer.toString(0);
	     }
	     //Check the number is within range
	     if(number >= 0 && number <= 10000){
	       return convertNumberToOrdinal(number);
	     }
	     else{
	       log.info("Throwing exception incase of input is out of range");
	        throw new IllegalArgumentException("Number is not specified in the range :0 ≤ number ≤ 10000 "+number);
	     }
	   }
	   
	   private static String convertNumberToOrdinal( Integer number ){
	     String[]  ordinalArr= {"th","st","nd","rd","th","th","th","th","th","th"};
	     StringBuilder sb = new StringBuilder();
	     switch(number%100){
	       case 11:
	       case 12:
	       case 13:
	         sb.append(number).append("th");
	         break;
	       default:
	         sb.append(number).append(ordinalArr[number%10]);
	     }
	     return sb.toString();
	   }
}
