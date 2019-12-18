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
import week1.dianshangjinjie.bw.com.movie.bean.RegistBean;
import week1.dianshangjinjie.bw.com.movie.contract.Icontract;
import week1.dianshangjinjie.bw.com.movie.presenter.Presenter;

public class MainActivity extends BaseActivity implements Icontract.Iview {
    @BindView(R.id.ed_name)
    EditText edName;
    @BindView(R.id.ed_pwd)
    EditText edPwd;
    @BindView(R.id.btn_xian1)
    LinearLayout linearLayout;
    private Presenter presenter;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresentert Ipresenter() {
        presenter = new Presenter();

        return presenter;
    }

    @OnClick(R.id.regist)
    public void onClcik(View view){
        linearLayout.setVisibility(View.VISIBLE);
        String name = edName.getText().toString();
        String pwd = edPwd.getText().toString();
        presenter.getModel(name,pwd);

    }

    @Override
    public void success(RegistBean RegistBean) {
        Toast.makeText(this, RegistBean.getMessage(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
        finish();
    }


}
