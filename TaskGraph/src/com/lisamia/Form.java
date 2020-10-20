package com.lisamia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Form {
    private JPanel contentPane;
    private JPanel drawPanel;
    private JPanel panelSol;
    private JButton buttonSolution;
    private JTextField textFunc;
    private draw draw;

    public Form() {
        drawPanel.setBounds(new Rectangle(JFrame.MAXIMIZED_HORIZ, JFrame.MAXIMIZED_VERT - panelSol.getHeight()));
        drawPanel.setLayout(new BorderLayout());
        draw = new draw();
        draw.setBounds(new Rectangle(JFrame.MAXIMIZED_HORIZ, JFrame.MAXIMIZED_VERT - panelSol.getHeight()));
        drawPanel.add(draw);

        buttonSolution.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Point> list = makeFunc();
                draw.paintFunc(draw.getGraphics(), list);
            }
        });
    }

    private class draw extends JPanel{
        public void paintComponent(Graphics gr) {
            Graphics2D g2 = (Graphics2D)gr;
            paintXY(gr);
        }

        public void paintXY(Graphics gr){
            Graphics2D g = (Graphics2D)gr;
            g.setColor(Color.WHITE);
            g.fillRect(0,0, getWidth(), getHeight());
            int step = 0;
            int max = Math.max(getWidth(), getHeight());
            for(int i = 0; i < max; i+=10){
                g.setColor(Color.GRAY);
                g.drawLine(step, 0, step,getHeight());
                g.drawLine(0, step, getWidth(), step);
                g.setColor(Color.black);
                step+= 10;
            }
            g.setStroke(new BasicStroke(2.f));
            g.setColor(Color.BLACK);
            g.drawLine(getWidth()/2,0, getWidth()/2, getHeight());
            g.drawLine(0,getHeight()/2, getWidth(), getHeight()/2);
            g.drawLine(getWidth()/2, 0, getWidth()/2 - 10,15);
            g.drawLine(getWidth()/2, 0, getWidth()/2 + 10,15);
            g.drawLine(getWidth(), getHeight()/2, getWidth()-15,getHeight()/2 - 10);
            g.drawLine(getWidth(), getHeight()/2, getWidth()-15,getHeight()/2 + 10);
        }

        public void paintFunc(Graphics g, ArrayList<Point> list){
            paintXY(g);
            for(int i = 0; i < list.size()-1; i++){
                WuLine.drawLine(g, list.get(i).x, list.get(i).y, list.get(i+1).x, list.get(i+1).y);
            }
        }
    }

    private ArrayList<Point> makeFunc() {
        ArrayList<Point> points = new ArrayList<>();
        String string = textFunc.getText();

        for (int i = 50; i >= -50; i--) {
            Expression ex = new ExpressionBuilder(string).variable("x").build().setVariable("x", i);
            Point point =new Point(draw.getWidth()/2 + i,  draw.getHeight()/2 - (int)ex.evaluate());
            points.add(point);
           //System.out.print(i + " " + (int)ex.evaluate() + "|");
            //System.out.print(point.x + "  " + point.y + "|");
        }
        return points;
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
