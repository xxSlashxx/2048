package de.slash._2048.view;

import de.slash._2048.util.ColorConstants;
import de.slash._2048.util.StringConstants;

import javax.swing.*;
import java.awt.*;

public class CellLabel extends JLabel
{
    public CellLabel()
    {
        initializeClass();
    }

    private void initializeClass()
    {
        setFont(new Font(StringConstants.FONT_NAME, Font.BOLD, 55));
        setForeground(ColorConstants.CELL_FONT_COLOR_1);
        setHorizontalAlignment(CENTER);
    }

    @Override
    public void setText(String text)
    {
        super.setText(text);
        setTextColor(text);
        setTextFont(text);
    }

    private void setTextColor(String text)
    {
        if (text != null && (text.equals("2") || text.equals("4")))
        {
            setForeground(ColorConstants.CELL_FONT_COLOR_2);
        }
        else
        {
            setForeground(ColorConstants.CELL_FONT_COLOR_1);
        }
    }

    private void setTextFont(String text)
    {
        if (text != null)
        {
            if (text.length() > 3)
            {
                setFont(new Font(StringConstants.FONT_NAME, Font.BOLD, 35));
            }
            else if (text.length() > 2)
            {
                setFont(new Font(StringConstants.FONT_NAME, Font.BOLD, 47));
            }
        }
        else
        {
            setFont(new Font(StringConstants.FONT_NAME, Font.BOLD, 55));
        }
    }
}