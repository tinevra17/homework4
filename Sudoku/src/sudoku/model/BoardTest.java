package sudoku.model;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @org.junit.jupiter.api.Test
    void makeOriginalBoard() {

    }

    @org.junit.jupiter.api.Test
    void isSolved() {

        Board test = new Board();
        boolean output = test.isSolved();
        int check = 0;
        if(output) check = 1;


    }

    @org.junit.jupiter.api.Test
    void modifyBoard() {

        Board test = new Board();

        test.ypos = 3;
        test.xpos = 3;
        test.value = 3;
        test.modifyBoard();

        boolean output = test.isSolved();
        int check = 0;
        if(output) check = 1;

        assertEquals(0,check);


    }

    @org.junit.jupiter.api.Test
    void checkBoard() {

        Board test = new Board();
        for (int i = 0; i < test.size; i++) {
            test.ypos = i;
            test.xpos = i;
            test.value = i;
            test.modifyBoard();
        }

        boolean output = test.checkBoard(3);
        int check = 0;
        if(output) check = 1;

        assertEquals(0,check);
    }

    @org.junit.jupiter.api.Test
    void size() {
    }

}