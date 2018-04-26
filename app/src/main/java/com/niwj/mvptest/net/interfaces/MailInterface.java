package com.niwj.mvptest.net.interfaces;


import com.niwj.mvptest.model.MailModel;
import com.niwj.mvptest.net.BasePojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by prince70 on 2018/4/23.
 */

public interface MailInterface {
    @GET("v1/newmail/mail/getmailByrecipient")
    Call<MailModel> getMail(@Query("ts") String ts, @Query("sign") String sign, @Query("appID") String appID, @Query("uid") String uid);

}
