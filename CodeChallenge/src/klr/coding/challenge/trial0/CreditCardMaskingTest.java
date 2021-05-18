package klr.coding.challenge.trial0;

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
	    }
	     @Test
	    public void shouldNotMaskString() {
	        assertEquals("Skippy", CreditCardMasking.maskify("Skippy"));
	    }
	    @Test
	    public void shouldMaskDashedCreditCardMaskings() {
	        assertEquals("4###-####-####-5616", CreditCardMasking.maskify("4556-3646-0793-5616"));
	      assertEquals("ABCD-EFGH-IJKLM-NOPQ", CreditCardMasking.maskify("ABCD-EFGH-IJKLM-NOPQ"));
	    }
	   @Test
	    public void shouldNotMaskNonDigitCreditCardMaskings() {
	        assertEquals("A#######BCDEFG89HI", CreditCardMasking.maskify("A1234567BCDEFG89HI"));
	      assertEquals("1#####deaf", CreditCardMasking.maskify("123456deaf"));
	    }

}
