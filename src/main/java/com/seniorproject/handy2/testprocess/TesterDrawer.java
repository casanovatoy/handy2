/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorproject.handy2.testprocess;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import org.bytedeco.javacpp.opencv_core.IplImage;

/**
 *
 * @author RainWhileLoop
 */
public class TesterDrawer extends JFrame {

    private TesterPanel panel = TesterPanel.getTester();
    private static TesterDrawer t;

    public TesterDrawer() throws HeadlessException {
        this.setTitle("Test Output");
        this.setVisible(true);
        this.setDefaultCloseOperation(TesterDrawer.EXIT_ON_CLOSE);
        this.setSize(640, 480);
        this.add(panel);

    }

    public static TesterDrawer getTester() {
        if (t == null) {
            t = new TesterDrawer();
        }
        return t;
    }

    public void testImage(IplImage img) {
        panel.setImage(img);
        panel.repaint();
    }

}
