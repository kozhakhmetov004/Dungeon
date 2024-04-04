package com.company;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private GraphicsDevice vc;

    public MainFrame(){
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        vc= e.getDefaultScreenDevice();
        setTitle("Dungeon");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1474, 800);
        setLocation(500,200);
        add(new GameField());
        setVisible(true);
        setFullScreen(this);

    }

    public void setFullScreen(JFrame f){


        vc.setFullScreenWindow(f);


    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
    }

}
