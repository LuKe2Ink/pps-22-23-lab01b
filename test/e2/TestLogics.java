package e2;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.*;

public class TestLogics {

    LogicsImpl logics;
    private static final int SIZE = 7;
    private static final int MINES = 7;
    List<Pair<Integer, Integer>> mines;
    List<Pair<Integer, Integer>> fields;

    @BeforeEach
    void initializzation(){
        logics = new LogicsImpl(SIZE, MINES);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(logics.clickedCell(i, j) == e2.Type.FIELD)
                    fields.add(new Pair<Integer,Integer>(i, j));

                if(logics.clickedCell(i, j) == e2.Type.MINE)
                    mines.add(new Pair<Integer,Integer>(i, j));
            }
        }
    }

    @Test
    void testClearedAllField(){
        for (Pair<Integer,Integer> pair : fields) {
            logics.cellClick(pair.getX(), pair.getY());
        }
        assertTrue(logics.hasClearAllField());
    }
    
}
