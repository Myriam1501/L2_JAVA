import edu.duke.*;
/**
 * Décrivez votre classe DOUBLEWordLengths ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class DOUBLEWordLengths
{
   
  public void countWordLengths(FileResource resource,int [] counts){
    for (String sb : resource.words()){
        int x = sb.length();
         counts[x]++;
    }
    
    
    }
}
