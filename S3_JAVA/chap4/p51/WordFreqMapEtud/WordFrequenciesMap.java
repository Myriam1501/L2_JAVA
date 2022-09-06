import edu.duke.*;
import java.util.*;
/**
 * Write a description of class WordFrequenciesMap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordFrequenciesMap
{
    //Count word sans HashMap à compléter d'abord puis à tester
    public void countWords()
    {
        FileResource fr = new FileResource();
       //Créer une variable total 
        int total=0;
        for(String w : fr.words())
        {
            w = w.toLowerCase();
           //Incrémenter total
           total++;          
            
        }
        //Affichage de total
       System.out.println("total = "+total);
    }
   

    public void countWordsMap()
    {
        FileResource fr = new FileResource();
        //pour utiliser un HashMap je dois importer java.util
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        int total = 0;
        for(String w : fr.words())
        {
            w = w.toLowerCase();
            if(map.keySet().contains(w))
            {
               //  Mot déjà vu : incrementer le count

              // map.put(w,);
               map.put(w,map.get(w)+1);
            }
            
            else
            { //Mot non déjà vu
               // map.put(w,);
               map.put(w,1);
            }
            
        }
        //Affichage de map
        for (String w : map.keySet()){
            int occurrences = map.get(w);
            //Si occurrences est supérieur à 500
            if (occurrences>500){
            //Affichage des mots qui occurrent plus que 500
            System.out.println(occurrences +"\t" +w);
            //Fin Si 
        }
        
        
    }
    }

}
