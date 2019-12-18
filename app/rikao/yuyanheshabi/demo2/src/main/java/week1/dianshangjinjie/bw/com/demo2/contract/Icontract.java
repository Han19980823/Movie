package week1.dianshangjinjie.bw.com.demo2.contract;

import android.os.IInterface;

import week1.dianshangjinjie.bw.com.demo2.bean.Shop;

/**
 * 作者：Han98
 * 创建时间：2019/11/22
 * 描述：TODO
 * 最近修改：2019/11/22 11:49 modify by liujc
 */
public interface Icontract {
    interface Imodel{
        void getIshop(Shop shop);
    }

    interface Iview{
        void successs(Shop shop);
    }
}
