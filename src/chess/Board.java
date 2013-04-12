package chess;

import java.util.Arrays;                // Used to convert ArrayList to a String[]
import java.util.ArrayList;             // Used to generate a variable length string array to return moves

/** An 8x8 Chessboard
 */
public class Board {
    private final int width = 8;        // Default square width of the chessboard
    private final int height = 8;       // Default square height of the chessboard
    private Square[][] squares;         // 2D Array holding all the squares of the board
    
    /** Constructor using 8x8 defaults */
    public Board() {
        this.squares = new Square[width][height];
        for (int i=0; i < width; i++) 
            for (int j=0; j < height; j++) 
                this.squares[i][j] = new Square(new Coordinate(i,j));
    }

    /** Places a chess piece on the square at the given coordinates
     * Note: Only Knight ('N') is implemented at present
     * @param pcode     Character code for the chess piece
     * @param alg       Algebraic coordinates for the position
     */
    public void placePiece(char pcode, String alg) {
        Piece piece;
        Algebraic   coord  = new Algebraic(alg);
        Square      square = squares[coord.getX()][coord.getY()];
        
        switch (Character.toUpperCase(pcode)) {
            case 'N': piece = new Knight(); break;
            default:  piece = null;
        }
        
        square.setPiece(piece);
    }
    
    /** Calculates the distance in squares from one square to another
     * @param start     Start position
     * @param end       End position
     * @return          Distance in squares between two positions
     */
    public int getDistance(String start, String end) {
        Algebraic a_start = new Algebraic(start);
        Algebraic a_end   = new Algebraic(end);
        int x = Math.abs(a_start.getX() - a_end.getX());
        int y = Math.abs(a_start.getY() - a_end.getY());
        
        return x + y;
    }
    
    /** Gathers valid moves for a given piece on a given square
     * @param coords    Starting position
     * @return          String array containing moves in Algebraic notation
     */
    public String[] getMoves(String coords) {
        Algebraic   start = new Algebraic(coords);
        Algebraic[] moves = squares[start.getX()][start.getY()].getMoves();
        ArrayList<String> validMoves = new ArrayList<String>();
        
        for (int i=0; i < moves.length; i++) {
            if ( moves[i].isValid(width,height))
                validMoves.add(moves[i].getAlgebraic());    // Filters out moves which are out of bounds
        }
        
        return Arrays.asList(validMoves.toArray()).toArray(new String[validMoves.size()]);
    }
}
