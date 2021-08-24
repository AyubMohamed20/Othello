/**
 * File name: OthelloSplashScreen
 * Author: Ayub Mohamed, 040899407
 * Date: October 16th, 2020
 * Purpose: to create the splash screen
 * Class list: OthelloSplashScreen
 */

import javax.swing.*;
import java.awt.*;

public class OthelloSplashScreen extends JWindow {

    /**
     * serial Version UID
     */
    private static final long serialVersionUID = 6248477390124803341L;
    /**
     * int for duration of splash screen
     */
    private final int duration;

    /**
     * Sets the duration
     */
    public OthelloSplashScreen(int duration) {
        this.duration = duration;
    }

    /**
     * Create the Splash Screen
     */
    public void showSplashWindow() {

        // Crates content panel for splash screen
        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(Color.WHITE);
        setBounds(0, 0, 1920, 1080);

        // Label for background image
        JLabel label = new JLabel(new ImageIcon(getClass().getResource("/resources/othello-switch-hero.jpg")));

        // Label for text below
        JLabel demo = new JLabel("Ayub Mohamed - Othello Game", JLabel.CENTER);
        demo.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 18));
        content.add(label, BorderLayout.CENTER);
        content.add(demo, BorderLayout.SOUTH);

        //Adds content
        setContentPane(content);
        setVisible(true);

        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            dispose();
        }
    }
}