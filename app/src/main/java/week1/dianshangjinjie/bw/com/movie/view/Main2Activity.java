package week1.dianshangjinjie.bw.com.movie.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import week1.dianshangjinjie.bw.com.movie.R;
import week1.dianshangjinjie.bw.com.movie.base.BaseActivity;
import week1.dianshangjinjie.bw.com.movie.base.BasePresentert;
import week1.dianshangjinjie.bw.com.movie.bean.LoginBean;
import week1.dianshangjinjie.bw.com.movie.contract.Icontract;
import week1.dianshangjinjie.bw.com.movie.presenter.Presenter;

public class Main2Activity extends BaseActivity implements Icontract.Iogin {


    @BindView(R.id.ed_name)
    EditText edName;
    @BindView(R.id.ed_pwd)
    EditText edPwd;
    private Presenter presenter;
    @BindView(R.id.btn_xian)
    LinearLayout linearLayout;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main2;
    }
    @OnClick(R.id.login)
    public void onLogin(View view){
        linearLayout.setVisibility(View.VISIBLE);
        String name = edName.getText().toString();
        String pwd = edPwd.getText().toString();
        presenter.getLogin(name,pwd);

    }

    @Override
    protected BasePresentert Ipresenter() {
        presenter = new Presenter();
        return presenter;
    }

    @Override
    public void success(LoginBean loginBean) {
        Toast.makeText(this, loginBean.getMessage(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
        startActivity(intent);
    }


}
