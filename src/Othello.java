/**
 * File name: Othello
 * Author: Ayub Mohamed, 040899407
 * Date: October 16th, 2020
 * Purpose: to Launch a graphical user interface of the game othello
 * Class list: Othello
 */

import java.awt.*;

/**
 * Launch Othello application GUI.
 *
 * @author AyubMohamed
 * @version 1
 * @see None
 */
public class Othello {
    /**
     * Launch the othello application.
     * @param args
     */
    public static void main(String[] args) {
        // Sets duration of splash screen
        int duration = 5000;
        // Creates SplashScreen
        OthelloSplashScreen splashWindow = new OthelloSplashScreen(duration);
        splashWindow.showSplashWindow();
        splashWindow.setVisible(false);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // run application
                    OthelloViewController window = new OthelloViewController();
                    // Makes splashScreen not Visible after app opens
                    splashWindow.setVisible(false);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
