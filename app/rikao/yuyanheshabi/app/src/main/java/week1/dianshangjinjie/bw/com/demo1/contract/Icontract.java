package week1.dianshangjinjie.bw.com.demo1.contract;

import week1.dianshangjinjie.bw.com.demo1.CarBean;

/**
 * 作者：Han98
 * 创建时间：2019/11/21
 * 描述：TODO
 * 最近修改：2019/11/21 19:04 modify by liujc
 */
public interface Icontract {
    interface Imodel{
        void getNet(CarBean carBean);
    }
    interface Iview{
        void success(CarBean carBean);
    }

}
