package com.haier.cellarette.biz_demo1.view;


import com.haier.cellarette.biz_demo1.bean.Huoquhaoyou;
import com.haier.cellarette.libmvp.mvp.IView;

import java.util.List;

public interface IHaoyouView extends IView {
    void onHaoyouError(String msg);
    void onHaoyouSuccess(List<Huoquhaoyou> results);
}
