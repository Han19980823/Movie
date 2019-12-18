package week1.dianshangjinjie.bw.com.movie.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.OnClick;
import week1.dianshangjinjie.bw.com.movie.BannerBean;
import week1.dianshangjinjie.bw.com.movie.R;
import week1.dianshangjinjie.bw.com.movie.base.BaseActivity;
import week1.dianshangjinjie.bw.com.movie.base.BasePresentert;
import week1.dianshangjinjie.bw.com.movie.contract.Icontract;
import week1.dianshangjinjie.bw.com.movie.presenter.Presenter;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends BaseActivity implements Icontract.Iview {
    @BindView(R.id.text_name)
    TextView textView;
    private String title;
    @BindView(R.id.btn_close)
    Button btn_close;
   @BindView(R.id.prod)
    ProgressBar prod;
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
        Presenter presenter = new Presenter();
        presenter.getModel();
        return presenter;
    }

    @Override
    public void success(BannerBean bannerBean) {
        Toast.makeText(this, bannerBean.getMessage(), Toast.LENGTH_SHORT).show();
        List<BannerBean.ResultBean> result = bannerBean.getResult();
        for (BannerBean.ResultBean resultBean : result) {
            title = resultBean.getTitle();
            textView.setText(title);
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @OnClick(R.id.btn_close)
    public void btn(View view){
        prod.setMax(100);
        prod.setMin(0);
        prod.setProgress(150);
        prod.drawableHotspotChanged(20,25);
    }
}
