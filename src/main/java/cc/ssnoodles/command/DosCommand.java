package cc.ssnoodles.command;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteWatchdog;

import java.io.File;
import java.io.IOException;

/**
 * Filename: DosCommand
 * Description: dos命令
 * Copyright: Copyright (c)2016
 *
 * @author: ssnoodles
 * @version: 1.0 Create at: 2017-01-06 0:58
 * <p/>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------------
 * 2017-01-06 ssnoodles 1.0 1.0 Version
 */
public class DosCommand {

    /**
     * IE-最大化打开
     */
    public static void openIeMax() {
        if (WinCommand.findWinIe() == null) start("/max iexplore");
    }
    /**
     * IE-最大化打开-打开指定网站
     */
    public static void openIeMax(String www) {
        if (WinCommand.findWinIe() == null) start("/max iexplore " + www);
    }
    /**
     * IE-最大化打开-可重复
     */
    public static void openIeMaxS() {
        start("/max iexplore");
    }
    /**
     * IE-最小化打开
     */
    public static void openIeMin() {
        if (WinCommand.findWinIe() == null) start("/min iexplore");
    }
    /**
     * IE-最小化打开-可重复
     */
    public static void openIeMinS() {
        start("/min iexplore");
    }

    /**
     * 打开命令
     */
    public static void start(String str) {
        dos("cmd /c start " + str);
    }

    /**
     *  杀死进程
     */
    public static void kill(String exe) {
        dos("taskkill /f /im " + exe + " /t");
    }
    /**
     *  执行dos命令
     */
    public static void dos(String str) {
        try {
            // 错误结果有可能会阻塞
//            Runtime.getRuntime().exec(str);
            CommandLine cmdLine = CommandLine.parse(str);
            DefaultExecutor executor = new DefaultExecutor();
            executor.setExitValue(1);
            ExecuteWatchdog watchdog = new ExecuteWatchdog(1000);
            executor.setWatchdog(watchdog);
            DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
            executor.execute(cmdLine, resultHandler);
            try {
                resultHandler.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 开启当前目录下的ppt
     */
    public static void startPPT() {
        //当前路径
        String userDir = System.getProperty("user.dir");
        File f = new File(userDir);
        if (!f.exists()) {
            System.out.println(userDir + " not exists");
            return;
        }
        File files[] = f.listFiles();
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (!file.isDirectory()) {
                String name = file.getName();
                if (name.contains(".pptx") || name.contains(".ppt") || name.contains(".pps")) {
                    start(userDir + "/" + name);
                    return;
                }
            }
        }
    }
}
