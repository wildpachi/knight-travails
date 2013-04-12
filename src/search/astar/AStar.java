package search.astar;

import search.Algorithm;
import search.Graph;

import java.util.HashMap;
import java.util.PriorityQueue;

/** A* Search Algorithm for finding the shortest path between two graph nodes
 */
public class AStar implements Algorithm {
    /** Delim for output purposes */
    private static final String delim = " ";
    
    /** Collection for storing created Nodes */
    private final HashMap<String, NodeAStar> nodes  = new HashMap<String, NodeAStar>();
    
    /** Queue of open nodes sorted by F Score */
    private final PriorityQueue<NodeAStar>   open   = new PriorityQueue<NodeAStar>();
    
    /** Calculates the shortest path between two graph nodes
     * 
     * @param start         Start coordinates (Algebraic)
     * @param goal          Goal coordinates (Algebraic)
     * @param graph         Graph to be searched
     * @return              Calculated shortest path
     */
    public String[] shortestPath(String start, String goal, Graph graph) {
        int gScore, fScore;
        NodeAStar current, neighbour;
        String[] neighbours;
        
        // Initialise starting node and add it to open pqueue
        nodes.put(start, new NodeAStar(start));
        open.add(nodes.get(start));
        
        while (!open.isEmpty()) {
            // Pop node with the lowest F Score and close it
            current = open.remove();
            current.closeNode();
            
            // Check if algorithm has reached the goal
            if (current.equalValue(goal))
                return constructPath(current);

            // Get neighbours
            neighbours = graph.getNeighbours(current.getValue());
            
            for (int i=0; i < neighbours.length; i++) {
                neighbour = getNode(neighbours[i]);
                
                // Increment cost from starting position
                gScore = current.getGScore() + 1;
                
                // Check if the node needs to be updated
                if ((!neighbour.isClosed()) || (gScore < neighbour.getGScore())) {
                    if ((!open.contains(neighbour))) {
                        fScore = gScore + graph.getDistance(neighbour.getValue(), goal);
                        updateNode(neighbour, current, gScore, fScore);
                    }
                }
            }
        }
        return null;
    }
    
    /** Backtracks through nodes to construct the path through the graph
     * 
     * @param current       Node to start backtracking from     
     * @return              Path to start from given node
     */
    private String[] constructPath(NodeAStar current) {
        String[] path = new String[current.getGScore()];
        for (int i = (path.length - 1); i >= 0; i--) {
            path[i] = current.getValue();
            current = current.getFrom();
        }
        
        return path;
    }
    
    /** Selects a node from the HashMap. Initializes the node if it was not found
     * 
     * @param coord         Key / Coordinate (Algebraic) of the desired node
     * @return              A Node with the desired coordinate
     */
    private NodeAStar getNode(String coord) {
        if (!nodes.containsKey(coord))
            nodes.put(coord, new NodeAStar(coord));
        return nodes.get(coord);
    }
    
    /** Updates a node object with new cost calculations
     * 
     * @param node          Node to be updated
     * @param from          Previous node on the path
     * @param gScore        Heuristic cost from start position
     * @param fScore        Heuristic predictive cost to reach goal position
     */
    private void updateNode(NodeAStar node, NodeAStar from, int gScore, int fScore) {
        nodes.put(node.getValue(), new NodeAStar(node.getValue(), from));
        node = nodes.get(node.getValue());
        
        node.setGScore(gScore);
        node.setFScore(fScore);
        if (!open.contains(node.getValue()))
                open.add(node);
    }
    
    /** Delim for output purposes
     * @return              Delim to seperate strings in output
     */
    public String getDelim() {
        return AStar.delim;
    }
}
