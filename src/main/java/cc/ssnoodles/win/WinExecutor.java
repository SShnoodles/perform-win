package cc.ssnoodles.win;

import cc.ssnoodles.command.WinCommand;
import cc.ssnoodles.command.DosCommand;
import cc.ssnoodles.command.KeyboardCommand;
import cc.ssnoodles.util.ProUtil;

/**
 * Filename: WinExecutor
 * Description: 命令执行者
 * Copyright: Copyright (c)2016
 *
 * @author: ssnoodles
 * @version: 1.0 Create at: 2017-01-06 13:25
 * <p/>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------------
 * 2017-01-06 ssnoodles 1.0 1.0 Version
 */
public class WinExecutor {

    private static final String WIN_APP_URL = "win_app_url";
    private static final String WIN_APP_TITLE = "win_app_title";
    private static final String COMMAND_TYPE ="command_type";
    private static final String WIN_APP_EXE_NAME ="win_app_exe_name";
    private static final String WIN_OPEN_IE_WWW ="win_open_ie_www";

    public static void exec() {
        switch (ProUtil.getValue(COMMAND_TYPE)) {
            case "open_ie_max":
                DosCommand.openIeMax();
                break;
            case "open_ie_max_www":
                DosCommand.openIeMax(ProUtil.getValue(WIN_OPEN_IE_WWW));
                break;
            case "open_ie_min":
                DosCommand.openIeMin();
                break;
            case "show_ie_min":
                WinCommand.winIeMin();
                break;
            case "show_ie_max":
                WinCommand.winIeMax();
                break;
            case "close_ie":
                WinCommand.winIeClose();
                break;
            case "open_app":
                DosCommand.start(ProUtil.getValue(WIN_APP_URL));
                break;
            case "close_app":
                DosCommand.kill(ProUtil.getValue(WIN_APP_EXE_NAME));
                break;
            case "close_app_one":
                WinCommand.kill(ProUtil.getValue(WIN_APP_TITLE));
                break;
            case "keyboard_f5":
                KeyboardCommand.keyboardF5();
                break;
            case "keyboard_down":
                KeyboardCommand.keyboardDown();
                break;
            case "keyboard_up":
                KeyboardCommand.keyboardUp();
                break;
            case "keyboard_esc":
                KeyboardCommand.keyboardEsc();
                break;
            case "keyboard_space":
                KeyboardCommand.keyboardSpace();
                break;
            case "keyboard_alt_f4":
                KeyboardCommand.keyboardAltAndF4();
                break;
            case "open_ppt":
                DosCommand.startPPT();
                break;
            default:
                break;
        }
    }
}
