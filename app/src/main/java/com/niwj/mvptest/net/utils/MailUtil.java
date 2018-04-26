package com.niwj.mvptest.net.utils;


import com.niwj.mvptest.model.MailModel;
import com.niwj.mvptest.net.BaseAPIUtils;
import com.niwj.mvptest.net.BasePojo;
import com.niwj.mvptest.net.interfaces.MailInterface;

import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by prince70 on 2018/4/23.
 */

public class MailUtil {
    public static Call<MailModel> getMails(String uid) {
        Retrofit retrofit = BaseAPIUtils.getRetrofit();
        MailInterface mailInterface = retrofit.create(MailInterface.class);
        Call<MailModel> call = mailInterface.getMail(BaseAPIUtils.ts, BaseAPIUtils.SIGN, BaseAPIUtils.appID, uid);
        return call;
    }
}
