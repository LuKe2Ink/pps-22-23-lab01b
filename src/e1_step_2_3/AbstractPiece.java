package e1_step_2_3;

public abstract class AbstractPiece implements Logics{

    public enum PieceType{
        KNIGHT, PAWN;
    }

    protected PieceType type;

    @Override
    public boolean hit(int row, int col) {
        return this.canHit(row, col);
    }

    @Override
    public boolean hasKnight(int row, int col) {
        Pair<Integer, Integer> position = this.getPosition(); 
        if(this.type == PieceType.KNIGHT 
            && position.getX() == row && position.getY()==col)
            return true;
        return false;
    }

    @Override
    public boolean hasPawn(int row, int col) {
        Pair<Integer, Integer> position = this.getPosition(); 
        if(this.type == PieceType.PAWN 
            && position.getX() == row && position.getY()==col)
            return true;
        return false;
    }

    public boolean isOccupied(Pair<Integer, Integer> point){
        if(this.getPosition().equals(point))
            return true;
        return false;
    }

    protected abstract boolean canHit(int row, int col);
    
    protected abstract Pair<Integer, Integer> getPosition();
}
