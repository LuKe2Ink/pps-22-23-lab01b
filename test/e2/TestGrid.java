package e2;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class TestGrid {

    GridImpl grid;
    private static final int SIZE = 7;
    private static final int MINES = 7;

    @BeforeEach
    void initializzation(){
        grid = new GridImpl(SIZE, MINES);
    }

    @Test
    void testReturnTypeCell(){
        assertEquals(Cell.class, grid.getCell(0, 0).getClass());
    }
    
    @Test
    void testFillCells(){
        assertEquals(SIZE*SIZE, grid.getAllCells().size());
    }

    @Test
    void testFillMines(){
        int mines =(int) grid.getAllCells().stream().filter(cell->cell.getType() == e2.Type.MINE).count();
        assertEquals(MINES, mines);
    }

    @Test
    void testFillFields(){
        int fields =(int) grid.getAllCells().stream().filter(cell->cell.getType() == e2.Type.FIELD).count();
        assertEquals((SIZE*SIZE)-MINES, fields);
    }
}
