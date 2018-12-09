package de.slash._2048.model;

import de.slash._2048.util.StringConstants;

import javax.swing.event.SwingPropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GameBoard
{
    private Cell[][] cells;

    private SwingPropertyChangeSupport propertyChangeSupport;

    public GameBoard()
    {
        propertyChangeSupport = new SwingPropertyChangeSupport(this);
        createGameBoard();
        initializeGameBoard();
    }

    public GameBoard(Cell[][] customCells)
    {
        propertyChangeSupport = new SwingPropertyChangeSupport(this);
        cells = customCells;
    }

    public Cell[][] getCells()
    {
        return cells;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl)
    {
        propertyChangeSupport.addPropertyChangeListener(pcl);
        propertyChangeSupport.firePropertyChange(StringConstants.PROPERTY_CHANGE_EVENT_INIT, null, cells);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl)
    {
        propertyChangeSupport.removePropertyChangeListener(pcl);
    }

    public void firePropertyChange()
    {
        propertyChangeSupport.firePropertyChange(StringConstants.PROPERTY_CHANGE_EVENT_UPDATE, null, cells);

        if (hasWon())
        {
            propertyChangeSupport.firePropertyChange(StringConstants.PROPERTY_CHANGE_EVENT_WON, null, cells);
        }
    }

    private void createGameBoard()
    {
        cells = new Cell[4][4];

        for (int row = 0; row < cells.length; row++)
        {
            for (int column = 0; column < cells[row].length; column++)
            {
                cells[row][column] = new Cell(row, column, null);
            }
        }
    }

    private void initializeGameBoard()
    {
        addNewValue();
        addNewValue();
    }

    public void addNewValue()
    {
        if (freeCellsExists())
        {
            Cell freeCell = getRandomFreeCell();
            freeCell.setValue(2);
            firePropertyChange();
        }
    }

    private Cell getRandomFreeCell()
    {
        List<Cell> freeCells = getFreeCells();
        Random random = new Random();
        int index = random.nextInt(freeCells.size());
        return freeCells.get(index);
    }

    private List<Cell> getFreeCells()
    {
        Cell[][] cells = getCells();
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

    public void moveValues(Direction direction)
    {
        if (direction == Direction.LEFT || direction == Direction.RIGHT)
        {
            mergeRows(direction);
        }
        else if (direction == Direction.UP || direction == Direction.DOWN)
        {
            mergeColumns(direction);
        }

        firePropertyChange();
    }

    private void mergeRows(Direction direction)
    {
        for (int row = 0; row < getWidth(); row++)
        {
            Cell[] cells = getCells()[row];
            moveAndMergeEqual(cells, direction);
        }
    }

    private void mergeColumns(Direction direction)
    {
        for (int column = 0; column < getWidth(); column++)
        {
            Cell[] cells = new Cell[getWidth()];

            for (int row = 0; row < getWidth(); row++)
            {
                cells[row] = getCells()[row][column];
            }

            moveAndMergeEqual(cells, direction);
        }
    }

    private int getWidth()
    {
        return cells != null ? cells.length : 0;
    }

    private Cell[] moveAndMergeEqual(Cell[] cells, Direction direction)
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

    public boolean freeCellsExists()
    {
        return !getFreeCells().isEmpty();
    }

    public boolean hasWon()
    {
        Cell[][] cells = getCells();

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
}