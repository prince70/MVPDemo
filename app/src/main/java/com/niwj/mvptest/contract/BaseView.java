package com.niwj.mvptest.contract;

/**
 * 泛类基View 作用是绑定view跟presenter
 * Created by prince70 on 2018/4/25.
 */

public interface BaseView<T> {
    void setPresenter(T presenter);//在具体的presenter中绑定
}
