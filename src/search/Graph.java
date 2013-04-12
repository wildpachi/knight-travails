package search;

/** Interface for Graph objects 
 */
public interface Graph {
    /** Prototype method for getting the neighbouring graph nodes 
     * 
     * @param coord     Initial Node Position
     * @return          Neighbouring Nodes Positions
     */
    public abstract String[] getNeighbours(String coord);
    
    /** Prototype method for getting the distance between two graph nodes 
     * 
     * @param start     Start coordinate
     * @param end       End coordinate
     * @return          Distance between Start and End
     */
    public int getDistance(String start, String end);

    /** Prototype method for testing if the goal is a valid coordinate */
    public void testSquare(String coord);
}
