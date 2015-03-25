package com.toypinta.handy2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.*;

/**
 *
 * @author casanovatoy
 */
public class Handy extends JFrame {

    private HandPanel handPanel;

    public Handy() {
        super("Hand Detector");

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        // Preload the opencv_objdetect module to work around a known bug.
        Loader.load(opencv_objdetect.class);

        handPanel = new HandPanel(); // the webcam pictures and drums appear here
        c.add(handPanel, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                handPanel.closeDown();    // stop snapping pics, and any drum playing
                System.exit(0);
            }
        });

        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String args[]) {
        new Handy();
    }

}