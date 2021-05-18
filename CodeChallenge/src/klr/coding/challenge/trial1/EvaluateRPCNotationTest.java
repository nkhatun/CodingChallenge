package klr.coding.challenge.trial1;

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
	  public void shouldHandleEmptyExpr() {
	    assertEquals(0, calc.evaluate(" "),0);
	    assertEquals(0, calc.evaluate(""),0);
	  }
	   @Test
	  public void shouldHandleInvalidExpr() {
	    try{
	      calc.evaluate("1 3+");
	      fail("failed");
	    }
	    catch(IllegalArgumentException ex){
	      assertEquals(ex.getMessage(),"Invalid Expression");
	    }
	  }
	   @Test
	  public void shouldHandleNonExpr() throws NumberFormatException{
	   try{
	      calc.evaluate("abcdefe");
	      fail("failed");
	    }
	    catch(IllegalArgumentException ex){
	      assertEquals(ex.getMessage(),"Invalid Expression");
	    } 
	  }
	  
	   @Test
	  public void shouldSupportHalfDivision() {
	    assertEquals(2.5, calc.evaluate("5 2 /"), 0);
	  }
	  
	   @Test
	  public void shouldSupportNegativeOperation() {
	    assertEquals(-2.5, calc.evaluate("-5 2 /"), 0);
	    assertEquals(-10, calc.evaluate("-5 2 *"), 0);
	    assertEquals(-7, calc.evaluate("-5 2 -"), 0);
	    assertEquals(-3, calc.evaluate("-5 2 +"), 0);
	  }
	   @Test
	  public void shouldSupportDecimalNo() {
	    assertEquals(2.89 ,calc.evaluate("5.78 2 /"), 0);
	  }

}
