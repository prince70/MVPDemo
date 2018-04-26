package com.niwj.mvptest.contract;

import com.niwj.mvptest.model.MailModel;
import com.niwj.mvptest.presenter.BasePresenter;

/**
 * 建议共同的契约类  方法的作用一致
 * Created by prince70 on 2018/4/25.
 */

public interface MailInfoContract {

    interface View extends BaseView<Presenter> {
        void showLoading();//展示加载框

        void dismissLoading();//隐藏加载框

        void showMailInfo(MailModel.ContentBean bean);//将网络请求得到的邮件信息回调

        String uid();//网络请求需要传参  udi
    }

    interface Presenter extends BasePresenter {
        void loadMailInfo();//加载网络请求得到的邮件信息回调
    }
}
