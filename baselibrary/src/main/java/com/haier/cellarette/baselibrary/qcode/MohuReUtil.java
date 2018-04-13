package com.haier.cellarette.baselibrary.qcode;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

import com.haier.cellarette.baselibrary.common.BaseBitmapUtils;


/**
 * Created by shining on 2017/12/6.
 */

public class MohuReUtil {

    /**
     * 设置背景模糊bufen
     *
     * @param activity 在哪一个Activity上面
     * @param view     哪一个view模糊
     */
    public static void set_muhu_re(Activity activity, View view) {
        Bitmap shot = BaseBitmapUtils.takeScreenShot(activity.getWindow().getDecorView());
        Bitmap blur = BaseBitmapUtils.blur(activity, shot);
        view.setBackground(new BitmapDrawable(activity.getResources(), blur));
//        view.setBackgroundDrawable(new BitmapDrawable(activity.getResources(), blur));
    }
}
