package de.slash._2048.view;

import de.slash._2048.controller.GameBoardController;
import de.slash._2048.model.Cell;
import de.slash._2048.util.ColorConstants;
import de.slash._2048.util.StringConstants;
import info.clearthought.layout.TableLayout;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GameBoardPanel extends JPanel implements PropertyChangeListener
{
    public GameBoardPanel()
    {
        initializeClass();
        constructLayout();
        addController();
    }

    private void initializeClass()
    {
        setBackground(ColorConstants.GAME_BOARD_BACKGROUND);
        setFocusable(true);
    }

    private void addController()
    {
        addKeyListener(new GameBoardController(this));
    }

    private void constructLayout()
    {
        double size[][] = {
                {0, 14, 107, 14, 107, 14, 107, 14, 107, 14}, //Columns
                {0, 14, 107, 14, 107, 14, 107, 14, 107, 14} //Rows
        };

        setLayout(new TableLayout(size));
    }

    private void initComponents(Cell[][] cells)
    {
        for (int row = 0; row < cells.length; row++)
        {
            for (int column = 0; column < cells[row].length; column++)
            {
                Cell cell = cells[row][column];
                int columnInTable = (column + 1) * 2;
                int rowInTable = (row + 1) * 2;
                add(new CellPanel(cell), columnInTable + "," + rowInTable);
            }
        }
    }

    private void refreshComponents()
    {
        Component[] components = getComponents();

        for (Component comp : components)
        {
            ((CellPanel) comp).refreshPanel();
        }
    }

    private void showWonDialog()
    {
        int selectedOption = JOptionPane.showConfirmDialog(
                this,
                "TODO",
                "TODO",
                JOptionPane.YES_NO_OPTION);

        if (selectedOption == JOptionPane.YES_OPTION)
        {

        }
    }

    private void showLostDialog()
    {
        int selectedOption = JOptionPane.showConfirmDialog(
                this,
                "TODO",
                "TODO",
                JOptionPane.YES_NO_OPTION);

        if (selectedOption == JOptionPane.YES_OPTION)
        {

        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent)
    {
        String eventPropertyname = propertyChangeEvent.getPropertyName();

        if (eventPropertyname.equals(StringConstants.PROPERTY_CHANGE_EVENT_INIT))
        {
            initComponents((Cell[][]) propertyChangeEvent.getNewValue());
        }
        else if (eventPropertyname.equals(StringConstants.PROPERTY_CHANGE_EVENT_UPDATE))
        {
            refreshComponents();
        }
        else if (eventPropertyname.equals(StringConstants.PROPERTY_CHANGE_EVENT_WON))
        {
            showWonDialog();
        }
        else if (eventPropertyname.equals(StringConstants.PROPERTY_CHANGE_EVENT_LOST))
        {
            showLostDialog();
        }
    }
}