
/**
 * Décrivez votre classe EXO3 ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class EXO3
{
    public static boolean isLigneNote(String line){
        if (line.startsWith("#")){
            return false;
        }
        int i =0;
        for (int j=0; j<line.length();j++){
            if (line.charAt(j)==':'){
                i+=1;//on peut aussi utiiser la fonction slite pour séparer les elements dans un tableau dans la fonction isLigneNote2
            }
        }
        if(i==6){
            return true;
        }
        return false;
    }
    public static boolean isLigneNote2(String line){
        String[] elements=line.split(":"); //tableau d'element separer par un ":"
        return line.startsWith("#") && elements.length==7; // si l'un est false cela return automatiquement false
        /*ou on peu aussi tout definir:
         * 
         * 
           if (line.startsWith("#")){
            return false; }
           if(elements.length==7){
            return true;}
            return false; }*/
    }
    public static String getMatiere(String line){
        // si on utilise la permier methode on utilise le substring;
        String[] elements=line.split(":"); 
         if (isLigneNote2(line)){
             return elements[3];
            
            }
         return null;
    }
    //Methode 1 avc le substring
    public static String getMatiere2(String line){
        //if (isLigneNote2(line)){
        int i=0;
        for (int j=0; j<line.length();j++){
            if(line.charAt(j)==':'){
                i+=1;
            }
            if (i==3){
                int indexFin = line.indexOf(":",j+1);
                String Matiere = line.substring(j+1, indexFin);
                return Matiere;
            }
        }
        return "";
    }
    public static Double getCoef(String line){
        String[] elements=line.split(":"); 
         if (isLigneNote2(line)){
             return Double.parseDouble(elements[6]);
            
            }
         return null;
    }
    public static Double getNoteSurVingt(String line){
        String[] elements=line.split(":"); 
         if (isLigneNote2(line)){
             Double note = Double.parseDouble(elements[6]);
            
            }
         return null;
    }
}
