package com.niwj.mvptest.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.niwj.mvptest.adapter.StringNullDefaultAdapter;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**网络请求基类
 * Created by prince70 on 2018/4/20.
 */

public class BaseAPIUtils {

    public final static String URL_ICETEST="https://openapi.colourlife.com/";
    public final static String SIGN="004a8ff3281e73d68c646ee3f1bc1921";
    public final static String ts="1524708084";
    public final static String appID="ICEXCGJ0-5F89-4E17-BC44-7A0DB101B245";

    public static Retrofit getRetrofit() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //设置超时
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);

        return new Retrofit.Builder()
                .baseUrl(URL_ICETEST)
                .addConverterFactory(GsonConverterFactory.create(buildGson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(builder.build())
                .build();
    }

    public static Gson buildGson() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(String.class, new StringNullDefaultAdapter())
                .registerTypeAdapter(char.class, new StringNullDefaultAdapter())
                .create();
        return gson;
    }

}
