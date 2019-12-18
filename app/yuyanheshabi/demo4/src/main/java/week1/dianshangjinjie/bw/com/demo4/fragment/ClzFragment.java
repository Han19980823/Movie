package week1.dianshangjinjie.bw.com.demo4.fragment;

import android.widget.Toast;

import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import week1.dianshangjinjie.bw.com.demo4.R;
import week1.dianshangjinjie.bw.com.demo4.adapter.LeftAdapter;
import week1.dianshangjinjie.bw.com.demo4.adapter.RightAdapter;
import week1.dianshangjinjie.bw.com.demo4.base.mvp.BaseFragment;
import week1.dianshangjinjie.bw.com.demo4.base.mvp.BasePresenter;
import week1.dianshangjinjie.bw.com.demo4.bean.Product;
import week1.dianshangjinjie.bw.com.demo4.bean.ShopBean;
import week1.dianshangjinjie.bw.com.demo4.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo4.presenter.Presenter;

/**
 * 作者：Han98
 * 创建时间：2019/11/23
 * 描述：TODO
 * 最近修改：2019/11/23 09:30 modify by liujc
 */
public class ClzFragment extends BaseFragment implements Icontract.IClz, LeftAdapter.MyCallBack {
    @BindView(R.id.left_recy)
    RecyclerView left_recy;
    @BindView(R.id.right_recy)
    RecyclerView right_recy;
    @BindView(R.id.recy)
    RecyclerView recy;
    LeftAdapter adapter;
    ShopBean shopBeans;
    private List<Product.ResultBean> result;
   private   List<ShopBean.ResultBean.SecondCategoryVoBean> secondCategoryVo;
    private String id;

    @Override
    protected BasePresenter Ipresenter() {
         Presenter presenter = new Presenter();
        presenter.getClz();
        presenter.getPro(id);
        return presenter;
    }

    @Override
    protected int initLayout() {
        return R.layout.clz;
    }

    @Override
    protected void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        left_recy.setLayoutManager(manager);
        GridLayoutManager  manage1r = new GridLayoutManager(getContext(),3);
        right_recy.setLayoutManager(manage1r);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void success(ShopBean shopBean) {
        shopBeans = shopBean;
        Toast.makeText(getContext(), shopBeans.getMessage(), Toast.LENGTH_SHORT).show();
        List<ShopBean.ResultBean> result = shopBeans.getResult();
        adapter = new LeftAdapter(getContext(),result);
        if (adapter!=null){
           left_recy.setAdapter(adapter);
           adapter.setCallBack(this);
        }
    }

    /**
     *
     *根据二级类目查询
     * @param product
     */

    @Override
    public void sucesse(Product product) {
       if (result!=null){
           result = product.getResult();
           Toast.makeText(getContext(), product.getMessage(), Toast.LENGTH_SHORT).show();
       }

    }

    /**
     * 二级列表
     * @param i
     */
    @Override
    public void success(int i) {
        secondCategoryVo   = shopBeans.getResult().get(i).getSecondCategoryVo();
       if (id!=null){
           id = secondCategoryVo.get(i).getId();
       }
        RightAdapter adapte = new RightAdapter(getContext(),secondCategoryVo,result);
        right_recy.setAdapter(adapte);

    }
}
