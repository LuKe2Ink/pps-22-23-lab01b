package e2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GridImpl{

    //field is where i find a number
    

    //map with a pair of double integer for the position as key, and a pair
    //of Type and Integer for the type of the cells and the value within, use -1 as value of mine
    private Map<Pair<Integer, Integer>, Cell> cells = new HashMap<>();
    private final Random random= new Random();

    public GridImpl(int size, int mines){
        for (int i = 0; i < mines; i++) {
            Pair<Integer, Integer> pair;
            do {
                pair = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
            } while (cells.containsKey(pair));
            cells.put(pair, new Cell(Type.MINE, -1));
        }

        this.fillWithFields(size);
    }

    private void fillWithFields(int size) {
        List<Pair<Integer, Integer>> mines = new ArrayList<>();
        mines = cells.keySet().stream().toList();

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                Pair<Integer,Integer> fieldPair = new Pair<Integer,Integer>(x,y);
                int minesAround = 0;
                for (Pair<Integer,Integer> pair : mines) {
                    if(Math.abs(fieldPair.getX()-pair.getX())<=1 
                        && Math.abs(fieldPair.getY()-pair.getY())<=1)
                        minesAround = minesAround + 1;
                }
                if(!cells.containsKey(fieldPair))
                    cells.put(fieldPair, new Cell(Type.FIELD, minesAround));
            }
        }
    }
    
    public Cell getCell(int row, int col) {
        return this.cells.get(new Pair<Integer,Integer>(row, col));
    }

    public List<Cell> getAllCells() {
        return this.cells.values().stream().toList();
    }

}
