package week1.dianshangjinjie.bw.com.movie.contract;

import week1.dianshangjinjie.bw.com.movie.BannerBean;

/**
 * 作者：Han98
 * 创建时间：2019/12/2
 * 描述：TODO
 * 最近修改：2019/12/2 09:07 modify by liujc
 */
public interface Icontract {
    interface Imodel{
        void success(BannerBean bannerBean);
    }
    interface Iview{
        void success(BannerBean bannerBean);
    }
}
