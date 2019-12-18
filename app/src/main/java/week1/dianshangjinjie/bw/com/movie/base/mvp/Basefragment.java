package week1.dianshangjinjie.bw.com.movie.base.mvp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 作者：Han98
 * 创建时间：2019/12/6
 * 描述：TODO
 * 最近修改：2019/12/6 08:52 modify by liujc
 */
public abstract class Basefragment<P extends BaseFPresenter> extends Fragment {

    public P p;
    private View view;
    private boolean flag;
    private boolean glag;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p =  Ipresenter();
        if (p!=null){
            p.attach(this);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(layout(),container,false);
        return view;
    }

    protected abstract P Ipresenter();

    protected abstract int layout();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

    }

    protected abstract void initView(View view);

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
;
    }



    protected abstract void initData();
}
