import edu.duke.*;
/**
 * Write a description of class CaesarCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarCipher
{
    public String encrypt(String input, int key)
    {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabetMaj = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetMin = "abcdefghijklmnopqrstuvwxyz";
        //Compute the shiftedAlphabet
        String shiftedAlphabetMaj = alphabetMaj.substring(key)+alphabetMaj.substring(0,key);
        String shiftedAlphabetMin = alphabetMin.substring(key)+alphabetMin.substring(0,key);
        int idx; String shiftedAlphabet;
        //Count from 0 to lentgth of encrypted, (call it i)
        for(int i=0; i<encrypted.length(); i++)
        {
            //Look at the ith character of encrypted (call it currChar))
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx) //Test s'il est majuscule
            if(Character.isUpperCase(currChar))
            {idx = alphabetMaj.indexOf(currChar);
                shiftedAlphabet = shiftedAlphabetMaj;
            }
            else
            {idx = alphabetMin.indexOf(currChar);
                shiftedAlphabet = shiftedAlphabetMin;
            }
            //If currChar is in the alphabet
            if(idx != -1)
            {
                //Get the idx th character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }  

            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted

        
        return encrypted.toString();
    }
    public static encryptTwokeys3(Strin
    

    /**
     * An example of a Test Caesar method 
    
     */
    public void TestCaesar()
    {
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
    }
}
