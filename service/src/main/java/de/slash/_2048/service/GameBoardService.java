package de.slash._2048.service;

import de.slash._2048.model.Cell;
import de.slash._2048.model.Direction;
import de.slash._2048.model.GameBoard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
        Cell freeCell = getRandomFreeCell(gameBoard);
        freeCell.setValue(2);
    }

    private Cell getRandomFreeCell(GameBoard gameBoard)
    {
        List<Cell> freeCells = getFreeCells(gameBoard);
        Random random = new Random();
        int index = random.nextInt(freeCells.size());
        return freeCells.get(index);
    }

    private List<Cell> getFreeCells(GameBoard gameBoard)
    {
        Cell[][] cells = gameBoard.getCells();
        List<Cell> freeCells = new ArrayList<>();

        for (int row = 0; row < cells.length; row++)
        {
            for (int column = 0; column < cells[row].length; column++)
            {
                if (cells[row][column].getValue() == null)
                {
                    freeCells.add(cells[row][column]);
                }
            }
        }

        return freeCells;
    }

    public boolean hasWon(GameBoard gameBoard)
    {
        Cell[][] cells = gameBoard.getCells();

        for (int row = 0; row < cells.length; row++)
        {
            for (int column = 0; column < cells[row].length; column++)
            {
                if (cells[row][column].getValue() != null && cells[row][column].getValue() == 2048)
                {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean canMove(GameBoard gameBoard)
    {
        return !getFreeCells(gameBoard).isEmpty();
    }

    public void moveValues(GameBoard gameBoard, Direction direction)
    {
        if (direction == Direction.LEFT || direction == Direction.RIGHT)
        {
            mergeRows(gameBoard, direction);
        }
        else if (direction == Direction.UP || direction == Direction.DOWN)
        {
            mergeColumns(gameBoard, direction);
        }
    }

    private void mergeRows(GameBoard gameBoard, Direction direction)
    {
        for (int row = 0; row < gameBoard.getWidth(); row++)
        {
            Cell[] cells = gameBoard.getCells()[row];
            moveAndMergeEqual(cells, direction);
        }
    }

    private void mergeColumns(GameBoard gameBoard, Direction direction)
    {
        for (int column = 0; column < gameBoard.getWidth(); column++)
        {
            Cell[] cells = new Cell[gameBoard.getWidth()];

            for (int row = 0; row < gameBoard.getWidth(); row++)
            {
                cells[row] = gameBoard.getCells()[row][column];
            }

            moveAndMergeEqual(cells, direction);
        }
    }

    public Cell[] moveAndMergeEqual(Cell[] cells, Direction direction)
    {
        List<Integer> notNullValues = getNotNullValuesFromCells(cells);
        LinkedList<Integer> mergedValues = mergeValues(notNullValues, direction);
        LinkedList<Integer> movedAndMergedValues = moveValuesInRowOrColumn(mergedValues, cells.length, direction);

        for (int i = 0; i < cells.length; i++)
        {
            cells[i].setValue(movedAndMergedValues.get(i));
        }

        return cells;
    }

    private List<Integer> getNotNullValuesFromCells(Cell[] cells)
    {
        List<Integer> notNullValues = new ArrayList<>();

        for (int i = 0; i < cells.length; i++)
        {
            if (cells[i].getValue() != null)
            {
                notNullValues.add(cells[i].getValue());
            }
        }

        return notNullValues;
    }

    private LinkedList<Integer> mergeValues(List<Integer> values, Direction direction)
    {
        LinkedList<Integer> mergedValues = new LinkedList<>();
        Integer lastValue = null;

        if (direction == Direction.LEFT || direction == Direction.UP)
        {
            for (int i = 0; i < values.size(); i++)
            {
                if (values.get(i).equals(lastValue))
                {
                    mergedValues.removeLast();
                    mergedValues.add(values.get(i) * 2);
                    lastValue = null;
                }
                else
                {
                    mergedValues.addLast(values.get(i));
                    lastValue = values.get(i);
                }
            }
        }
        else if (direction == Direction.RIGHT || direction == Direction.DOWN)
        {
            for (int i = values.size() - 1; i > -1; i--)
            {
                if (values.get(i).equals(lastValue))
                {
                    mergedValues.removeFirst();
                    mergedValues.addFirst(values.get(i) * 2);
                    lastValue = null;
                }
                else
                {
                    mergedValues.addFirst(values.get(i));
                    lastValue = values.get(i);
                }
            }
        }

        return mergedValues;
    }

    private LinkedList<Integer> moveValuesInRowOrColumn(LinkedList<Integer> mergedValues, int rowOrColumnWidth, Direction direction)
    {
        for (int i = 0; i < rowOrColumnWidth; i++)
        {
            if (i >= mergedValues.size())
            {
                if (direction == Direction.RIGHT || direction == Direction.DOWN)
                {
                    mergedValues.addFirst(null);
                }
                else
                {
                    mergedValues.addLast(null);
                }
            }
        }

        return mergedValues;
    }
}