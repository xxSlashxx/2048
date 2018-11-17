package de.slash._2048.app;

import de.slash._2048.view.MainFrame;

import javax.swing.*;

public class AppMain
{
    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainFrame();
            }
        });
    }
}