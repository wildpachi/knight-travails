package search.astar;

import search.Node;

/** Node subclass with added support for A* Algorithm
 * @see knighttravails.search.Node
 */
public class NodeAStar extends Node implements Comparable<NodeAStar>{
    private int gScore;         // Heuristic cost from starting position
    private int fScore;         // Heuristic prediction to goal position
    private boolean closed;     // Node search status
    
    /** Constructor
     * @see knighttravails.search.Node
     */
    public NodeAStar(String value) {
        super(value);
        closed = false;
    }

    /** Constructor with Previous Node
     * @see knighttravails.search.Node
     */
    public NodeAStar(String value, Node from) {
        super(value, from);
        closed = false;
    }
    
    /** Getter for G Score
     * @return          G Score for A*
     */
    public int getGScore() {
        return gScore;
    }
    
    /** Getter for F Score
     * @return          F Score for A*
     */
    public int getFScore() {
        return fScore;
    }
    
    /** Getter for Previous Node
     * @return          Re-Casted Previous Node
     */
    @Override
    public NodeAStar getFrom() {
        return (NodeAStar) super.getFrom();
    }

    /** Setter for G Score
     * @param gScore    New G Score
     */
    public void setGScore(int gScore) {
        this.gScore = gScore;
    }

    /** Setter for F Score
     * @param fScore    New F Score
     */
    public void setFScore(int fScore) {
        this.fScore = fScore;
    }
    
    /** Closes the node after a search / Setter for Closed
     */
    public void closeNode() {
        this.closed = true;
    }
    
    /**  Conditional method based on Close
     * @return          If the node has been searched and closed
     */
    public boolean isClosed() {
        return this.closed;
    }
    
    /** Compare method to implement Comparable based on F Score
     * @return          Comparison based on F Score
     */
    public int compareTo(NodeAStar key) {
        return this.fScore - key.getFScore();
    }   
}
