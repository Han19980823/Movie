package week1.dianshangjinjie.bw.com.demo4.contract;

import week1.dianshangjinjie.bw.com.demo4.bean.CarBean;
import week1.dianshangjinjie.bw.com.demo4.bean.Product;
import week1.dianshangjinjie.bw.com.demo4.bean.ShopBean;

/**
 * 作者：Han98
 * 创建时间：2019/11/23
 * 描述：TODO
 * 最近修改：2019/11/23 09:15 modify by liujc
 */
public interface Icontract {

    /**
     * m
     *
     */
    interface ImodelClz{
        void callBack(ShopBean shopBean);
    }
    interface ImodelCar{
        void callBack(CarBean carBean);
    }
    interface   IproDuct{
        void callBazk(Product product);
    }


    /**
     * v
     *
     */

    interface IClz{
        void success(ShopBean shopBean);
        void sucesse(Product product);
    }
    interface ICar{
        void success(CarBean carBean);
    }
}
