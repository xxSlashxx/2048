package de.slash._2048.model;

public class Cell
{
    private int row;
    private int column;
    private Integer value;

    public Cell(int row, int column, Integer value)
    {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public int getRow()
    {
        return row;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public int getColumn()
    {
        return column;
    }

    public void setColumn(int column)
    {
        this.column = column;
    }

    public Integer getValue()
    {
        return value;
    }

    public void setValue(Integer value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return row + ", " + column;
    }
}