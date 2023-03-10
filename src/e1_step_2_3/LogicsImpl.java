package e1_step_2_3;

public class LogicsImpl implements Logics {
	
	private final PawnImpl pawn;
	private KnightImpl knight;
	 
    public LogicsImpl(int size){
        this.pawn = new PawnImpl(size);
        this.knight = new KnightImpl(size, pawn);	
    }

	public LogicsImpl(int size, Pair<Integer, Integer> pawn, Pair<Integer, Integer> knight){
		this.pawn = new PawnImpl(size, pawn);
		this.knight = new KnightImpl(size, this.pawn, knight);
	}
    
	
    
	@Override
	public boolean hit(int row, int col) {
		return this.knight.canHit(row, col);
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.isOccupied(new Pair<Integer,Integer>(row, col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.isOccupied(new Pair<Integer,Integer>(row, col));
	}
}
