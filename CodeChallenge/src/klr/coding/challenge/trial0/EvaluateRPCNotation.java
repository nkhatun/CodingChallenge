package klr.coding.challenge.trial0;
import java.util.function.*;
import java.util.*;
public class EvaluateRPCNotation {

	  public double evaluate(String expr) {
	    // returning 0, incase of empty string
	    if(expr.isEmpty()){
	      return 0;
	    }
	    Stack<Double> numbers = new Stack<>();
	    Arrays.asList(expr.split(" ")).stream()
	      .forEach(number ->{
	        switch(number){
	            case "+":
	            calculate(numbers,(n1,n2) -> n2 + n1);
	            break;
	            case "-":
	            calculate(numbers,(n1,n2) -> n2 - n1);
	            break;
	            case "*":
	            calculate(numbers,(n1,n2) -> n2 * n1);
	            break;
	            case "/":
	            calculate(numbers,(n1,n2) -> n2 / n1);
	            break;
	            default:
	            numbers.push(Double.parseDouble(number));
	        }
	      });   
	    return numbers.pop();
	  }
	  
	protected static Stack<Double> calculate(Stack<Double> numbers,BiFunction<Double,Double,Double> operation){   numbers.push(operation.apply(numbers.pop(),numbers.pop()));   return numbers;
	                                             }
}
