package week1.dianshangjinjie.bw.com.demo5.adapter.caradapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import week1.dianshangjinjie.bw.com.demo5.R;
import week1.dianshangjinjie.bw.com.demo5.bean.CarBean;
import week1.dianshangjinjie.bw.com.demo5.custom.NumView;

/**
 * 作者：Han98
 * 创建时间：2019/11/25
 * 描述：TODO
 * 最近修改：2019/11/25 14:48 modify by liujc
 */
public class CarItemAdapter extends RecyclerView.Adapter<CarItemAdapter.Holder> {
    Context context;
    List<CarBean.ResultBean.ShoppingCartListBean> shoppingCartList;


    public CarItemAdapter(Context context, List<CarBean.ResultBean.ShoppingCartListBean> shoppingCartList) {
        this.context = context;
        this.shoppingCartList = shoppingCartList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.car_teo, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        if (shoppingCartList.get(position).isChecked) {
            holder.twoChecked.setChecked(true);
        } else {
            holder.twoChecked.setChecked(false);
        }
        Glide.with(context).load(shoppingCartList.get(position).getPic()).into(holder.twoImg);
        holder.teName.setText(shoppingCartList.get(position).getCommodityName());
        holder.price.setText("$ "+shoppingCartList.get(position).getPrice()+"");
        holder.numView.setCallBack(new NumView.ViewCallBack() {
            @Override
            public void getNum() {

            }
        });
    }

    @Override
    public int getItemCount() {
        return shoppingCartList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.two_checked)
        CheckBox twoChecked;
        @BindView(R.id.two_img)
        ImageView twoImg;
        @BindView(R.id.te_name)
        TextView teName;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.num)
        NumView numView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
