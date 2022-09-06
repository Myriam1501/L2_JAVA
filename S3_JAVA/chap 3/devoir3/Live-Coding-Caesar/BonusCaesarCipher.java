import edu.duke.*;
public class BonusCaesarCipher
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
            FileResource fr = new FileResource();
            String message = fr.asString();
            // fair une boucle pour prendre tout les key et voir quelle est la bonne 
         for (int key=0; key<25;key++){
            
            String encrypted = encrypt(message, key);
            System.out.println("key is"+ key + "\n" + encrypted);
        }   
    }
}
