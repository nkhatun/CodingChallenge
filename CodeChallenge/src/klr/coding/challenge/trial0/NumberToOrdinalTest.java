package klr.coding.challenge.trial0;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
public class NumberToOrdinalTest {

	@Test
	  public void shouldHandleSingleDigits() {
	    assertEquals("1st", NumberToOrdinal.numberToOrdinal(1));
	    assertEquals("2nd", NumberToOrdinal.numberToOrdinal(2));
	    assertEquals("3rd", NumberToOrdinal.numberToOrdinal(3));
	  }
	   @Test
	   public void shouldHandleExceptionCase() {
	    assertEquals("10th", NumberToOrdinal.numberToOrdinal(10));
	    assertEquals("11th", NumberToOrdinal.numberToOrdinal(11));
	    assertEquals("12th", NumberToOrdinal.numberToOrdinal(12));
	  }
	   @Test
	  public void shouldHandleLongDigits() {
	    assertEquals("10000th", NumberToOrdinal.numberToOrdinal(10000));
	    assertEquals("100th", NumberToOrdinal.numberToOrdinal(100));

	  }
	   @Test
	    public void shouldHandleArgumentZero() {
	    assertEquals("0", NumberToOrdinal.numberToOrdinal(0));
	  }
	  @Test(expected = IllegalArgumentException.class)
	    public void shouldHandleLargeNo() throws Exception{
	    NumberToOrdinal.numberToOrdinal(10001);
	  }
	  @Test(expected = IllegalArgumentException.class)
	    public void shouldHandleNegativeNo() throws Exception{
	    NumberToOrdinal.numberToOrdinal(-100);
	  }

}
