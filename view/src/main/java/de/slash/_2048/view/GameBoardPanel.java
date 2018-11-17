package de.slash._2048.view;

import de.slash._2048.util.ColorConstants;
import info.clearthought.layout.TableLayout;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class GameBoardPanel extends JPanel
{
    public GameBoardPanel()
    {
        initializeClass();
        constructLayout();
        addComponents();
    }

    private void initializeClass()
    {
        setBackground(ColorConstants.GAME_BOARD_BACKGROUND);
        setLayout(new MigLayout("", "[]15[]", "[]15[]"));
    }

    private void constructLayout()
    {
        double size[][] = {
                {15, 150, 15, 150, 15, 150, 15, 150, 15}, //Columns
                {15, 150, 15, 150, 15, 150, 15, 150, 15} //Rows
        };

        setLayout(new TableLayout(size));
    }

    private void addComponents()
    {
        add(new CellPanel(), "1,1");
        add(new CellPanel(), "3,1");
        add(new CellPanel(), "5,1");
        add(new CellPanel(), "7,1");

        add(new CellPanel(), "1,3");
        add(new CellPanel(), "3,3");
        add(new CellPanel(), "5,3");
        add(new CellPanel(), "7,3");

        add(new CellPanel(), "1,5");
        add(new CellPanel(), "3,5");
        add(new CellPanel(), "5,5");
        add(new CellPanel(), "7,5");

        add(new CellPanel(), "1,7");
        add(new CellPanel(), "3,7");
        add(new CellPanel(), "5,7");
        add(new CellPanel(), "7,7");
    }
}