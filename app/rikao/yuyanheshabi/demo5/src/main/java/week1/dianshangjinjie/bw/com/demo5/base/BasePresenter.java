package week1.dianshangjinjie.bw.com.demo5.base;

/**
 * 作者：Han98
 * 创建时间：2019/11/25
 * 描述：TODO
 * 最近修改：2019/11/25 10:41 modify by liujc
 */
public class BasePresenter<V extends BaseFragment>  {
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
