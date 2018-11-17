package de.slash._2048.service;

import de.slash._2048.model.Cell;
import de.slash._2048.model.GameBoard;

import java.awt.*;
import java.util.Random;

public class GameBoardService
{
    public GameBoard createGameBoard()
    {
        Cell[][] cells = new Cell[4][4];

        for (int row = 0; row < cells.length; row++)
        {
            for (int column = 0; column < cells[row].length; column++)
            {
                cells[row][column] = new Cell(row, column, null);
            }
        }

        return new GameBoard(cells);
    }

    public void initializeGameBoard(GameBoard gameBoard)
    {
        addNewValue(gameBoard);
        addNewValue(gameBoard);
    }

    public void addNewValue(GameBoard gameBoard)
    {
        Point coordinate = generateRandomCoordinate(gameBoard);
        gameBoard.getCells()[coordinate.y][coordinate.x].setValue(2);
    }

    private Point generateRandomCoordinate(GameBoard gameBoard)
    {
        Random random = new Random();
        int row = random.nextInt(gameBoard.getWidth());
        int column = random.nextInt(gameBoard.getWidth());
        return new Point(column, row);
    }
}