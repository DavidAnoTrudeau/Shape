package assignment6;
import java.util.Random;
/**
 *
 * @author David A-T
 * 
 */
public class Ellipse {
    private double majorAxis;
    private double minorAxis;
    
    // Default Constructor (Random Values)
    public Ellipse(){
        Random rand = new Random();
        this.majorAxis = rand.nextInt(6) + 5; // [5, 10]
        this.minorAxis = rand.nextInt(6) + 5; // [5, 10]
    }
    
    // Constructor with majorAxis and minorAxis
    public Ellipse(int majorAxis, int minorAxis) {
        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;
    }
    
    // Copy Constructor
    public Ellipse(Ellipse ellipse){
        this.majorAxis = ellipse.majorAxis;
        this.minorAxis = ellipse.minorAxis;
    }
    
    /**
     * To calculate the area of the ellipse
     * @return the area of the ellipse
     */
    public double calcArea(){
        return Math.PI * this.majorAxis * this.minorAxis;
    }
    
    /**
     * To calculate the perimeter of the ellipse
     * @return the perimeter of the ellipse
     */
    public double calcPerimeter(){
        return 2 * Math.PI * Math.sqrt((Math.pow(this.majorAxis, 2) 
                + (Math.pow(this.minorAxis, 2))) / 2);
    }
    
    /**
     * To check if the ellipse is a circle
     * @return true or false, based on if the circle is a circle or not
     */
    public boolean isCircle(){
        if (this.majorAxis == this.minorAxis)
            return true;
        
        return false;
    }
    
    /**
     * To check if the axis is valid [1,-]
     * @param axis
     * @return true or false, based on if the axis is valid or not
     */
    public boolean isAxisValid(double axis){
        if (axis > 0)
            return true;
        
        return false;
    }
    
    /**
     * To convert the ellipse object into a String
     * @return the ellipse object converted into a String
     */
    @Override
    public String toString(){
        String str = "";

        str += String.format("%-15s: %.2f\n", "Major-Axis", majorAxis);
        str += String.format("%-15s: %.2f\n", "Minor-Axis", minorAxis);
        str += String.format("%-15s: %.2f\n", "Area", calcArea());
        str += String.format("%-15s: %.2f\n\n", "Perimeter", calcPerimeter());
        
        if (isCircle())
            str += "This ellipse is a circle\n";
        else
            str += "This ellipse is not a circle\n";
        
        return str;
    }
    
    /**
     * To check if the ellipse is equals to another ellipse
     * @param ellipse
     * @return true or false, based on if it is equals to another ellipse or not
     */
    public boolean equals(Ellipse ellipse){
        return this.majorAxis == ellipse.majorAxis && 
                this.minorAxis == ellipse.minorAxis;
    }

    public double getMajorAxis(){
        return majorAxis;
    }
    
    /**
     * To set the major axis (Must be a valid value)
     * @param majorAxis 
     */
    public void setMajorAxis(double majorAxis){
        if (isAxisValid(majorAxis))
            this.majorAxis = majorAxis;
        else
            System.out.println("\nThe new value must be a positive value.\n");
    }

    public double getMinorAxis(){
        return minorAxis;
    }
    
    /**
     * To set the minor axis (Must be a valid value)
     * @param minorAxis
     */
    public void setMinorAxis(double minorAxis){
        if (isAxisValid(minorAxis))
            this.minorAxis = minorAxis;
        else
            System.out.println("The new value must be a positive value.");
    }
}
