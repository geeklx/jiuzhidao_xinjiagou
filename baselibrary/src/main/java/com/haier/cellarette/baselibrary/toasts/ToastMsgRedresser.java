/**
 * Copyright 2017,Smart Haier.All rights reserved
 */
package com.haier.cellarette.baselibrary.toasts;

import com.haier.cellarette.baselibrary.common.BaseStringUtil;

public class ToastMsgRedresser {

    private static final String NET_ERROR = "网络异常，请检查网络连接！";
    public static final String MSG_ERROR_OKHTTP = "msg_error_http:okhttp";

    public static String redress(String msg) {
        if (BaseStringUtil.isEmpty(msg)) {
            return null;
        }

        String lowerMsg = msg.toLowerCase();
        if (lowerMsg.contains(MSG_ERROR_OKHTTP)) {
            return NET_ERROR;
        }

        if (lowerMsg.equals("canceled")) {
            return null;
        }

        if (lowerMsg.contains("okhttp")) {
            return NET_ERROR;
        }

        if (lowerMsg.contains("java")) {
            return null;
        }

//        if (lowerMsg.contains("token")) { return null;}
        if (lowerMsg.contains("null")) {
            return null;
        }

        if (lowerMsg.contains("hostname") || (lowerMsg.contains("failed")
                && lowerMsg.contains("connect"))
                || lowerMsg.contains("timeout")) {
            return NET_ERROR;
        }
        // more ...

        return msg;
    }
}
