import edu.duke.*;
/**
 * Write a description of class CaesarBreaker here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarBreaker
{
    //countLetters vu dans le cours
    public int[] countLetters(String message){
        String alph = "abcdefghijklmnoqprstuvwxyz";
        int[] counts = new int[26];
        for (int k = 0; k < message.length(); k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
    } //Fin countLetters

    //Il nous reste de calculer la fonction maxIndex
    public int maxIndex(int[] vals){
        //Déclarer et Initialise maxDex à zéro
        int maxDex=0;
        //Parcourir la boucle for en incrémentant le compteur k jusqu'à vals.length
        for(int k =0; k<vals.length;k++){
            //Si vals[k] est supérieur à vals[maxDex]
            if (vals[k]>vals[maxDex]){
                    //maxDex changera de valeu et sera égal à k
                maxDex=k;
                    //Fin Si
                }
        
            //Fin for    
        }
        //retourner maxDex 
        return maxDex;
    }//Fin maxIndex

    //decrypt vu dans le cours
    public String decrypt(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4){
            dkey = 26 - (4 - maxDex);
        }
        return cc.encrypt(encrypted, 26-dkey);
    } //Fin decrypt

 
}
    
 