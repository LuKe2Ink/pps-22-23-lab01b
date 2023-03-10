package e1.step2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import e1_step_2_3.KnightImpl;
import e1_step_2_3.Pair;
import e1_step_2_3.PawnImpl;

public class TestKnightImpl{

    private static int SIZE = 5;

    KnightImpl knight;
    PawnImpl pawn = new PawnImpl(SIZE, new Pair<Integer,Integer>(0, 1)); 

    @BeforeEach
    void initialization(){
        this.knight = new KnightImpl(SIZE, pawn, new Pair<Integer,Integer>(2, 2));
    }

    @Test
    void testMove(){
        assertFalse(this.knight.hit(1, 0));
        assertTrue(this.knight.hasKnight(1, 0));
    }

    @Test
    void testMoveAround(){
        assertFalse(this.knight.hit(1, 0));
        assertTrue(this.knight.hasKnight(1, 0));
        //current postion (1,0) can't move on (3,0)
        assertFalse(this.knight.hit(3, 0));
        assertFalse(this.knight.hasKnight(3, 0));
        assertFalse(this.knight.hit(2, 2));
        assertTrue(this.knight.hasKnight(2, 2));
        assertFalse(this.knight.hit(0, 3));
        assertTrue(this.knight.hasKnight(0, 3));
    }

    @Test
    void testHit(){
        assertTrue(this.knight.hit(0, 1));
    }

    @Test
    void testMoveAndHit(){
        assertFalse(this.knight.hit(1, 0));
        assertTrue(this.knight.hasKnight(1, 0));
        assertFalse(this.knight.hit(2, 2));
        assertTrue(this.knight.hasKnight(2, 2));
        assertTrue(this.knight.hit(0, 1));
    }
}