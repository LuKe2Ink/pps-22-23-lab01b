package e1.step1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import e1.Logics;
import e1.LogicsImpl;
import e1.Pair;

public class TestLogic {

    Logics chessboard;
    Logics chessboardStatic;

    @BeforeEach
    void initialization(){
        this.chessboard = new LogicsImpl(5);
        this.chessboardStatic = new LogicsImpl(5, new Pair<>(0,1), new Pair<>(2,2));
    }

    @Test
    void testHasPawn(){
        assertInstanceOf(Boolean.class, this.chessboard.hasPawn(4,4));
    }
    @Test
    void testHasKnight(){
        assertInstanceOf(Boolean.class, this.chessboard.hasPawn(4,4));
    }

    @Test
    void testOutOfOfBounds(){
        assertThrows(IndexOutOfBoundsException.class, ()->this.chessboard.hit(6,6));
    }

    @Test
    void testBoolean(){
        assertInstanceOf(Boolean.class, this.chessboard.hit(4,4));
    }


    @Test
    void testHasKnightStaticChessboard(){
        assertTrue(this.chessboardStatic.hasKnight(2, 2));
    }

    @Test
    void testHasPawnStaticChessboard(){
        assertTrue(this.chessboardStatic.hasPawn(0, 1));
    }

    @Test
    void testHasKnightHit(){
        assertTrue(this.chessboardStatic.hit(0, 1));
        assertTrue(this.chessboardStatic.hasKnight(0, 1));
    }

    @Test
    void testKnightMoveAround(){
        assertFalse(this.chessboardStatic.hit(4, 1));
        assertTrue(this.chessboardStatic.hasKnight(4, 1));
        assertFalse(this.chessboardStatic.hit(2, 3));
        assertFalse(this.chessboardStatic.hasKnight(2, 3));
        assertTrue(this.chessboardStatic.hasKnight(4, 1));
        assertFalse(this.chessboardStatic.hit(2, 2));
        assertTrue(this.chessboardStatic.hasKnight(2, 2));
    }
}
