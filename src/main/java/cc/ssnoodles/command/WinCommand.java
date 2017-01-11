package cc.ssnoodles.command;

import cc.ssnoodles.util.Win32API;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

/**
 * Filename: WinCommand
 * Description: 系统操作
 * Copyright: Copyright (c)2016
 *
 * @author: ssnoodles
 * @version: 1.0 Create at: 2017-01-06 0:57
 * <p/>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------------
 * 2017-01-06 ssnoodles 1.0 1.0 Version
 */
public class WinCommand {

    /**
     * 操作ie
     */
    public static void winIe(int sw) {
        if ( findWinIe() != null) {
            Win32API.INSTANCE.ShowWindow(findWinIe(), sw);
        }
    }
    /**
     * IE句柄
     */
    public static WinDef.HWND findWinIe() {
        return User32.INSTANCE.FindWindow("IEFrame", null);
    }

    /**
     * 获取句柄
     */
    public static WinDef.HWND findWinHWND(String winName) {
        return User32.INSTANCE.FindWindow(null, winName);
    }

    /**
     * 操作ie -- 最小化
     */
    public static void winIeMin() {
        winIe(Win32API.SW_MINIMIZE);
    }

    /**
     * 操作ie -- 最大化
     */
    public static void winIeMax() {
        winIe(Win32API.SW_MAXIMIZE);
    }

    /**
     * 操作ie -- 隐藏
     */
    public static void winIeHide() {
        winIe(Win32API.SW_HIDE);
    }

    /**
     * 操作ie -- 关闭
     */
    public static void winIeClose() {
        if ( findWinIe() != null) {
            Win32API.INSTANCE.PostMessage(findWinIe(), Win32API.WM_CLOSE, new WinDef.WPARAM(), new WinDef.LPARAM());
        }
    }
    /**
     * 操作 -- 关闭某个窗口
     */
    public static void kill(String title) {
        if (findWinHWND(title) != null){
            Win32API.INSTANCE.PostMessage(findWinHWND(title), Win32API.WM_CLOSE, new WinDef.WPARAM(), new WinDef.LPARAM());
        }
    }
}
