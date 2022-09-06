import java.io.*;

public class TagFinder {
    public String findGeneSimple(String dna) {
            //codon début = ATG
            int debut=dna.indexOf("ATG");
            int fin=dna.indexOf("TAA");
             
            if (dna.indexOf("ATG")!=-1||dna.indexOf("TAA")!=-1){
                String x = dna.substring(debut,fin);
            
            }
            
            
            //codon fin = TAA
            return "";
    }
    
    public void testing() {
        {
            String dna1 = "ATGGGGTTTAAATAATAATAG";
            String gene1 = findGeneSimple(dna1);
            System.out.println(gene1);
            
        }
        {
            String dna2 = "AAATGCCCATGGGGTTTAAATAATAATAGTTCAA";
            String gene2 = findGeneSimple(dna2);
            System.out.println(gene2);
            
        }
        
        // et si la chaine ne contient pas ATG?
        {
            String dna3 = "GGCTATTTAGGGTTAA";
            String gene3 = findGeneSimple(dna3);
            System.out.println(gene3);
            
        }
        
        // et si la chaine ne contient pas TAA
        {
            String dna4 = "ATGGGCTATTTAGGGTTAG";
            String gene4 = findGeneSimple(dna4);
            System.out.println(gene4);
            
        }
        
        
        //et si les codons étaient groupés par 3?
        
        {
            String dna3 = "ATGGTTAA";
            String gene3 = findGeneSimple(dna3);
            System.out.println(gene3);
            
        }
        



    }
}
