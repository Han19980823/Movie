package week1.dianshangjinjie.bw.com.movie.view;

import android.app.Application;
import android.content.Context;

/**
 * 作者：Han98
 * 创建时间：2019/12/2
 * 描述：TODO
 * 最近修改：2019/12/2 09:00 modify by liujc
 */
public class App extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context =this;
    }
}
