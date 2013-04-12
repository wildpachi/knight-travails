package chess;

import java.util.regex.Pattern;     // Used for parsing Algebraic Notation
import java.util.regex.Matcher;     // Used for parsing Algebraic Notation  

/** Coordinate Subclass with extended support for handling Algebraic Coordinates
 *  Note: X Axis coordinate for Algebraic limited to A-Z range for simplicity 
 * 
 */
public class Algebraic extends Coordinate {
    /** Regular expression pattern for parsing Algebraic Coordinates */
    private final Pattern pattern = Pattern.compile("(\\p{Alpha})(\\d)");  
    
    /** Constructor for building a coordinate from Algebraic Coordinate
     *
     * @param alg_coord String containing algebraic coordinate
     */
    public Algebraic(String alg_coord) throws IndexOutOfBoundsException {
        super(0,0);
        Matcher matcher = this.pattern.matcher(alg_coord);
        
        if (matcher.find()) {
            this.setX(toCartX(matcher.group(1).toUpperCase()));
            this.setY(8 - (new Integer(matcher.group(2)))); 
        }
    }
    
    /** Constructor for building an Algebraic Coordinate with an offset
     *
     * @param x         x coordinate of initial position
     * @param y         y coordinate of initial position
     * @param offset    coordinate object containing offset to initial position
     */
    public Algebraic(int x, int y, Coordinate offset) {
        super(x + offset.getX(), y + offset.getY());
    }
    
    /** Converts from an integer to the letter equivalent in Algebraic Coordinates
     *
     * @param x         Cartesian x coordinate
     */
    private String toLetter(int x) {
        if (x > 25)
            throw new IndexOutOfBoundsException("X coordinate outside of A-Z range.");
                
        return (char) ('A' + x) + "";
    }
    
    /** Converts the letter of an Algebraic Coordinates to a Cartesian x coordinate
     *
     * @param alg_coord Algebraic Coordinates
     */
    private int toCartX (String alg_coord) throws IndexOutOfBoundsException {
        char result = alg_coord.toUpperCase().charAt(alg_coord.length() - 1);
        
        if ((result < 'A') || (result > 'Z'))
            throw new IndexOutOfBoundsException("X coordinate outside of A-Z range.");
        
        return result - 'A';
    }
    
    /** Converts from the stored Cartesian coordinates to the Algebraic equivalent
     */
    public String getAlgebraic() throws IndexOutOfBoundsException {
        return toLetter(this.getX()) + Integer.toString(8 - this.getY());
    }
}
