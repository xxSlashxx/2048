package de.slash._2048.view;

import de.slash._2048.util.NumberConstants;
import de.slash._2048.util.StringConstants;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    private GameBoardPanel gameBoardPanel;

    public MainFrame()
    {
        super(StringConstants.APP_NAME);
        initializeClass();
        initializeVariables();
        addComponents();
    }

    private void initializeClass()
    {
        setSize(NumberConstants.APP_WINDOW_SIZE_WIDTH, NumberConstants.APP_WINDOW_SIZE_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(new BorderLayout());
    }

    private void initializeVariables()
    {
        gameBoardPanel = new GameBoardPanel();
    }

    private void addComponents()
    {
        add(gameBoardPanel, BorderLayout.CENTER);
    }
}