package week1.dianshangjinjie.bw.com.demo3.base.mvp;

/**
 * 作者：Han98
 * 创建时间：2019/11/22
 * 描述：TODO
 * 最近修改：2019/11/22 15:05 modify by liujc
 */
public class BasePresenter  <V extends BaseFragment> {
    public V v;
    public void attach(V v){
        if (v!=null){
            this.v = v;
        }
    }
    public void unAttach(){
        if (v!=null){
            v=null;
        }
    }

}
