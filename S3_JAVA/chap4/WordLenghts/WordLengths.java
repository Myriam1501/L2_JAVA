import edu.duke.*;
/**
 * Décrivez votre classe WordLengths ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class WordLengths
{
   
    public void countWordLenghs(FileResource resource, int[] counts){
        for(String s: resource.words()){
            int index = s.length();
            if (!(Character.isLetter(s.charAt(0))))/*==False*/{
                index--;
            }
            if (!(Character.isLetter(s.charAt(s.length()-1)))){
                index--;
            }
            if(index<0){continue;}
            counts[index]++;
        }
    
    }
    
    public int indexOfMax(int[] values){
        int max= values[0];
        for (int i=0;i<values.length;i++){
            if(max<=values[i]){
                max=i;
                
            }
        }
        return max;
    }
    public void TestCountWordLenrh(){
        FileResource table = new FileResource();
        int [] count = new int [420];
        countWordLenghs(table,count);
        for (int i=0; i<31; i++){
            if(count[i]!=0){
                System.out.println(count[i] +" mot de la longueur" +i);
            }
            
        }
        System.out.println("index of max " + indexOfMax(count));
    }
    
    /*// variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int x;

    /**
     * Constructeur d'objets de classe WordLengths
     
    public WordLengths()
    {
        // initialisation des variables d'instance
        x = 0;
    }

    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     
    public int sampleMethod(int y)
    {
        // Insérez votre code ici
        return x + y;
    }*/
    
}
