package week1.dianshangjinjie.bw.com.movie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import week1.dianshangjinjie.bw.com.movie.R;
import week1.dianshangjinjie.bw.com.movie.bean.CardBean;

/**
 * 作者：Han98
 * 创建时间：2019/12/17
 * 描述：TODO
 * 最近修改：2019/12/17 09:00 modify by liujc
 */
public class Adapter2 extends RecyclerView.Adapter<Adapter2.Holder> {
    List<CardBean.ResultBean.ShoppingCartListBean> shoppingCartList;
    Context context;


    public Adapter2(List<CardBean.ResultBean.ShoppingCartListBean> shoppingCartList, Context context) {
        this.shoppingCartList = shoppingCartList;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter2, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(shoppingCartList.get(position).getPic()).into(holder.img);
        holder.name1.setText(shoppingCartList.get(position).getCommodityName());
        holder.name2.setText(shoppingCartList.get(position).getPrice()+"");

    }

    @Override
    public int getItemCount() {
        return shoppingCartList.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.name1)
        TextView name1;
        @BindView(R.id.name2)
        TextView name2;


        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
