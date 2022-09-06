import java.util.*;
import edu.duke.*;
/**
 * Write a description of class WordsWithArrays here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordsWithArrays
{
    private ArrayList<String> myWords;
    

public WordsWithArrays()
{
    myWords = new ArrayList<String>();
    
}
//Cette méthode permet de trouver les mots uniques
public void findUnique(){
    FileResource resource = new FileResource();
    for(String s : resource.words())
    {
        //Convertir s en LowerCase
        s=s.toLowerCase();
        //Mettre dans index la position de s dans myWords
       int index=myWords.indexOf(s);
        //Si le mot n'est pas déjà vu
        if (index==-1){
        // Ajouter à myWords
      myWords.add(s);
      //Fin si }
    }
      
    }
}
public void tester()
{
    findUnique();
    System.out.println("Unique words are "+myWords.size());
}
}