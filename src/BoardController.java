import search.Graph;        // Interface for class
import chess.Board;         // An 8x8 Chess Board
 
/** Controller for a Chess Board
 * @see knighttravails.chess.Board
 */
public class BoardController implements Graph {
    private Board board;                // The Chess Board
    
    /** Constructor that initialises an 8x8 Chess board */
    public BoardController() {
        this.board = new Board();
    }
    
    /** Retrieves the neighbours of a coordinate
     *  i.e The legal moves for a knight piece on the square 
     * 
     *  @param coord    Algebraic coordinates for the initial position
     *  @return         String Array of the connected positions
     */
    public String[] getNeighbours(String coord) {
        board.placePiece('N', coord);
        return board.getMoves(coord);
    }
    
    /** Retrieves distance between two positions on the board
     * 
     *  @param start    Start coordinates
     *  @param end      End coordinates
     *  @return         Distance between Start and End squares
     */
    public int getDistance(String start, String end) {
        return board.getDistance(start, end);
    }

    /** Tests a position on the board by placing a piece on it
     *  @param coord    Algebraic coordinates
     */
    public void testSquare(String coord) {
        board.placePiece('N', coord);
    }
}
