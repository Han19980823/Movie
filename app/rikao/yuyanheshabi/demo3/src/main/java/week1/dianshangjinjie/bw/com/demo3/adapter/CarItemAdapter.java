package week1.dianshangjinjie.bw.com.demo3.adapter;

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
import week1.dianshangjinjie.bw.com.demo3.R;
import week1.dianshangjinjie.bw.com.demo3.bean.CarBean;

/**
 * 作者：Han98
 * 创建时间：2019/11/22
 * 描述：TODO
 * 最近修改：2019/11/22 15:53 modify by liujc
 */
public class CarItemAdapter extends RecyclerView.Adapter<CarItemAdapter.Holder> {
    List<CarBean.ResultBean.ShoppingCartListBean>  shoppingCartList;
    Context context;


    public CarItemAdapter( List<CarBean.ResultBean.ShoppingCartListBean>  shoppingCartList, Context context) {
        this.shoppingCartList = shoppingCartList;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view   = LayoutInflater.from(context).inflate(R.layout.car_item_item1,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.text_shop.setText(shoppingCartList.get(position).getCommodityName());
        holder.text_price.setText("$ "+shoppingCartList.get(position).getPrice()+"");
        Glide.with(context).load(shoppingCartList.get(position).getPic()).into(holder.img_view);


    }

    @Override
    public int getItemCount() {
        return shoppingCartList.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        @BindView(R.id.text_shop)
        TextView text_shop;
        @BindView(R.id.text_price)
        TextView text_price;
        @BindView(R.id.item_chck)
        CheckBox item_chck;
        @BindView(R.id.img_view)
        ImageView img_view;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
