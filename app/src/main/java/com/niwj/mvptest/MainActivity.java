package com.niwj.mvptest;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.niwj.mvptest.contract.MailInfoContract;
import com.niwj.mvptest.model.MailModel;
import com.niwj.mvptest.presenter.MailInfoPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MailInfoContract.View {
    private static final String TAG = "MainActivity";
    private ListView lv_mail;
    private List<String> mails = new ArrayList<>();

    private MailInfoContract.Presenter presenter;

    private Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_mail = findViewById(R.id.lv_mail);

        new MailInfoPresenter(this);
        presenter.start();
    }

    @Override
    public void setPresenter(MailInfoContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showLoading() {
        mDialog = new ProgressDialog(this);
        mDialog.setTitle("正在加载");
        mDialog.show();

    }

    @Override
    public void dismissLoading() {
        mDialog.dismiss();

    }

    @Override
    public void showMailInfo(MailModel.ContentBean bean) {
        if (bean != null) {
            int total = bean.getTotal();//这个数值代表请求的数据的条数，因为这个接口有上百条数据，这里只取前十条做测试
            List<MailModel.ContentBean.DataBean> data = bean.getData();
            for (int i = 0; i < 10; i++) {
                String body = data.get(i).getBody();
                mails.add(body);
            }
            Log.e(TAG, "showMailInfo: " + mails);
        }
        lv_mail.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mails));
    }

    @Override
    public String uid() {
        return "xuanhu";//传递参数
    }
}
