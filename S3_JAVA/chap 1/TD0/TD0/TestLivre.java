
/**
 * Décrivez votre classe TestLivre ici.
 *      
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TestLivre{
    private String titre; /* Titre d'un livre */ 
    private int annee;
    
 public  void main(String args []) {
        Livre livre1= new Livre("Changer l’eau des fleurs",2017);
        Livre livre3= new Livre("Les misérables",1862);
        Livre livre2= new Livre("Les misérables",1862);
        livre1.test();
        System.out.println("livre3 == livre2? " + (livre3 == livre2));
    }
}
 
 
