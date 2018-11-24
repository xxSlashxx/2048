package de.slash._2048.controller;

import de.slash._2048.model.Direction;
import de.slash._2048.model.GameBoard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;

public class GameBoardController implements KeyListener
{
    private GameBoard gameBoard;

    public GameBoardController(PropertyChangeListener propertyChangeListener)
    {
        gameBoard = new GameBoard();
        gameBoard.addPropertyChangeListener(propertyChangeListener);
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
            gameBoard.moveValues(direction);
            gameBoard.addNewValue();
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        // Nothing to do
    }
}
