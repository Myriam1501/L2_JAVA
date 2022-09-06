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
        // calculer l'alphabet decalé (shiftedAlphabet ) pour les deux clée
        String shiftedAlphabet1 = alphabet.substring(key1) +alphabet.substring(0,key1);
        String shiftedAlphabet2 = alphabet.substring(key2) +alphabet.substring(0,key2);
        //Une boucle pour les lettre en position impaire avec i=0 
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
        //Une boucle pour les lettre en position paire avec i=1
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
