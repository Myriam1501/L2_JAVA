import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int numPoints=0;
        for (Point p: s.getPoints()){
            numPoints=numPoints+1; // on peut aussi écrire ==> nomPoint++ ;
        }
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        
        //perimetre/nombre de point
        double Average = 0.0;
        Average = (getPerimeter(s)/getNumPoints(s));
        return Average;
        
    }

    public double getLargestSide(Shape s) {
        Point prevPt = s.getLastPoint();
        double Longcote=0.0;
            for(Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
                if (currDist > Longcote){ 
                Longcote=currDist;
            }
            prevPt=currPt;
        } 
        return Longcote;
    }  
    public double getLargestX(Shape s) {
        //Initialisation de largestX
        // on peut aussi l'ecrire ==> double largestX=s.getLastPoint().getX();
      
        Point p = s.getLastPoint();
        double largestx = p.getX();// largestx = 0.0 ne peux pas marcher car elle prendra pas les negatif
        // recherche de la veleur de l'abscisse
        for(Point currPt : s.getPoints()) {
            double currX = currPt.getX();
             if (currX > largestx){ 
                largestx = currX;
            }
            
        }
        // retoutner la plus grande valeur de l'abscisse
        return largestx;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        return 0.0;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numpoints=getNumPoints(s);
        System.out.println("nombre de point = " + numpoints);
        
        double moy = getAverageLength(s);
        System.out.println("Taille moyenne = " + moy);
        double distanceMax=getLargestSide(s);
        System.out.println("Le plus long côté de la forme = " + distanceMax);
        //double largestX =getLargestX(s);
        //System.out.println("la plus grande valeur X = " + largestX);
        System.out.println("la plus grande valeur X = " + getLargestX(s));
   
       
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
