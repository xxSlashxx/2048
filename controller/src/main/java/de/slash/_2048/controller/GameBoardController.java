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
        Direction direction = resolveDirection(e);

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

    private Direction resolveDirection(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            return Direction.LEFT;
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            return Direction.RIGHT;
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            return Direction.UP;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            return Direction.DOWN;
        }
        else
        {
            return null;
        }
    }
}