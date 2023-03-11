package e2;

public interface Logics {
    
    Type clickedCell(int row, int col);

    void cellClick(int row, int col);

    String cellValue(int row, int col);

    void checkFlag(int row, int col);

    boolean hasClearAllField();
}
