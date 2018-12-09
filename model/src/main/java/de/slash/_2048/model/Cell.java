package de.slash._2048.model;

import java.util.Objects;

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

    public int getColumn()
    {
        return column;
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
        return "(" + row + "," + column + " = " + value + ")";
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Cell cell = (Cell) o;

        return row == cell.row && column == cell.column && Objects.equals(value, cell.value);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(row, column, value);
    }
}