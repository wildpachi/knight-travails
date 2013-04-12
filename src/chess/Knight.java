package chess;

/** Implmentation of a Knight Chess Piece
 */
public class Knight implements Piece {
    /** Hardcoded moveset for the Knight piece */
    private static final Coordinate[] moves = 
            new Coordinate[] {
                new Coordinate( -2, -1),
                new Coordinate( -1, -2),
                new Coordinate(  1, -2),
                new Coordinate(  2, -1),
                new Coordinate( -2,  1),
                new Coordinate( -1,  2),
                new Coordinate(  1,  2),
                new Coordinate(  2,  1)
            };
    
    /** Getter for the movement offset array constant 
     * @return      Coordinate Object array containing movement offsets
     */
    public Coordinate[] getMoves() {
        return Knight.moves;
    }
}
