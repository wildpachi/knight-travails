package search;

/** Abstract Data Class for a Node Object used by a Search Algorithm 
 */
public abstract class Node {
    private String value;
    private Node   from;
    
    /** Constructor for Node
     *      
     * @param value     Stored value of the node / Algebraic Coordinate 
     */
    public Node(String value) {
        this.value = value;
        this.from  = null;
    }
    
    /** Constructor for Node with path construction
     *      
     * @param value     Stored value of the node / Algebraic Coordinate
     * @param from      Node that this came from
     */
    public Node(String value, Node from) {
        this.value = value;
        this.from  = from;
    }
    
    /** Getter for the stored value
     * @return          Stored Value
     */
    public String getValue() {
        return value;
    }
    
    /** Getter for the previous node
     * @return          Previous Node
     */
    public Node getFrom() {
        return from;
    }
    
    /** String match for stored value
     * @return          If stored values match
     */
    public boolean equalValue(String key) {
        return (this.value.equals(key));
    }
    
    @Override
    public String toString() {
        return this.value;
    }
}
