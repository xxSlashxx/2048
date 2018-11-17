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
    }

    private void setTextColor(String text)
    {
        if (text == null || !(text.equals("2") || text.equals("4")))
        {
            setForeground(ColorConstants.CELL_FONT_COLOR_1);
        }
        else if (text.equals("2") || text.equals("4"))
        {
            setForeground(ColorConstants.CELL_FONT_COLOR_2);
        }
    }
}