package search.breadthfirst;

import search.Node;

/** Node subclass with added support for Breadth First Search
 * 
 * @author Andrew Banh
 * @see knighttravails.search.Node
 */
public class NodeBFS extends Node implements Comparable<NodeBFS>{
    private int length; // Distance from Starting position
    
    /** Constructor
     * @see knighttravails.search.Node
     */
    public NodeBFS(String value) {
        super(value);
        this.length = 0;
    }
    
    /** Constructor with Previous Node
     * @see knighttravails.search.Node
     */
    public NodeBFS(String value, NodeBFS from) {
        super(value, from);
        this.length  = from.getLength() + 1;
    }
    
    /** Getter for length
     * @return      Path length from start node
     */
    public int getLength() {
        return this.length;
    }
    
    /** Getter for Previous Node
     * @return          Re-Casted Previous Node
     */
    @Override
    public NodeBFS getFrom() {
        return (NodeBFS) super.getFrom();
    }
    
    /** Compare method to implement Comparable based on length
     * @return          Comparison based on length
     */
    public int compareTo(NodeBFS key) {
        return this.length - key.getLength();
    }
}