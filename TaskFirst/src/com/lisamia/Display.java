package com.lisamia;

import javax.swing.*;


public class Display extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Display::run);
    }

    private static void run() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.setTitle("-Wow, what it is?  -Nonsense =)");
        f.getContentPane().add(new PaintI());
        f.pack();

        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
