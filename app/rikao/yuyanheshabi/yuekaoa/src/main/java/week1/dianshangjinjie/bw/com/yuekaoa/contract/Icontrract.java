package week1.dianshangjinjie.bw.com.yuekaoa.contract;

import week1.dianshangjinjie.bw.com.yuekaoa.bean.CarBean;

/**
 * 作者：Han98
 * 创建时间：2019/11/26
 * 描述：TODO
 * 最近修改：2019/11/26 09:04 modify by liujc
 */
public interface Icontrract {
    interface Imdel{
        void success(CarBean carBean);
    }
    interface Iview{
        void success(CarBean carBean);
    }
}
