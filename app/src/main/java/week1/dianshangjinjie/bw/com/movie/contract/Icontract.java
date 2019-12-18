package week1.dianshangjinjie.bw.com.movie.contract;

import week1.dianshangjinjie.bw.com.movie.bean.BannerBean;
import week1.dianshangjinjie.bw.com.movie.bean.CardBean;
import week1.dianshangjinjie.bw.com.movie.bean.HomeBean;
import week1.dianshangjinjie.bw.com.movie.bean.LoginBean;
import week1.dianshangjinjie.bw.com.movie.bean.RegistBean;

/**
 * 作者：Han98
 * 创建时间：2019/12/2
 * 描述：TODO
 * 最近修改：2019/12/2 09:07 modify by liujc
 */
public interface Icontract {
    interface Imodel{
        void success(RegistBean registBean);
    }
    interface Iview{
        void success(RegistBean registBean);
    }

    interface Ilogin{
        void success(LoginBean loginBean);
    }
    interface Iogin{
        void success(LoginBean loginBean);
    }

    interface Ibanner{
        void   success(BannerBean bannerBean);
    }
    interface IHomes{
        void success(CardBean cardBean);
    }
    interface  IHome{
        void success(HomeBean homeBean);
    }
    interface ICas{
        void success(CardBean cardBean);
    }
}
