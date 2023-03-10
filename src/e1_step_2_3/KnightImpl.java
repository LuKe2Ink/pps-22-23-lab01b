package e1_step_2_3;

import java.util.Random;

public class KnightImpl extends AbstractPiece{

    Pair<Integer, Integer> position;
	private final Random random = new Random();
    private final int size;
    private final PawnImpl pawn;

    public KnightImpl(int chessboardSize, PawnImpl pawn){
        this.size = chessboardSize;
        this.pawn = pawn;
        Pair<Integer, Integer> pair;
        do {
            pair = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
        } while (this.pawn.isOccupied(pair));
        this.position = pair;
        this.type = PieceType.KNIGHT;
    }
    
    public KnightImpl(int chessboardSize, PawnImpl pawn, Pair<Integer, Integer> position){
        this.pawn = pawn;
        this.size = chessboardSize;
        this.position = position;
        this.type = PieceType.KNIGHT;
    }

    @Override
    protected boolean canHit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		// Below a compact way to express allowed moves for the knight
		
        if(this.canMove(row, col))
            return this.pawn.isOccupied(this.position);
		
		return false;
    }

    @Override
    protected Pair<Integer, Integer> getPosition() {
        return this.position;
    }
    

    private boolean canMove(int row, int col) {
        int x = row-this.position.getX();
		int y = col-this.position.getY();
        if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
            System.out.print("prova");
			this.position = new Pair<>(row,col);
            return true;
		}
        return false;
    }
}
