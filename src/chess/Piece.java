package chess;

/** Interface for a Chess Piece
 */
public interface Piece {
    /** Retrieves an array of movement offsets based on the piece
     * @return      Array of Coordinate objects containing movement offsets
     */
    public Coordinate[] getMoves();
}
