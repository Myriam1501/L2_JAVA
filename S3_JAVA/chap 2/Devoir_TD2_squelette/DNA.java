public class DNA {

    public String strand;
    public String name;

    static String readFile(String path) 

    {
        try{
            byte[] encoded = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(path));
            return new String(encoded, java.nio.charset.StandardCharsets.US_ASCII);
        }
        catch(java.lang.Exception e){
            return "";
        }
    }

    public static DNA fromFile(String filename){
        DNA dna = new DNA(readFile(filename));
        dna.name=filename;
        return dna;
    }

    public DNA(String strand) {
        this.strand = strand;
        this.name="unknown";

    }

    public java.util.List<String> getAllGenes(){
        java.util.List<String> genes = new java.util.ArrayList<String>();
        int startIndex=0;
        while(true){
            String gene = this.getGeneFrom(startIndex);
            if(gene.isEmpty()){
                break;
            }
            startIndex=this.strand.indexOf(gene,startIndex)+gene.length();
            genes.add(gene);

        }

        return genes;

    }

    public void printAllGenees(){
        for(String gene : this.getAllGenes()){
            System.out.println(gene);
        }
    }

    public String getFirstGene() {
        return getGeneFrom(0);

    }

    public String getGeneFrom(int startsFrom) {

        // trouver la première occurrence d'ATG et l'appeller startIndex
        int startIndex = this.strand.indexOf("ATG",startsFrom);

        //  si startIndex = -1 retourne la chaîne vide.
        if (startIndex == -1) return "";

        // findStopCodon(dnaStr,startIndex,"TAA") et appeler le résultat taaIndex
        int taaIndex = this.findStopCodon(startIndex, "TAA");

        // findStopCodon(dnaStr,startIndex,"TAG") et appeler le résultat tagIndex
        int tagIndex = this.findStopCodon(startIndex, "TAG");

        // findStopCodon(dnaStr,startIndex,"TGA") et appeler le résultat tgaIndex
        int tgaIndex = this.findStopCodon(startIndex, "TGA");

        // prendre le plus petit entre taaIndex, tagIndex, tgaIndex et l'appeller minIndex
        int temp = Math.min(taaIndex, tagIndex);
        int minIndex = Math.min(temp, tgaIndex);
        if (minIndex != this.strand.length()) {
            // si minIndex=dnaStr alors la réponse est une chaine vide $
            return this.strand.substring(startIndex, minIndex + 3);
        }

        // La réponse est le texte commençant à startIndex jusqu'à minIndex + 3
        return "";

    }

    private int findStopCodon(int startIndex, String stopCodon) {
        // trouver le **stopCodon**  commençant après l'index $(\text{startIndex} + 3)$, appeler ce résultat $\text{currIndex}$
        int currIndex = this.strand.indexOf(stopCodon, startIndex);
        // Tant que  **$currIndex \neq -1$**
        while (currIndex != -1) {
            // Vérifier que $(\text{currIndex}-\text{startIndex})$ est un multiple de $3$
            if ((currIndex - startIndex) % 3 == 0) {
                // Si VRAI, $\text{currIndex}$ est la réponse
                return currIndex;
            } else {
                // Si FAUX, mettre à jour *currIndex* à l'index du prochain **stopCodon**), en commençant à $(\text{currIndex} + 1)$
                currIndex = this.strand.indexOf(stopCodon, currIndex + 1);
            }
        }
        // retourner dnaStr.lenghth()
        return this.strand.length();

    }

    public double checkSimilarityRadio(DNA childDNA){
        int nbGeneCommun = 0;
        for(String geneAutre : childDNA.getAllGenes()){
            for(String Mygene : this.getAllGenes()){
                if (geneAutre.equals(Mygene)){nbGeneCommun =nbGeneCommun+1;}
            
            }
        
        }
        double res = nbGeneCommun;
        // Claculer le RATION DE SIMILARIRTER pas besoin de connaitre la formule
        res =res-childDNA.getAllGenes().size();
        res =res/(childDNA.getAllGenes().size());
        
        return 1-Math.abs(res);

    }

    public boolean hasGene(String agene){
        //TODO
        for (String Gene : this.getAllGenes()){
            if (Gene.contains(agene)){return true;}
        }
        return false;
    }

    public void deleteGene(String agene){
        //Tester si agene exisre dans le brun d'ADN
        // ==> || (option + fleche maj +l )= ou  ==> && = end
        while (true){ 
            int startIndex= this.strand.indexOf(agene);
            // on utyile indexof car on a besoin de connaitre la position 
            // si strartindex n'esxiste pas, sortir du while

            if (this.strand.indexOf(agene)==-1){break;}
            // si oui on cherche startCodon et endCodon
            if (startIndex>=3 && this.strand.length() - startIndex>=3){
                String startCodon = this.strand.substring(startIndex-3, startIndex);
                String stopCodon = this.strand.substring(startIndex + agene.length(), startIndex + agene.length()+3);
                // verifier que startCodon="ATG" et endCodon ="TAA" ou "TAG" ou "TGA"

                if (startCodon.equals("ATG")  && stopCodon.equals("TAA") || stopCodon.equals("TAG") || stopCodon.equals("TGA")){

                    // si oui, mettre à jour le stand
                    String Part1 = this.strand.substring(0, startIndex-3);
                    String Part3 = this.strand.substring(startIndex + agene.length()+ 3, this.strand.length() );
                    this.strand = Part1 + Part3;
                }
            }

        }
    }

    public void insertGene(String foreignGene,String afterGene){
        //aftergene est le coeur du gene et foreigngene c'est se qui apres le endcodon
        // Verifie que afterGene existe deja dans le strand
        int counteur=0;
        while(true){
            int startIndex= this.strand.indexOf(afterGene, counteur);
            if(startIndex==-1){break;}

            if (startIndex>=3 && this.strand.length() - startIndex>=3){
                String startCodon = this.strand.substring(startIndex-3, startIndex);
                String endCodon = this.strand.substring(startIndex + afterGene.length(), startIndex + afterGene.length()+3);
                // chercher startcodon et endcodon
                // Tester si startCodon == ATG et si endcodon == taa ou tag ou tga
                // on NE peut PAS mettre de == car c'est une chaine de caractère
                //on NE peut PAS mettre de == car c'est une chaine de caractère
                if (startCodon.equals("ATG")   && endCodon.equals("TAA") || endCodon.equals("TAG") || endCodon.equals("TGA")){
                    String Part1 = this.strand.substring(0, startIndex + afterGene.length() + 3);
                    String Part3 = this.strand.substring(startIndex + afterGene.length() + 3, this.strand.length() );
                    //Jusqu'à la fin // si oui, mettre à jour le stand
                    this.strand = Part1 + foreignGene + Part3;
                   
                }

            }
            counteur = startIndex+1;
        }
    }

    public static void checkFixGene(){
        DNA brokenDna = new DNA("ATGGTAGTCACGCTATGCAGTTGCGTAGCATCGTGAATGAGTGCTCGAACGCATGTACAGGTAGTCTAGATGCGAACGGCTACGTACGATTAGTGTGATGACGAGTTCGTCGACTAGCCAGACTACTCTATAGATGCTGCTAAGTGTCCATGATGTCGTCCATGACGTATGAATGCTATGAGACATGGTCCAGGATACTTAGATGCTAGATATCCTGTGCGACGCATCGATCTCGAGTCGACTGTGACGGGCATGTCGCGTTGCGCTATCGACAGCTGAATGGTAATCGTCATCACGCGTCGATCACTATAGATGAGTACGTAGAACTATGAGCACGGCAACTGATGATCTACATTCACTGCGTCTGGATTAGATGCAGCATAGTCGTCTGTACTAGATCAATGCGAGACGCATAGATGCTAGATCAGGACTCGCGAAGTTCGAGCACTGATGCTGACGACTAGACCTATGCTAGCTCTGCTGCAGAGTGTAGACTACTAAATGCGTGACACTGCTGACCTGTCAGATGCAGTAGTAAGCCTATGAATGAGTAGCGCTCAGTGAATGACGGCTACTTCACTGTCGGACCTACAGTAAATCGATGATCGTCGTCTAAAA");
        if(brokenDna.hasGene("GTCCAGGATACT")){
            brokenDna.deleteGene("GTCCAGGATACT");
        }
        if( !brokenDna.strand.equals("ATGGTAGTCACGCTATGCAGTTGCGTAGCATCGTGAATGAGTGCTCGAACGCATGTACAGGTAGTCTAGATGCGAACGGCTACGTACGATTAGTGTGATGACGAGTTCGTCGACTAGCCAGACTACTCTATAGATGCTGCTAAGTGTCCATGATGTCGTCCATGACGTATGAATGCTATGAGACATGCTAGATATCCTGTGCGACGCATCGATCTCGAGTCGACTGTGACGGGCATGTCGCGTTGCGCTATCGACAGCTGAATGGTAATCGTCATCACGCGTCGATCACTATAGATGAGTACGTAGAACTATGAGCACGGCAACTGATGATCTACATTCACTGCGTCTGGATTAGATGCAGCATAGTCGTCTGTACTAGATCAATGCGAGACGCATAGATGCTAGATCAGGACTCGCGAAGTTCGAGCACTGATGCTGACGACTAGACCTATGCTAGCTCTGCTGCAGAGTGTAGACTACTAAATGCGTGACACTGCTGACCTGTCAGATGCAGTAGTAAGCCTATGAATGAGTAGCGCTCAGTGAATGACGGCTACTTCACTGTCGGACCTACAGTAAATCGATGATCGTCGTCTAAAA")){
            System.out.println("DNA is not fixed!");
        }
        else{
            System.out.println("DNA is fixed!");
        }

        brokenDna.insertGene("ATGTTTTTTTTTTTTTTTTTTTTTTTTTGA", "CAGCATAGTCGTCTGTAC");

        if( brokenDna.strand.equals("ATGGTAGTCACGCTATGCAGTTGCGTAGCATCGTGAATGAGTGCTCGAACGCATGTACAGGTAGTCTAGATGCGAACGGCTACGTACGATTAGTGTGATGACGAGTTCGTCGACTAGCCAGACTACTCTATAGATGCTGCTAAGTGTCCATGATGTCGTCCATGACGTATGAATGCTATGAGACATGCTAGATATCCTGTGCGACGCATCGATCTCGAGTCGACTGTGACGGGCATGTCGCGTTGCGCTATCGACAGCTGAATGGTAATCGTCATCACGCGTCGATCACTATAGATGAGTACGTAGAACTATGAGCACGGCAACTGATGATCTACATTCACTGCGTCTGGATTAGATGCAGCATAGTCGTCTGTACTAGATGTTTTTTTTTTTTTTTTTTTTTTTTTGAATCAATGCGAGACGCATAGATGCTAGATCAGGACTCGCGAAGTTCGAGCACTGATGCTGACGACTAGACCTATGCTAGCTCTGCTGCAGAGTGTAGACTACTAAATGCGTGACACTGCTGACCTGTCAGATGCAGTAGTAAGCCTATGAATGAGTAGCGCTCAGTGAATGACGGCTACTTCACTGTCGGACCTACAGTAAATCGATGATCGTCGTCTAAAA")){
            System.out.println("New gene added in DNA!");
        }
        else{
            System.out.println("New gene not added in DNA");
        }

    }

    public static DNA[] __familly=null;
    public static java.lang.Iterable<DNA> getFamilly(){
        if ( __familly == null){

            DNA gerardDna =  DNA.fromFile("gerard.txt");
            DNA pierretteDna = DNA.fromFile("pierrette.txt");
            DNA deborahDna = DNA.fromFile("deborah.txt");
            DNA nicolasDna = DNA.fromFile("nicolas.txt");
            DNA elioDna = DNA.fromFile("elio.txt");
            DNA thomasDNA = DNA.fromFile("thomas.txt");
            DNA mathieuDna = DNA.fromFile("mathieu.txt");
            DNA valerieDna = DNA.fromFile("valerie.txt");
            DNA jcDna = DNA.fromFile("jc.txt");

            DNA[] familly={gerardDna,pierretteDna,deborahDna,thomasDNA,jcDna,nicolasDna,elioDna,mathieuDna,valerieDna};
            __familly=familly;
        }
        return java.util.Arrays.asList(__familly);
    }

    public static void checkfindIntruder(){
        for(DNA dna1 : getFamilly()){
            boolean has_relative=false;
            for(DNA dna2: getFamilly()){
                if( dna1==dna2){
                    continue;
                }
                if( dna1.checkSimilarityRadio(dna2) > 0.4){
                    has_relative=true;
                    break;
                }
            }
            if(!has_relative){
                System.out.println(dna1.name+" est un intru");
            }

        }
    }

    public static void checkGeneParsing(){
        DNA dna8 = new DNA("ATGCTGACGGATCAGCTAGTAGCTAGTCAGCGTTAAATGGCATGAGGGATCGGAATGTCACTAACTATCTGCCGTCGACGAGACCTGGCAGCTCGATGAATGTGCAGCTAGATGCAGGTATGCTCAACGACTACTTAGGCTATGTACAGCTGCGACGCTGATGCACGATAAATGGCAAGCTGCCTACATTCAGCTCTATCATAGATGTACTACGCTAGCTCATACTAAATGAGTTACGTCTACGACACGCGTACTGCTTAGATGGACGACGCTGTACGAGATTAGATGTACACGCGAAGCCTGTCGGACTGCGCACAGCGTTGAATGGTCACGTGCACTAGTACTGCTCAGAGTACGCGAGATTACTAAATGAGCTGCCGACAGTACGACACGTAGAGCCGCTTATGGCTTGCCAGTACAGCTACAGTTGAATGTCAATCAGCCTGTAGATGGTCAGTGACAGTGTACTGTCAGCTTGATATGGTCCTAAGCGCTCTGACTACTACGGACTCATGAATGTCGCATGCTTCATGCTGAATGCAGCAGGACCAGGATAGCCGTTGCTACTGAATGGACAGTTCAAGTTGAATGGCTTGCGACAGTGCAGTATGAGTGCTCTGATGTGCCGACATCAGATCTCGTACTCGTGAATGGACCGTGCTCGTCTGCAGCAGAGCCGTCAGTCGTGAATGGCTTACAGCGTCCAGGCTATCGTCAGTTGCCATTAGAAGTATGAGCCAGATCTAGACACTATGAGTACTACTGTAAGTACGAGTTGAATGGCTTGCGCACTAACGAGCTGCGACGTATAAATGAGTTAAATGTCGTGCTGCACGTAAATGCGTAGCAGCCTACGTTCGGATTGCAGTGATCTATAACCATGATCCGATGCGTCGCAGATTAGATGCGTCAGCAGACGGTAGACTGCCAGCATAGTTCATAGGGGCTACGATGTCGCTACTGTCGATCGTAGATCAGTGCAGTGCTGATCGATAGTCGGGGCAAATGGCTCGACAGGTACTGGTCCGTGATCATGTCTCGTCGACGTGAATGATCTACTACACGGCATAAATGCAGGCTACGCATTGCCAGTAAATGTACCGAGTCCAGTAAATGCGACATGTCAGTTGCGACGATGACGATTCGGATTCGGTCTAGATGCTAACTGCTGTACGAACGGACGTAAGCGCTACTATCTACTAAATGGTATCGAGTAGTGTACTAACTACTATCCATCAGGTCCGTTAGATGCGTTCGTGCAGCAGCATCTAAGATGGACGTCCGTAGCCTGTACAGTTAGATGCTATCACTAGATACGACTATCGCAGTAATCGTCATCTGAATGGACATCATCACGAGCGATCAGCTATAGATGGATCTGGCAGCAGTCGATAGCACTGCTGCACAGCAGGCTTGAGCAATGAGCTACCGAGCACGAGTCAGTAGTTCGGACGATGTCTAGATGAGCGTCCTGCATGCATCAGACTACTAGATGGATTCAAGCCGAACTCGTGACTAAATGGCACGATCAGCAGACACTTAGATGTACGACCGTCTACAGCAGACGCAGAGCAGCACGTAAATGCTGTAAATGCTATGAATGCATGATGTAAGTACTTCGCGTTGATACGAATGACGCAGGTCTAAATGGCTCGACTGCTGTACTAAATGACGCTGTCATGCAGTGATGCTCTAGTCGTCAGTGCATAGATGGTCATCCTGGTAGATGCTCTAAGCAGTTAGATGACGCTAGACTAAATGCGTTCGTGAATGTGCCGAGCTTCAATCGTACATCTGCTAAGCGCTTAAATGCTGGACAGCCGAACGCGTAGTGCAGCTAGTGCTTACCTACGATAGTGATGCGAGACACTGATGTCGTAAGTAGTGTAGACAGTCTGCATCGTTAGAGTCATCAATGAGCGTACTGGACCGTGTCGCATGAATGGACTCGCATGATGATCATGCATACCAGAGTGCTCTATAAATGGCATACCGTTGAATGACGCTGAGCCGTGACACTAGTTCAATCAGCTACTAGATGACTTGCCAGATCACGGTCGTCCGACATTAAATGATCCTGGTACTGGTCGACGTCCGAGTAAGTGCAGTCAGCAGCTAAATGCTGTAAGATGTCGAGTTGCGTAGATCAGCTAACGGTCTACCAGAGCATCGACTAAATGTCGCAGGCATAACTGGCGATGCGAGCTACGGATGCTATCATCGCACGTCAGTAAATGCAGCATGCAAGCCGTTGAATGCAGCAGTGCCTGGATGATACGGACTACTAGATGAGCGATACTAGCAGTTAGATGGTAATCGATCGTCAGTAAATGATCGACCGTACGCTATGAGAGAGAGCATGCTGGATGACGACATCTACCATACGACGTAAACGACACCCATGGTCACTACGTACCGAACTCGATAGATGGTCAGTCTATACATCCTGGATGATACTACTGACATCTAGATGTCAATCCGACATACTGACGTAAGCCGTTACTGAATGCTGCAGTACTGCGTCAGCTCGAGCAGTGATAGTAGCTAAATGGTATAACAATGGCTCAGCAGGCTGACTACAGTCGTGCATCGAGCTAGATGGATTACGTATACGACCGTTGAGAATTTATGGCTGTCGCTCGTATCGTAGATAGTTGAATGCATTCGCTAGTCCGATAGATGCTGTACTAGATGGCTACTGTACGTTGATCAAATGCGTCGATCAGCTTACACTTACGATCTAGCTTGAATGGATCAGCAGGTATAGATGGACTACCATCGTCTGTCGTGAATGCGTGTACTATGCGTAATCGTAAGCGCAACGTAGATGTGCGTAACTTACCTGGATGACGTCGATGCTCTAACTGCAGACTAAATGTGCGCTGCAGTCTAAATGTCACGTACGCATATCTGAATGGTACGACTAACTTGCACGTCGCTATCAGACGTCCGATGCTGAATGCTGGTCAGTCTGACGCTAGTACTATAAATACAGATATGTGCCGTACTAGTGACACGGACAGCAGTAGTACTACTTCAAGCTAAATGTGCCTAGTCTCAGCTTAG");
        java.util.List<String> genes = (java.util.List<String>) dna8.getAllGenes();
        System.out.println("should be 100 " + genes.size());
        System.out.println("should be ATGGACAGTTCAAGTTGA\n          " + genes.get(19));
        System.out.println("should be ATGGATCTGGCAGCAGTCGATAGCACTGCTGCACAGCAGGCTTGA\n          " + genes.get(44));
    }

    public static void main(String[] args) {

        checkGeneParsing();
        checkFixGene();
        checkfindIntruder();

    }
}