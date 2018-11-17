package de.slash._2048.view;

import de.slash._2048.util.ColorConstants;

import javax.swing.*;

public class CellPanel extends JPanel
{
    public CellPanel()
    {
        initializeClass();
    }

    private void initializeClass()
    {
        setBackground(ColorConstants.CELL_DEFAULT_COLOR);
    }
}