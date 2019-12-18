package week1.dianshangjinjie.bw.com.yuekaob.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 作者：Han98
 * 创建时间：2019/11/26
 * 描述：TODO
 * 最近修改：2019/11/26 08:36 modify by liujc
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    public P p;
    public Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        unbinder = ButterKnife.bind(this);
        p = Ipresenter();
        if (p != null) {
            p.attach(this);
        }
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int initLayout();

    protected abstract P Ipresenter();
}
