package klr.coding.challenge.trial1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CreditCardMaskingTest {
	 @Test
	    public void shouldMaskDigitsForBasicCreditCardMaskings() {
	        assertEquals("5###########0694", CreditCardMasking.maskify("5512103073210694"));
	    }

	    @Test
	    public void shouldNotMaskDigitsForShortCreditCardMaskings() {
	        assertEquals("54321", CreditCardMasking.maskify("54321"));
	    }
	  
	  @Test
	    public void shouldHandleEmptyString() {
	        assertEquals("", CreditCardMasking.maskify(""));
	        assertEquals("", CreditCardMasking.maskify("  "));
	    }
	  @Test
	    public void shouldNotMaskString() {
	        assertEquals("Skippy", CreditCardMasking.maskify("Skippy"));
	        assertEquals("NoSkippy123", CreditCardMasking.maskify("NoSkippy123"));
	    }
	  @Test
	    public void shouldMaskDashedCC() {
	        assertEquals("ABCD-EFGH-IJKLM-NOPQ", CreditCardMasking.maskify("ABCD-EFGH-IJKLM-NOPQ"));
	        assertEquals("4###-####-####-5616", CreditCardMasking.maskify("4556-3646-0793-5616"));
	      assertEquals("4###-####-STUV-5616", CreditCardMasking.maskify("4556-3646-STUV-5616"));
	    }
	   @Test
	    public void shouldMaskNonDashedCC() {
	        assertEquals("4###########5616", CreditCardMasking.maskify("4556364607935616"));
	    }
	  @Test
	    public void shouldNotMaskNonDigitCC() {
	            assertEquals("A#######BCDEFG89HI", CreditCardMasking.maskify("A1234567BCDEFG89HI"));
	    }
	   @Test
	    public void shouldNotMaskLessThanSixDigitCC() {
	            assertEquals("12345", CreditCardMasking.maskify("12345"));
	            assertEquals("1#3456", CreditCardMasking.maskify("123456"));
	    }
	  @Test(expected = IllegalArgumentException.class)
	    public void shouldCheckIllegalArgumentException() {
	      String s = null;
	      fail( CreditCardMasking.maskify(s));
	    }

}
