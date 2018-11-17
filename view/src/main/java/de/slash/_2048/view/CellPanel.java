package de.slash._2048.view;

import de.slash._2048.model.Cell;
import de.slash._2048.util.ColorConstants;

import javax.swing.*;
import java.awt.*;

public class CellPanel extends JPanel
{
    private CellLabel cellLabel;
    private Cell cell;

    public CellPanel(Cell cell)
    {
        initializeClass();
        initializeVariables(cell);
        addComponents();
    }

    private void initializeClass()
    {
        setBackground(ColorConstants.CELL_COLOR_DEFAULT);
        setLayout(new BorderLayout());
    }

    private void initializeVariables(Cell cell)
    {
        this.cell = cell;
        initializeCellLabel();
    }

    private void addComponents()
    {
        add(cellLabel, BorderLayout.CENTER);
    }

    private void initializeCellLabel()
    {
        cellLabel = new CellLabel();
        setCellValue(cell.getValue());
    }

    public void setCellValue(Integer value)
    {
        if (value != null)
        {
            cellLabel.setText(value.toString());
        }
        else
        {
            cellLabel.setText(null);
        }

        setCellColor(cell.getValue());
    }

    private void setCellColor(Integer value)
    {
        if (value == null)
        {
            setBackground(ColorConstants.CELL_COLOR_DEFAULT);
        }
        else if (value == 2)
        {
            setBackground(ColorConstants.CELL_COLOR_2);
        }
        else if (value == 4)
        {
            setBackground(ColorConstants.CELL_COLOR_4);
        }
        else if (value == 8)
        {
            setBackground(ColorConstants.CELL_COLOR_8);
        }
        else if (value == 16)
        {
            setBackground(ColorConstants.CELL_COLOR_16);
        }
        else if (value == 32)
        {
            setBackground(ColorConstants.CELL_COLOR_32);
        }
        else if (value == 64)
        {
            setBackground(ColorConstants.CELL_COLOR_64);
        }
        else if (value == 128)
        {
            setBackground(ColorConstants.CELL_COLOR_128);
        }
        else if (value == 256)
        {
            setBackground(ColorConstants.CELL_COLOR_256);
        }
        else if (value == 512)
        {
            setBackground(ColorConstants.CELL_COLOR_512);
        }
        else if (value == 1024)
        {
            setBackground(ColorConstants.CELL_COLOR_1024);
        }
        else if (value == 2048)
        {
            setBackground(ColorConstants.CELL_COLOR_2048);
        }
        else
        {
            setBackground(ColorConstants.CELL_COLOR_DEFAULT);
        }
    }
}