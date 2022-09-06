
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


