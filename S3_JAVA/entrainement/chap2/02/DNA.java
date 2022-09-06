
public class DNA
{

    public final String strand;
    
    public DNA(String strand){
        this.strand=strand;
    }
    
    public String getFirstGene(){
        //trouver la première occurrence d'ATG et l'appeller startIndex
        int startIndex = this.strand.indexOf("ATG");
        //trouver le TAA commençant après l'index (startIndex + 3), appeler ce résultat currIndex
        int currIndex = this.strand.indexOf("TAA", startIndex+3);
        //Tant que  **currIndex n'est pas égal à -1**
        while (currIndex!=-1){
            //Vérifier que (currIndex-startIndex) est un multiple de 3
            int distance = currIndex-startIndex;
            if (distance%3==0){
                //Si VRAI, le texte entre startIndex et currIndex +3 est la réponse
                String gene = this.strand.substring(startIndex,currIndex +3);
            }
            else{
                
            
                //Si FAUX, mettre à jour *currIndex* à l'index du prochain "TAA", en commençant à (currIndex + 1)
                 currIndex=this.strand.indexOf("TAA",currIndex+1);
                }
                //Votre réponse est une chaîne vide
               
        }
        return gene;
    }
    

    
    public static void main(String[] args){
        

        DNA dna1 = new DNA("ATGAATACGGTAAATTAA");
        System.out.println("DNA1:"+dna1.getFirstGene());
        ///        DNA1:ATGAATACGGTAAATTAA





        DNA dna2 = new DNA("AAAAAAATGTTAAGCTAATTTTTTTTT");
        System.out.println("DNA2: "+dna2.getFirstGene());
        //DNA2: ATGTTAAGCTAA
        
        DNA dna3 = new DNA("AAAAAAAAAAAAAAAAAAAAAAAAAATAA");
        System.out.println("DNA3:" + dna3.getFirstGene());
        //DNA3:
        
        DNA dna4 = new DNA("TTTTTTTTTTATGTTTTAGGGTAGG");
        System.out.println("DNA4:" + dna4.getFirstGene());
        //DNA4:
        
        DNA dna5 = new DNA("ATGTTAAAATAA");
        System.out.println("DNA5:" + dna5.getFirstGene());
        //DNA5:ATGTTAAAATAA
        
    }
    
    
}
