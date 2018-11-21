package de.slash._2048.view;

import de.slash._2048.model.Cell;
import de.slash._2048.model.Direction;
import de.slash._2048.model.GameBoard;
import de.slash._2048.service.GameBoardService;
import de.slash._2048.util.ColorConstants;
import info.clearthought.layout.TableLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameBoardPanel extends JPanel implements KeyListener
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
        addKeyListener(this);
        setFocusable(true);
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


    private void refreshComponents()
    {
        Component[] components = getComponents();

        for (Component comp : components)
        {
            ((CellPanel) comp).refreshPanel();
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        // Nothing to do
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        Direction direction = null;

        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            direction = Direction.LEFT;
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            direction = Direction.RIGHT;
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            direction = Direction.UP;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            direction = Direction.DOWN;
        }

        if (direction != null)
        {
            gameBoardService.moveValues(gameBoard, direction);
            checkGameBoard();
            gameBoardService.addNewValue(gameBoard);
            refreshComponents();
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        // Nothing to do
    }

    private void checkGameBoard()
    {
        if (!gameBoardService.canMove(gameBoard))
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

        if (gameBoardService.hasWon(gameBoard))
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
    }
}