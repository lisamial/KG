package com.lisamia;

import javax.swing.*;
import java.awt.*;

public class Form {
    private JPanel contentPane;
    private JPanel panelDraw;
    private draw draw;

    public Form(){
        panelDraw.setLayout(new BorderLayout());;
        draw = new draw();
        panelDraw.add(draw);
    }

    private class draw extends JPanel{
        public void paintComponent(Graphics gr) {
            gr.setColor(Color.DARK_GRAY);
            gr.fillRect(0, 0, getWidth(), getHeight());
            gr.setColor(Color.RED);
            DDA.drawDDA(gr, getWidth()/2, 0, getWidth()-300, getHeight());
            DDA.drawDDA(gr, getWidth()/2, 0, 300, getHeight());
            gr.setColor(new Color(128, 6, 6));
            Bresenham.Bresenham(gr, 200, 50 + getHeight()/3 , getWidth()-200, 50 + getHeight()/3);
            Bresenham.Bresenham(gr, 200, 50 + getHeight()/3, getWidth()-300, getHeight());
            Wu.Wu(gr,getWidth()-200, 50 + getHeight()/3, 300, getHeight());

        }
    }

    public static void main(String[] args){
        JFrame f = new JFrame("-Wow, what is it?  -Nonsense =)");
        f.setContentPane(new Form().contentPane);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.pack();

        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
