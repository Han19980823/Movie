package week1.dianshangjinjie.bw.com.demo5.contract;

import week1.dianshangjinjie.bw.com.demo5.bean.CarBean;
import week1.dianshangjinjie.bw.com.demo5.bean.ClzBean;
import week1.dianshangjinjie.bw.com.demo5.bean.ShopBean;

/**
 * 作者：Han98
 * 创建时间：2019/11/25
 * 描述：TODO
 * 最近修改：2019/11/25 10:59 modify by liujc
 */
public interface Icontract {
    interface Imode{
        void success(ClzBean clzBean);
    }


    interface IClzFragm{
        void success(ClzBean clzBean);
        void success(ShopBean shopBean);
    }

    interface IClzShop{
        void success(ShopBean shopBean);
    }

    interface ICar{
        void success(CarBean carBean);
    }
    interface ICarFagmen{
        void success(CarBean carBean);
    }
}
