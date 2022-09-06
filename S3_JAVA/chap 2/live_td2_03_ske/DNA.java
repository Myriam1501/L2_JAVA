public class DNA {

    public final String strand;

    public DNA(String strand) {
        this.strand = strand;
    }


    public String getFirstGene() {
        // trouver la première occurrence d'ATG et l'appeller startIndex
        int startIndex=this.strand.indexOf("ATG");

        //  si startIndex = -1 retourne la chaîne vide.
        if(startIndex==-1){
            return "";
        }
        // findStopCodon(dnaStr,startIndex,"TAA") et appeler le résultat taaIndex
        int taaIndex=findStopCodon(startIndex,"TAA");
        // findStopCodon(dnaStr,startIndex,"TAG") et appeler le résultat tagIndex
        int tagIndex=findStopCodon(startIndex,"TAG");
        // findStopCodon(dnaStr,startIndex,"TGA") et appeler le résultat tgaIndex
        int tgaIndex=findStopCodon(startIndex,"TGA");
        // prendre le plus petit entre taaIndex, tagIndex, tgaIndex et l'appeller minIndex
        int minIndex=Math.min(taaIndex,Math.min(tagIndex,tgaIndex)); // On peut le fair en deux etapes
        //int minIndex=Math.min(taa.index, tagIndex)
        //int min Index2= Math.min(minIndex, tgaIndex)

        // si minIndex=dnaStr alors la réponse est une chaine vide $
        if (minIndex==this.strand.length()){
            return "";
        }
        // La réponse est le texte commençant à startIndex jusqu'à minIndex + 3
        return this.strand.substring(startIndex,minIndex+3);
    }

    private int findStopCodon(int startIndex, String stopCodon) {
        // trouver le **stopCodon**  commençant après l'index $(\text{startIndex} + 3)$, appeler ce résultat $\text{currIndex}$
        int currIndex=this.strand.indexOf(stopCodon,startIndex+3);
                // Tant que  **$currIndex \neq -1$**
        while (currIndex !=-1){
            if((startIndex-currIndex)%3 == 0){
            return currIndex;
           }
           else{
            currIndex=this.strand.indexOf(stopCodon,currIndex+1);
            }
        }
                // Vérifier que $(\text{currIndex}-\text{startIndex})$ est un multiple de $3$
                // Si VRAI, $\text{currIndex}$ est la réponse
                // Si FAUX, mettre à jour *currIndex* à l'index du prochain **stopCodon**), en commençant à $(\text{currIndex} + 1)$
                // retourner dnaStr.lenghth()
        return this.strand.length();
    }


    public static void main(String[] args) {

        DNA dna1 = new DNA("xxxxxxxxxxxxATGyyyzzzTAAiiiiiiii");
        System.out.println("DNA1:" + dna1.getFirstGene());
        ///        DNA1:ATGyyyzzzTAA

        DNA dna2 = new DNA("xxxxxxxxxxxxATGyyyzzTAAiiiiTAGiiiiii");
        System.out.println("DNA2: " + dna2.getFirstGene());
        //DNA2: ATGyyyzzTAAiiiiTAG

        DNA dna3 = new DNA("xxxxxxxxATGxxTAATGAATGA");
        System.out.println("DNA3:" + dna3.getFirstGene());
        //DNA3: ATGxxTAATGAATGA

        DNA dna4 = new DNA("xxxxxxxxxxxATGyyyyyyyyy");
        System.out.println("DNA4:" + dna4.getFirstGene());
        //DNA4:

        DNA dna5 = new DNA("xxxxxxxxxxATGxxxxxxxxTGAcccc");
        System.out.println("DNA5:" + dna5.getFirstGene());
        //DNA5:d

    }

}