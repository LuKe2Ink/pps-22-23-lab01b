package e1_step_2_3;

import java.util.Random;

public class PawnImpl extends AbstractPiece{

    Pair<Integer, Integer> position;
	private final Random random = new Random();
    private final int size;

    public PawnImpl(int chessboardSize){
        this.size = chessboardSize;
        this.position = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
        this.type = PieceType.PAWN;
    }

    public PawnImpl(int chessboardSize,  Pair<Integer, Integer> position){
        this.size = chessboardSize;
        this.position = position;
        this.type = PieceType.PAWN;
    }
    

    @Override
    protected boolean canHit(int row, int col) {
        return false;
    }

    @Override
    protected Pair<Integer, Integer> getPosition() {
        return this.position;
    }
    
}
