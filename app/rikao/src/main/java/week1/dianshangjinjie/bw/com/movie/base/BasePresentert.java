package week1.dianshangjinjie.bw.com.movie.base;

/**
 * 作者：Han98
 * 创建时间：2019/12/2
 * 描述：TODO
 * 最近修改：2019/12/2 09:08 modify by liujc
 */
public class BasePresentert<V extends BaseActivity> {
    public V v;
    public void attach(V v){
        this.v = v;
    }
    public void unAttach(){
        if (v!=null){
            v =null;
        }
    }
}
