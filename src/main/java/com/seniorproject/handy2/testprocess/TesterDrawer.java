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

    private IplImage image;
    private TesterPanel panel = TesterPanel.getTester();
    private static TesterDrawer t;

    public TesterDrawer(IplImage img) throws HeadlessException {
        this.setTitle("Test Output");
        this.image = img;
        this.setVisible(true);
        this.setDefaultCloseOperation(TesterDrawer.EXIT_ON_CLOSE);
        this.setSize(640, 480);
        panel.setImage(this.image);
        this.add(panel);

    }

    public static TesterDrawer getTester(IplImage image) {
        if (t == null) {
            t = new TesterDrawer(image);
        }
        return t;
    }

    public void setImage(IplImage img) {
        this.image = img;
    }

    public void draw() {
        panel.repaint();
    }

}
