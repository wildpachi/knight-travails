import search.Algorithm;                    // Algorithm Interface for Graph Search         
import search.astar.AStar;                  // A* Algorithm for Graph Search
import search.breadthfirst.BreadthFirst;    // Breadth First Search

/** Driver for Knight Travails Problem
 */
public class KnightTravails {
    
    /** Main driver method
     * 
     * @param args      Takes up to 3 arguments. <br>
     *                      <[A-Z][0-9]> - Starting Position <br>
     *                      <[A-Z][0-9]> - End Position <br>
     *                      '-a','-all'  - (Flag) Use BreadthFirstSearch to display all paths
     */
    public static void main (String[] args) {
        Algorithm algorithm;
        String[] path = null;
        BoardController bc  = new BoardController();
        
        String opts[] = getOpts(args);      
        
        if ((opts[0] == null) || (opts[1] == null)) {
            System.out.println(ppUsage());
            System.exit(1);
        }
        
        if (opts[2] != null)
            algorithm = new BreadthFirst();
        else
            algorithm = new AStar();
                
        try {
            // Tests if given arguments are on the board
            bc.testSquare(opts[0]);
            bc.testSquare(opts[1]);

            // Check if start and end positions are the same
            if (opts[0].equals(opts[1])) {
                // If same, then just return the end position
                path    = new String[1];
                path[0] = opts[0];
            } else {
                // Get shortest path
                path = algorithm.shortestPath(opts[0], opts[1], bc);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error (Index Out of Bounds): One or more coordinates were invalid.");
            // e.printStackTrace();
            System.exit(1);
        } finally {
            // Output shortest path
            System.out.println(ppStrings(path, algorithm.getDelim()));  
        }
    }
    
    /** Parses over the given program arguments and reformats then into understandable operators
     * 
     * @param args      Program arguments
     * @return          Operator array. [ Start Position, End Position, Flag for All Paths ]
     */
    private static String[] getOpts(String[] args) {
        String argument;
        String[] opts = {null, null, null};
        
        if (args.length >= 2) {
            for (int i=0, j=0; i < args.length; i++) {
                if ((args[i].equals("-a")) || (args[i].equals("-all"))) {
                    opts[2] = "true";
                } else {
                    if (j < 2)
                        if ((argument = toAlgebraic(args[i])) != null)
                            opts[j++] = argument;
                }
            }
        }
        return opts;
    }
    
    /** Checks and converts a string to a proper Algebraic Coordinate
     * @return              
     */
    private static String toAlgebraic(String alg) {     
        if (alg.length() == 2)
            if (Character.isLetter(alg.charAt(0)))
                if (Character.isDigit(alg.charAt(1)))
                        return "" + Character.toUpperCase(alg.charAt(0)) + alg.charAt(1); 
        return null;
    }
    
    /** Pretty print for a String Array
     * 
     * @param strings       String Array to be output
     * @param algDelim      Delimitor for the output
     * @return
     */
    private static String ppStrings(String[] strings, String algDelim) {
        String delim = "";
        String output = "";
        
        if (strings != null) {
            for (int i=0; i < strings.length; i++){
                output += delim + strings[i];
                delim = algDelim;
            }
        } 
        
        return output;
    }
    /** Pretty print for program usage instructions
     * @return              Pretty printed message
     */
    private static String ppUsage() {
        String output = "";
        output += "Usage: KnightTravails start end [-all] \n\n";
        output += "start, end \t Algebraic coordinate. (Form: [A-Z][0-9]) \n";
        output += "-a,-all \t (Optional) Use BreadthFirstSearch to display all paths";
        return output;
    }
}
