package de.slash._2048.view;

import de.slash._2048.model.Cell;
import de.slash._2048.model.GameBoard;
import de.slash._2048.service.GameBoardService;
import de.slash._2048.util.ColorConstants;
import info.clearthought.layout.TableLayout;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class GameBoardPanel extends JPanel
{
    private GameBoardService gameBoardService;
    private GameBoard gameBoard;

    public GameBoardPanel()
    {
        initializeClass();
        initializeVariables();
        constructLayout();
        addComponents();
    }

    private void initializeClass()
    {
        setBackground(ColorConstants.GAME_BOARD_BACKGROUND);
        setLayout(new MigLayout("", "[]15[]", "[]15[]"));
    }

    private void initializeVariables()
    {
        gameBoardService = new GameBoardService();
        gameBoard = gameBoardService.createGameBoard();
        gameBoardService.initializeGameBoard(gameBoard);
    }

    private void constructLayout()
    {
        double size[][] = {
                {0, 14, 107, 14, 107, 14, 107, 14, 107, 14}, //Columns
                {0, 14, 107, 14, 107, 14, 107, 14, 107, 14} //Rows
        };

        setLayout(new TableLayout(size));
    }

    private void addComponents()
    {
        Cell[][] cells = gameBoard.getCells();

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
}