package de.slash._2048.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class MergeTest
{
    @Test
    void testSample1()
    {
        GameBoard inputGameBoard = createInputGameBoard();

        Cell[][] expectedCells = {
                {new Cell(0, 0, 4), new Cell(0, 1, null), new Cell(0, 2, null), new Cell(0, 3, null)},
                {new Cell(1, 0, 4), new Cell(1, 1, null), new Cell(1, 2, null), new Cell(1, 3, null)},
                {new Cell(2, 0, 4), new Cell(2, 1, 2), new Cell(2, 2, null), new Cell(2, 3, null)},
                {new Cell(3, 0, 4), new Cell(3, 1, 4), new Cell(3, 2, null), new Cell(3, 3, null)}
        };
        GameBoard expectedGameBoard = new GameBoard(expectedCells);

        testMerge(inputGameBoard, Direction.LEFT, expectedGameBoard);
    }

    @Test
    void testSample2()
    {
        GameBoard inputGameBoard = createInputGameBoard();

        Cell[][] expectedCells = {
                {new Cell(0, 0, null), new Cell(0, 1, null), new Cell(0, 2, null), new Cell(0, 3, 4)},
                {new Cell(1, 0, null), new Cell(1, 1, null), new Cell(1, 2, null), new Cell(1, 3, 4)},
                {new Cell(2, 0, null), new Cell(2, 1, null), new Cell(2, 2, 2), new Cell(2, 3, 4)},
                {new Cell(3, 0, null), new Cell(3, 1, null), new Cell(3, 2, 4), new Cell(3, 3, 4)}
        };
        GameBoard expectedGameBoard = new GameBoard(expectedCells);

        testMerge(inputGameBoard, Direction.RIGHT, expectedGameBoard);
    }

    @Test
    void testSample3()
    {
        GameBoard inputGameBoard = createInputGameBoard();

        Cell[][] expectedCells = {
                {new Cell(0, 0, 4), new Cell(0, 1, 2), new Cell(0, 2, 4), new Cell(0, 3, 4)},
                {new Cell(1, 0, 2), new Cell(1, 1, null), new Cell(1, 2, 2), new Cell(1, 3, null)},
                {new Cell(2, 0, 4), new Cell(2, 1, null), new Cell(2, 2, null), new Cell(2, 3, null)},
                {new Cell(3, 0, null), new Cell(3, 1, null), new Cell(3, 2, null), new Cell(3, 3, null)}
        };
        GameBoard expectedGameBoard = new GameBoard(expectedCells);

        testMerge(inputGameBoard, Direction.UP, expectedGameBoard);
    }

    @Test
    void testSample4()
    {
        GameBoard inputGameBoard = createInputGameBoard();

        Cell[][] expectedCells = {
                {new Cell(0, 0, null), new Cell(0, 1, null), new Cell(0, 2, null), new Cell(0, 3, null)},
                {new Cell(1, 0, 2), new Cell(1, 1, null), new Cell(1, 2, null), new Cell(1, 3, null)},
                {new Cell(2, 0, 4), new Cell(2, 1, null), new Cell(2, 2, 2), new Cell(2, 3, null)},
                {new Cell(3, 0, 4), new Cell(3, 1, 2), new Cell(3, 2, 4), new Cell(3, 3, 4)}
        };
        GameBoard expectedGameBoard = new GameBoard(expectedCells);

        testMerge(inputGameBoard, Direction.DOWN, expectedGameBoard);
    }

    private void testMerge(GameBoard inputGameBoard, Direction direction, GameBoard expectedGameBoard)
    {
        inputGameBoard.moveValues(direction);
        Cell[][] result = inputGameBoard.getCells();
        Cell[][] expected = expectedGameBoard.getCells();
        assertArrayEquals(expected, result);
    }

    private GameBoard createInputGameBoard()
    {
        Cell[][] inputCells = {
                {new Cell(0, 0, 2), new Cell(0, 1, 2), new Cell(0, 2, null), new Cell(0, 3, null)},
                {new Cell(1, 0, 2), new Cell(1, 1, null), new Cell(1, 2, 2), new Cell(1, 3, null)},
                {new Cell(2, 0, 2), new Cell(2, 1, null), new Cell(2, 2, 2), new Cell(2, 3, 2)},
                {new Cell(3, 0, 4), new Cell(3, 1, null), new Cell(3, 2, 2), new Cell(3, 3, 2)}
        };

        return new GameBoard(inputCells);
    }
}