package de.slash._2048.model;

public class GameBoard
{
    private Cell[][] cells;

    public GameBoard(Cell[][] cells)
    {
        this.cells = cells;
    }

    public Cell[][] getCells()
    {
        return cells;
    }

    public void setCells(Cell[][] cells)
    {
        this.cells = cells;
    }
}