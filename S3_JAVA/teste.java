
/**
 * Décrivez votre classe WordPlay ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */

public class WordPlay {

    public boolean isVowel(char ch){
        String vowels = "AEIOUYaeiouy";
        //on peut aussi mettre tt le charactere en majusctule (ou en miniscule ) pour etre sur que se soit une voyelle peut importe sa forme mais cela change la nature du char (si il etait en min il deviendra un maj pour la suite)
        //char majtexte = Character.toUpperCase(ch);
        
        //verifier qu'il existe
            if (vowels.indexOf(ch) != -1 ){
            return true;
        }
       
        return false;
        
    }
    
       public void tester() {
        System.out.println("isVowel('a') = " + isVowel('a')); 
        System.out.println("isVowel('F') = " +isVowel('F'));
    }
    
    
    
    
       public String replaceVowels(String phrase, char ch){
       StringBuilder replace = new StringBuilder(phrase);

        for (int i = 0; i < phrase.length(); i++){
            if (isVowel(replace.charAt(i)) == true){
                replace.setCharAt(i, ch);
            }
        }
        // POUR QUE CELA RETOURNE UN STRING
        return replace.toString();
    }
  
    
    public String emphasize(String phrase, char ch){
        StringBuilder emphasize = new StringBuilder(phrase);
        for (int i = 0; i < emphasize.length(); i++){
            if (emphasize.charAt(i) == ch || emphasize.charAt(i) == Character.toUpperCase(ch)){
                if (i % 2 == 0){
                    emphasize.setCharAt(i, '*');
                }
                else{
                    emphasize.setCharAt(i, '+');
                }
            }
        }
        return emphasize.toString();
    }
    
}




import edu.duke.*;
public class CaesarCipher
{
    public static String encrypt(String input, int key)
    {
        // creer un stringbuilder avec un message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        // ecrire l'alphabet
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // calculer l'alphabet decalé (shiftedAlphabet)
        String shiftedAlphabet = alphabet.substring(key) +alphabet.substring(0,key);
        //compter de 0 à length d'encrypted (nom de la variable = i)
        for(int i=0; i<encrypted.length(); i++){
            
            // regarder le caractere a l'index i de l'encrypted (l'appeller currChar)
            char currChar = encrypted.charAt(i);
            // trouver l'index de currChar dans l'alphabet (l'appeller idx)
            // si currCar est dans l'alphabett    
            if (Character.isLowerCase(currChar) == true){
                int idx = alphabet.toLowerCase().indexOf(currChar);
                if (idx != -1){
                    char newChar = shiftedAlphabet.toLowerCase().charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }
            else{
                int idx = alphabet.indexOf(currChar);
                if (idx != -1){
                    //obtenir le idx ieme caractere de l'alphabet decalé, l'appeller newChar
                    char newChar = shiftedAlphabet.charAt(idx);
                    //Remplacer le ieme caractère de l'encrypte avec newChar
                    encrypted.setCharAt(i, newChar);
                }
            }

        }  

        // Sinon, ne rien faire

        //votre réponse est contenue dans la variable encryted

        return encrypted.toString();
    }
    
    public void testCaesar() {
       int key = 23;
        FileResource fr = new FileResource();
       String message = fr.asString();
       String encrypted = encrypt(message, key);
       System.out.println("key is"+ key + "\n" + encrypted);
    }
    
        public String encrypt2(String input, int key){
        return "mlkjhgf";
    }

    public static void main(String args[])
    {
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
    }
    public String encryptTwoKeys(String input, int key1, int key2){
         // creer un stringbuilder avec un message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        // ecrire l'alphabet
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // calculer l'alphabet decalé (shiftedAlphabet)
        String shiftedAlphabet1 = alphabet.substring(key1) +alphabet.substring(0,key1);
        String shiftedAlphabet2 = alphabet.substring(key2) +alphabet.substring(0,key2);
        
            for(int i = 0; i < encrypted.length(); i += 2) {
            char currChar = encrypted.charAt(i);
            if (Character.isLowerCase(currChar) == true){
                int idx = alphabet.toLowerCase().indexOf(currChar);
                if (idx != -1){
                    char newChar = shiftedAlphabet1.toLowerCase().charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }
            else{
                int idx = alphabet.indexOf(currChar);
                if (idx != -1){
                    char newChar = shiftedAlphabet1.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }
        }
        for(int i = 1; i < encrypted.length(); i += 2) {
            char currChar = encrypted.charAt(i);
            if (Character.isLowerCase(currChar) == true){
                int idx = alphabet.toLowerCase().indexOf(currChar);
                if (idx != -1){
                    char newChar = shiftedAlphabet2.toLowerCase().charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }
            else{
                int idx = alphabet.indexOf(currChar);
                if (idx != -1){
                    char newChar = shiftedAlphabet2.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }
        }
        return encrypted.toString();
    }
}