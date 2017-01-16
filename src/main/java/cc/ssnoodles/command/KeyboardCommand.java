package cc.ssnoodles.command;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Filename: KeyboardCommand
 * Description: 键盘操作
 * Copyright: Copyright (c)2016
 *
 * @author: ssnoodles
 * @version: 1.0 Create at: 2017-01-06 0:56
 * <p/>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------------
 * 2017-01-06 ssnoodles 1.0 1.0 Version
 */
public class KeyboardCommand {
    /**
     * 键盘-下
     */
    public static void keyboardDown() {
        keyboard(KeyEvent.VK_DOWN);
    }

    /**
     * 键盘-上
     */
    public static void keyboardUp() {
        keyboard(KeyEvent.VK_UP);
    }

    /**
     * 键盘-F5
     */
    public static void keyboardF5() {
        keyboard(KeyEvent.VK_F5);
    }

    /**
     * 键盘-ESC
     */
    public static void keyboardEsc() {
        keyboard(KeyEvent.VK_ESCAPE);
    }
    /**
     * 键盘-空格
     */
    public static void keyboardSpace() {
        keyboard(KeyEvent.VK_SPACE);
    }

    /**
     * 键盘-alt+f4
     */
    public static void keyboardAltAndF4() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_F4);
    }
    /**
     * 键盘
     */
    public static void keyboard(int keyEvent) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.keyPress(keyEvent);
        robot.keyRelease(keyEvent);
    }
}
