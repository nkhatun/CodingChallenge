package klr.coding.challenge.trial0;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EvaluateRPCNotationTest {
	 private EvaluateRPCNotation calc = new EvaluateRPCNotation();
	  @Test
	  public void shouldWorkForAnEmptyString() {
	    assertEquals(0, calc.evaluate(""), 0);
	  }
	  @Test
	  public void shouldParseNumbers() {
	    assertEquals(3, calc.evaluate("1 2 3"), 0);
	  }
	  @Test
	  public void shouldParseFloats() {
	    assertEquals(3.5, calc.evaluate("1 2 3.5"), 0);
	  }
	  @Test
	  public void shouldSupportAddition() {
	    assertEquals(4, calc.evaluate("1 3 +"), 0);
	  }
	  @Test
	  public void shouldSupportMultiplication() {
	    assertEquals(3, calc.evaluate("1 3 *"), 0);
	  }
	  @Test
	  public void shouldSupportSubtraction() {
	    assertEquals(-2, calc.evaluate("1 3 -"), 0);
	  }
	  @Test
	  public void shouldSupportDivision() {
	    assertEquals(2, calc.evaluate("4 2 /"), 0);
	  }
	  @Test
	  public void shouldSupportNegativeOperation() {
	    assertEquals(-2, calc.evaluate("-4 2 /"), 0);
	    assertEquals(-8, calc.evaluate("-4 2 *"), 0);
	    assertEquals(-6, calc.evaluate("-4 2 -"), 0);
	    assertEquals(-2, calc.evaluate("-4 2 +"), 0);
	  }
	    @Test
	  public void shouldHandleDecimalNo() {
	    assertEquals(-4.3, calc.evaluate("-12.9 3 /"), 0);
	  }
	     @Test
	  public void shouldHandleMultiDigit() {
	    assertEquals(4, calc.evaluate("12 3 /"), 0);
	  }
	   @Test
	  public void shouldHandleComplexExpr() {
	    assertEquals(14, calc.evaluate("5 1 2 + 4 * + 3 -"), 0);
	  }

}
