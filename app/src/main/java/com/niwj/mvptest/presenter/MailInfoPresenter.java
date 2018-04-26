package com.niwj.mvptest.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.niwj.mvptest.contract.MailInfoContract;
import com.niwj.mvptest.model.MailModel;
import com.niwj.mvptest.net.BasePojo;
import com.niwj.mvptest.net.utils.MailUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 主要负责请求处理mail的presenter类
 * Created by prince70 on 2018/4/25.
 */

public class MailInfoPresenter implements MailInfoContract.Presenter {

    private static final String TAG = "MailInfoPresenter";
    private MailInfoContract.View view;

    public MailInfoPresenter(MailInfoContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        loadMailInfo();
    }

    /**
     * 从网络上获取数据
     */
    @Override
    public void loadMailInfo() {
        String uid = view.uid();
        view.showLoading();//接口请求前显示loading

        Call<MailModel> call = MailUtil.getMails(uid);
        call.enqueue(new Callback<MailModel>() {
            @Override
            public void onResponse(@NonNull Call<MailModel> call, @NonNull Response<MailModel> response) {
                Log.e(TAG, "onResponse: " + call.request().toString());
                MailModel body = response.body();
                if (body != null) {
                    MailModel.ContentBean content = body.getContent();
                    view.showMailInfo(content);
                }
                view.dismissLoading();
            }

            @Override
            public void onFailure(@NonNull Call<MailModel> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: " + call.request().toString());
                view.dismissLoading();
            }
        });
//        call.enqueue(new Callback<MailModel>() {
//            @Override
//            public void onResponse(@NonNull Call<MailModel> call, @NonNull Response<MailModel> response) {
//                Log.e(TAG, "onResponse: " + call.request().toString());
//                MailModel body = response.body();
//                Log.e(TAG, "onResponse: body" + body);
//                if (body != null) {
//                    MailModel content = body.getContent();
//                    Log.e(TAG, "onResponse: " + content);
//                    if (content != null) {
//                        MailModel.ContentBean bean = content.getContent();
//                        Log.e(TAG, "onResponse:bean " + bean);
//                        view.showMailInfo(bean);
//                    }
//                }
//
//                view.dismissLoading();
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<BasePojo<MailModel>> call, @NonNull Throwable t) {
//                Log.e(TAG, "onFailure: " + call.request().toString());
//                view.dismissLoading();
//            }
//        });
    }
}
