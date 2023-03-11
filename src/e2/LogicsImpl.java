package e2;

import java.util.function.Predicate;

public class LogicsImpl implements Logics {

    private GridImpl grid;
    private final int fields;

    public LogicsImpl(int size, int mines) {
        this.grid = new GridImpl(size, mines);
        this.fields = (size*size)-mines;
    }

    @Override
    public Type clickedCell(int row, int col) {
        return this.grid.getCell(row, col).getType();
    }

    @Override
    public void cellClick(int row, int col) {
        this.grid.getCell(row, col).setClicked();
    }

    @Override
    public void checkFlag(int row, int col) {
        this.grid.getCell(row, col).changeFlag();
    }

    @Override
    public String cellValue(int row, int col) {
        if(this.grid.getCell(row, col).getFlag() && !this.grid.getCell(row, col).getClicked())
            return "/";
        if(this.grid.getCell(row, col).getClicked())
            return String.valueOf(this.grid.getCell(row, col).getValue());
        return "";
    }

    @Override
    public boolean hasClearAllField() {
        Predicate<Cell> predicate = cell -> (cell.getClicked() == true && cell.getType() == Type.FIELD);
        int cleared = (int) this.grid.getAllCells().stream().filter(predicate).count();
        if(cleared == fields)
            return true;
        return false;
    }
}
