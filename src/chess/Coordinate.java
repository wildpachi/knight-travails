package chess;

/** A Coordinate in a 2D Cartesian plane (XY)
 */
public class Coordinate {
    private int x;          //  x coordinate
    private int y;          //  y coordinate
    private boolean valid;  //  Flag if the coordinate is within bounds
    
    /** Constructor
     * @param x             Cartesian X Coordinate
     * @param y             Cartesian Y Coordinate
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /** Getter for X
     * @return              X Coordinate
     */
    public int getX() {
        return x;
    }
    
    /** Getter for Y
     * @return              X Coordinate
     */
    public int getY() {
        return y;
    }
    
    /** Setter for X
     * @param x             X Coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /** Setter for Y
     * @param y             Y Coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /** Conditional Statement if the coordinate is within bounds
     * 
     * @param maxWidth      Maximum Width Boundary
     * @param maxHeight     Maximum Height Boundary
     * @return              Boolean of result of the statement
     */
    public boolean isValid(int maxWidth, int maxHeight) {
        this.valid = (this.x >= 0) && (this.x < maxWidth) 
                  && (this.y >= 0) && (this.y < maxHeight);
        return this.valid;
    }
}