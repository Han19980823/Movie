package week1.dianshangjinjie.bw.com.demo5.adapter.caradapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import week1.dianshangjinjie.bw.com.demo5.R;
import week1.dianshangjinjie.bw.com.demo5.bean.CarBean;

/**
 * 作者：Han98
 * 创建时间：2019/11/25
 * 描述：TODO
 * 最近修改：2019/11/25 14:38 modify by liujc
 */
public class CarAdapter extends RecyclerView.Adapter<CarAdapter.Holder> {
    Context context;
    List<CarBean.ResultBean> result;


    public CarAdapter(Context context, List<CarBean.ResultBean> result) {
        this.context = context;
        this.result = result;
    }
    public List<CarBean.ResultBean> getCategories() {
        return result;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.car_item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        if (result.get(position).isChecked){
            holder.one_checked.setChecked(true);
        }else{
            holder.one_checked.setChecked(false);
        }
        holder.shop_name.setText(result.get(position).getCategoryName());
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        holder.one_recy.setLayoutManager(manager);
        List<CarBean.ResultBean.ShoppingCartListBean> shoppingCartList = result.get(position).getShoppingCartList();
        CarItemAdapter adapter = new CarItemAdapter(context,shoppingCartList);
        holder.one_recy.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.one_checked)
        CheckBox one_checked;
        @BindView(R.id.shop_name)
        TextView shop_name;
        @BindView(R.id.one_recy)
        RecyclerView one_recy;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
