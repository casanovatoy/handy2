/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorproject.handy2;

import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import org.bytedeco.javacpp.opencv_core.IplImage;

/**
 *
 * @author RainWhileLoop
 */
public class TesterDrawer extends JFrame {

    private IplImage image;

    private static TesterDrawer t;

    private TesterDrawer(IplImage image) throws HeadlessException {
        this.setTitle("Test Output");
        this.image = image;
        this.setVisible(true);
        this.setDefaultCloseOperation(TesterDrawer.EXIT_ON_CLOSE);
    }

    public static TesterDrawer getTester(IplImage image) {
        if (t == null) {
            t = new TesterDrawer(image);
        }
        return t;
    }

    @Override
    public void paintComponents(Graphics g) {
        BufferedImage img = null;
        image.copyTo(img);
        g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), null);
    }

    public void setImage(IplImage image) {
        this.image = image;
    }

}
