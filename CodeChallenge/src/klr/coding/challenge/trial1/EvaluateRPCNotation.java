package klr.coding.challenge.trial1;
import java.util.Arrays;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.logging.Logger;

public class EvaluateRPCNotation {
	private static Logger log = Logger
			.getLogger(EvaluateRPCNotation.class.getName());
	public double evaluate(String expr) {
		// Evaluating Empty Expression
		if (expr.isEmpty() || expr.trim().length() == 0) {
			return 0;
		}
		Stack<Double> numbers = new Stack<>();
		Arrays.stream(expr.split(" ")).forEach(exprStr -> {
			// Check if the expression is valid
			if (isNumericInput(exprStr) || isOperator(exprStr)) {
				switch (exprStr) {
					case "+" :
						calculate(numbers, (n1, n2) -> n2 + n1);
						break;
					case "-" :
						calculate(numbers, (n1, n2) -> n2 - n1);
						break;
					case "*" :
						calculate(numbers, (n1, n2) -> n2 * n1);
						break;
					case "/" :
						calculate(numbers, (n1, n2) -> n2 / n1);
						break;
					default :
						numbers.push(Double.parseDouble(exprStr));
				}
			} else {
				log.info("Throwing exception incase of invalid expression");
				throw new IllegalArgumentException("Invalid Expression");
			}
		});
		return numbers.pop();
	}

	protected static Stack<Double> calculate(Stack<Double> numbers,
			BiFunction<Double, Double, Double> operation) {
		numbers.push(operation.apply(numbers.pop(), numbers.pop()));
		return numbers;
	}

	private static boolean isNumericInput(String input) {
		try {
			Double.parseDouble(input);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
	private static boolean isOperator(String input) {
		String operators = "+-*/";
		return operators.contains(input) ? true : false;
	}
}
