package search.breadthfirst;

import search.Algorithm;
import search.Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.ArrayList;

/** Breadth First Search Algorithm for finding the shortest path between two nodes
 *  Note: Modified to return all of the shortest length paths between two nodes
 * 
 * @author Andrew Banh
 */
public class BreadthFirst implements Algorithm {
    /** */
    private int path_length = -1;
    
    /** Delim for output */
    private static final String delim = "\n";

    /** Collection for storing created Nodes */
    private final HashMap<String, NodeBFS> nodes = new HashMap<String, NodeBFS>();

    /** Queue of open nodes sorted by F Score */
    private final PriorityQueue<NodeBFS>   open  = new PriorityQueue<NodeBFS>();
    
    /** Calculates the shortest path between two graph nodes
     * 
     * @param start         Start coordinates (Algebraic)
     * @param goal          Goal coordinates (Algebraic)
     * @param graph         Graph to be searched
     * @return              Calculated path
     */
    public String[] shortestPath(String start, String goal, Graph graph) {
        NodeBFS current;
        ArrayList<String> paths = new ArrayList<String>();
        
        nodes.put(start, new NodeBFS(start));
        open.add(nodes.get(start));
        
        while (!open.isEmpty()) {
            // Pop node with the lowest path length
            current = open.remove();
            
            // Check if the length of the shortest path has been found / if the current path length has gone over it
            if ((this.path_length == -1) || (current.getLength() <= this.path_length)) {

                // Check if the current path has reached the goal
                if (current.equalValue(goal)) {
                    
                    // Add path to the array of found paths
                    paths.add(constructPath(current));
                    
                } else {
                
                    // Add all neighbours to the open queue
                    processNeighbours(current, graph.getNeighbours(current.getValue()));
                    
                }
            }
        }
        
        // Reconstruct (ArrayList) paths as a String[] for return 
        return Arrays.asList(paths.toArray()).toArray(new String[paths.size()]);
    }
    
    /** Reconstructs the path by backtracking from the given node
     * 
     * @param current       End node to backtrack from
     * @return              String object of an entire path
     */
    private String constructPath(NodeBFS current) {
        String path = "";
        this.path_length = current.getLength();
        while (current.getFrom() != null) {
            path    = current.getValue() + " " + path;
            current = current.getFrom();
        }
        return path;
    }
    
    /** Processes the neighbours of the given node
     * 
     * @param current       Previous node
     * @param neighbours    Array of ndoes to process
     */
    private void processNeighbours(NodeBFS current, String[] neighbours) {
        for (int i=0; i < neighbours.length; i++) {
            nodes.put(neighbours[i], new NodeBFS(neighbours[i], current));
            open.add(nodes.get(neighbours[i]));
        }
    }
    
    /** Delim for output purposes
     * @return              Delim to seperate strings in output
     */
    public String getDelim() {
        return BreadthFirst.delim;
    }
}
