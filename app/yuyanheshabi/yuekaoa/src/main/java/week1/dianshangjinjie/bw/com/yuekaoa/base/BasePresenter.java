package week1.dianshangjinjie.bw.com.yuekaoa.base;

/**
 * 作者：Han98
 * 创建时间：2019/11/26
 * 描述：TODO
 * 最近修改：2019/11/26 08:36 modify by liujc
 */
public class BasePresenter <V extends BaseActivity> {
    public V v;
    public void attach(V v){
        this.v = v;
    }
    public void unAttach(){
        if (v!=null){
            v=null;

        }    }
}
