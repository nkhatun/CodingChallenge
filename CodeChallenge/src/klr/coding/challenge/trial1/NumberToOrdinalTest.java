package klr.coding.challenge.trial1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class NumberToOrdinalTest {

	@Test
	  public void shouldHandleSingleDigits() {
	    assertEquals("1st", NumberToOrdinal.numberToOrdinal(1));
	    assertEquals("2nd", NumberToOrdinal.numberToOrdinal(2));
	    assertEquals("3rd", NumberToOrdinal.numberToOrdinal(3));
	  }
	  @Test(expected = IllegalArgumentException.class)
	    public void shouldCheckIllegalArgumentException() {
	      Integer number = null;
	      fail(NumberToOrdinal.numberToOrdinal(number));
	    }
	   @Test
	  public void shouldHandleEdgeCases() {
	    assertEquals("10th", NumberToOrdinal.numberToOrdinal(10));
	    assertEquals("11th", NumberToOrdinal.numberToOrdinal(11));
	    assertEquals("12th", NumberToOrdinal.numberToOrdinal(12));
	    assertEquals("13th", NumberToOrdinal.numberToOrdinal(13));
	  }
	   @Test(expected = IllegalArgumentException.class)
	  public void shouldHandleRangeOfNumber() {
	    fail(NumberToOrdinal.numberToOrdinal(100000));
	    fail(NumberToOrdinal.numberToOrdinal(-90));
	  }
	   @Test
	  public void shouldHandleZero() {
	    assertEquals("0", NumberToOrdinal.numberToOrdinal(0));
	  }
	   @Test
	  public void shouldHandleOtherNumbers() {
	    assertEquals("112th", NumberToOrdinal.numberToOrdinal(112));
	    assertEquals("92nd", NumberToOrdinal.numberToOrdinal(92));
	    assertEquals("33rd", NumberToOrdinal.numberToOrdinal(33));
	    assertEquals("51st", NumberToOrdinal.numberToOrdinal(51));
	  }
}
