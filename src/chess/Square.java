package chess;

/** Chessboard Square
 */
public class Square {
    private Piece piece;        //  Current chess piece sitting on the square
    private Coordinate coord;   //  Coordinates of the square on the board
        
    /** Constructor for a Chessboard Square
     * @param coord     Coordinates of the square
     */
    public Square(Coordinate coord) {
        this.coord = coord;
        this.piece = null;
    }
    
    /** Setter for the square's current piece
     * @param piece     New chess piece
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    
    /** Creates an array of valid moves based on the movement offsets given by the current piece 
     * @return          Array of alegebraic coordinate objects containing the valid moves
     */
    public Algebraic[] getMoves() {
        Coordinate[] offsets = this.piece.getMoves();
        Algebraic[]  moves   = new Algebraic[offsets.length];
        
        // Combines current position with coordinate offsets to generate a new array of coordinates  
        for (int i=0; i < offsets.length; i++)
            moves[i] = new Algebraic(this.coord.getX(), this.coord.getY(), offsets[i]);
        
        return moves;
    }
}
