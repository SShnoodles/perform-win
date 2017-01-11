package cc.ssnoodles.util;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.User32;

import static com.sun.jna.win32.W32APIOptions.DEFAULT_OPTIONS;

/**
 * Filename: Win32API
 * Description: java win32操作工具，提取了User32主要功能
 * Copyright: Copyright (c)2016
 *
 * @author: ssnoodles
 * @version: 1.0 Create at: 2017-01-05 19:03
 * <p/>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------------
 * 2017-01-05 ssnoodles 1.0 1.0 Version
 */
public interface Win32API extends User32 {

    Win32API INSTANCE = (Win32API) Native.loadLibrary("user32", Win32API.class, DEFAULT_OPTIONS);

    /**
     * 最大化窗口
     */
    int SW_MAXIMIZE = User32.SW_MAXIMIZE;
    /**
     * 最小化窗口
     */
    int SW_MINIMIZE = User32.SW_MINIMIZE;
    /**
     * 恢复窗口
     */
    int SW_RESTORE = User32.SW_RESTORE;
    /**
     * 隐藏窗口
     */
    int SW_HIDE = User32.SW_HIDE;
    /**
     * 关闭窗口
     */
    int WM_CLOSE = User32.WM_CLOSE;

    /**
     * 设置窗口句柄的显示状态
     */
    @Override
    boolean ShowWindow(HWND wnd, int nCmdShow);

    /**
     * 设置销毁窗口 ， close 不好使
     * http://blog.csdn.net/yuanhubilie/article/details/8555266
     */
    @Override
    void PostMessage(HWND var1, int var2, WPARAM var3, LPARAM var4);
}