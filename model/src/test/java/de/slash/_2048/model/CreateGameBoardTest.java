package de.slash._2048.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateGameBoardTest
{
    @Test
    void testSizeOfGameBoard()
    {
        GameBoard gameBoard = new GameBoard();
        int rows = gameBoard.getCells().length;
        int columns = gameBoard.getCells()[0].length;
        Assertions.assertEquals(4, rows);
        Assertions.assertEquals(4, columns);
    }

    @Test
    void testInitializedCellsOfGameBoard()
    {
        GameBoard gameBoard = new GameBoard();
        Cell[][] cells = gameBoard.getCells();
        int initializedCells = 0;

        for (int row = 0; row < cells.length; row++)
        {
            for (int column = 0; column < cells[row].length; column++)
            {
                if (cells[row][column].getValue() != null)
                {
                    initializedCells++;
                }
            }
        }

        Assertions.assertEquals(2, initializedCells);
    }
}