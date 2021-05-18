package klr.coding.challenge.trial0;
import java.io.*;
import java.util.*;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
public class CreditCardMasking {
	private static final int SIZE = 6;
    private static final int NO_OF_LAST_CHARS_NOT_TO_MASK = 4;
  
    public static String maskify(String creditCardNumber) {
       // returning empty string, in case of empty credit card no
      if( creditCardNumber.isEmpty()){
        return "";
      }
      int cardLength = creditCardNumber.length();
      // if the card length is less than 6, then card no returned without masking
      if(cardLength < SIZE){
        return creditCardNumber;
      }
     
      StringBuilder sb = new StringBuilder();
      CharacterIterator it = new         StringCharacterIterator(creditCardNumber,0,cardLength,0);
      while(it.current() != CharacterIterator.DONE){
        // append the first charcter 
        if(it.getIndex() == 0){
          sb.append(it.current());
        }
        else if(it.getIndex() < cardLength - NO_OF_LAST_CHARS_NOT_TO_MASK){ 
          if(Character.isDigit(it.current())){//if the character is digit, mask it
            sb.append('#');
          }
          else{
            sb.append(it.current());
          }
        }
        else{
          sb.append(it.current());
        }
        it.next();
      }
      return sb.toString();
    }
}
