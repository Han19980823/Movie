package week1.dianshangjinjie.bw.com.movie.base.mvp;

/**
 * 作者：Han98
 * 创建时间：2019/12/6
 * 描述：TODO
 * 最近修改：2019/12/6 08:52 modify by liujc
 */
public class BaseFPresenter<E extends Basefragment> {
    public E e;
    public void attach(E e){
        this.e = e;
    }

}
