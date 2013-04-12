package search;

/** Interface for Search Algorithm objects 
 */
public interface Algorithm {
    /** Prototype for Method for retrieving the shortest path 
     * 
     * @param start     Starting Position on the graph
     * @param goal      Goal Position on the graph
     * @param graph     Graph for searching
     * @return          Array for values along path 
     */
    public String[] shortestPath(String start, String goal, Graph graph);
    
    /** Protoype for fetching deliminator constant for output
     * @return          Deliminator for output purposes 
     */
    public String getDelim();
}
