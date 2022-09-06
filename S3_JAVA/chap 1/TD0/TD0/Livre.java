
/**
 * Décrivez votre classe Livre ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Livre{
    private String titre; /* Titre d'un livre */ 
    private int annee; /* Année d'édition d'un livre */
/* Stipule que tout Livre est intéressant et c'est une décision finale ! */
    public boolean INTERESSANT = true;
/* Constructeur qui nécessite un titre et une année d'édition */
    public Livre(String unTitre, int uneAnnee) { // constructeur de la classe Livre
        titre = unTitre;
        annee=uneAnnee;
        setEdition( uneAnnee );
    }
    /* Nous donne la valeur interne de titre */
    public String getTitre(){ return titre; }   
    public int getEdition(){return annee;}
    public void setEdition(int date){ /* Changer l'année d'édition s'il vous plait */
        if (date < 0)
            System.out.println("N'essayez pas de me corrompre, blagueur!");
        else
        annee = date;
        System.out.println("information:" + titre + annee);
    }
    public void test(){
          String titre = "Changer l’eau des fleurs"; 
          int annee = 2017;
          Livre livre1= new Livre(titre,annee);
          System.out.println(livre1);
          setEdition(2018);
        }
 
    public void test2(){
          String titre = "Les fleurs du mal"; 
          int annee = 1857;
          Livre livre2= new Livre(titre,annee);
          System.out.println(livre2);
        }
    
}

