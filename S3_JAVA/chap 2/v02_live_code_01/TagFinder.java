import java.io.*;

public class TagFinder {
    public String findGeneSimple(String dna) {
        //codon début=ATG
        int startcodon =dna.indexOf("ATG");
        int stopcodon=dna.indexOf("TAA", startcodon+3); // pour dire de commencer après l'ATG initial
        if (startcodon==-1){
            return null;
        }
        if(stopcodon==-1){
            //codon fin = TAA
            return null; 
        }
        String gene = dna.substring(startcodon, stopcodon +3);
        return gene;
    }
    public static void main(String[] arg){
            TagFinder tg = new TagFinder();
            tg.testing();
        }
    public void testing() {
        
            String dna1 = "ATGGGGTTTAAATAATAATAG";
            String gene1 = findGeneSimple(dna1);
            System.out.println(gene1);
            
        
        
            String dna2 = "AAATGCCCATGGGGTTTAAATAATAATAGTTCAA";
            String gene2 = findGeneSimple(dna2);
            System.out.println(gene2);
            
        
        // et si la chaine ne contient pas ATG?
        
            String dna3 = "GGCTATTTAGGGTTAA";
            String gene3 = findGeneSimple(dna3);
            System.out.println(gene3);
            
        
        
        // et si la chaine ne contient pas TAA
        
            String dna4 = "ATGGGCTATTTAGGGTTAG";
            String gene4 = findGeneSimple(dna4);
            System.out.println(gene4);
            
        
        
        
        //et si les codons étaient groupés par 3?
        
        
           // String dna3 = "ATGGTTAA";
           //String gene3 = findGeneSimple(dna3);
          //  System.out.println(gene3);
       
     
        



        }
}
