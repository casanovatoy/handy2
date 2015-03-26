/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorproject.handy2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.bytedeco.javacpp.opencv_core.IplImage;

/**
 *
 * @author RainWhileLoop
 */
public class TesterPanel extends JPanel {

    private IplImage image;
    private static TesterPanel t;

    public static TesterPanel getTester() {
        if (t == null) {
            t = new TesterPanel();
        }
        return t;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        BufferedImage img = this.image.getBufferedImage();
        if (img != null) {
            g2.drawImage(img, 0, 0, 640, 480, null);
            g2.dispose();
        } else {
            try {
                img = ImageIO.read(new File("src/main/resources/images/colorbar.jpg"));
                g2.drawImage(img, 0, 0, 640, 480, this);
                g2.dispose();
            } catch (IOException ex) {
                Logger.getLogger(TesterDrawer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setImage(IplImage image) {
        this.image = image;
    }

}
