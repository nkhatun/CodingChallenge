package klr.coding.challenge.trial0;
import java.util.*;
public class NumberToOrdinal {
	public static String numberToOrdinal( Integer number ) throws IllegalArgumentException{
	    // '0' is returned if input number is 0
	    if (number == 0) return "0";
	    // checking the input number constraints
	    StringBuilder sb = new StringBuilder();
	    if(number >= 0 && number <= 10000){
	    switch (number % 100) {
	    case 11:
	    case 12:
	    case 13:
	        sb.append(number).append("th");
	        break;
	    default:
	         // getting the ordinal value, based on the last digit
	         sb.append(number).append(OrdinalENum.getValueByOrdinal((number % 10)));
	    }
	    }
	    else{
	          // if the input number is outside the provided range
	        throw new IllegalArgumentException("Input is not in specified range: 0 ≤ number ≤ 10000");
	      }
	   return sb.toString();
	  }
	  
	  enum OrdinalENum{ ZERO("th"),FIRST("st"),SECOND("nd"),THIRD("rd"),FOURTH("th"),FIFTH("th"),SIXTH("th"),SEVENTH("th"),EIGHTH("th"),NINTH("th");
	        private static HashMap<Integer, OrdinalENum> lookup = new HashMap<>();
	     // creating a map to put the enum values per index              
	     static {
	       int ordinal = 0;
	      for (OrdinalENum ordEnum : EnumSet.allOf(OrdinalENum.class)) {
	      lookup.put(ordinal, ordEnum);
	      ordinal+= 1;
	    }
	    }
	    private final String val;
	     private OrdinalENum (final String v) { val = v; }
	     public String getVal() { return val; }
	    // get enum value by index
	    public static String getValueByOrdinal(int id) {
	        return lookup.get(id).getVal();
	    }
	    }
}
