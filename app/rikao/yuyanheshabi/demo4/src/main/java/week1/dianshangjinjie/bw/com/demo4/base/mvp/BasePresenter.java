package week1.dianshangjinjie.bw.com.demo4.base.mvp;

/**
 * 作者：Han98
 * 创建时间：2019/11/23
 * 描述：TODO
 * 最近修改：2019/11/23 09:03 modify by liujc
 */
public class BasePresenter <V extends BaseFragment> {

    public V v;
    public void attach(V v){
        this.v = v;
    }
    public void unAttach(){
        if (v!=null){
            v = null;
        }
    }
}
