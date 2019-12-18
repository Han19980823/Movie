package week1.dianshangjinjie.bw.com.demo3.contract;

import week1.dianshangjinjie.bw.com.demo3.bean.CarBean;

import week1.dianshangjinjie.bw.com.demo3.bean.ShopBean;

/**
 * 作者：Han98
 * 创建时间：2019/11/22
 * 描述：TODO
 * 最近修改：2019/11/22 15:27 modify by liujc
 */
public interface Icontract {
    //购物车
    interface ICar{
        void success(CarBean carBean);
    }
    //carfragment
    interface  ICarFragment{
        void success(CarBean carBean);
    }
    //fenlei
    interface IClz{
        void success(ShopBean shopBean);
    }

    //carfragment
    interface  IClzFragment{
        void success(ShopBean shopBean);
    }
}
