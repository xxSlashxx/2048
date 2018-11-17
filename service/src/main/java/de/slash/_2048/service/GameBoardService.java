package de.slash._2048.service;

import de.slash._2048.model.Cell;
import de.slash._2048.model.GameBoard;

public class GameBoardService
{
    public GameBoard createGameBoard()
    {
        Cell[][] cells = new Cell[4][4];

        for (int row = 0; row < cells.length; row++)
        {
            for (int column = 0; column < cells[row].length; column++)
            {
                cells[row][column] = new Cell(row, column, 16);
            }
        }

        return new GameBoard(cells);
    }
}