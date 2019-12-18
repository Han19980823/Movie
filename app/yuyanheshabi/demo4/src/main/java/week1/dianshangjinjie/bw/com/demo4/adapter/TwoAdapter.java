package week1.dianshangjinjie.bw.com.demo4.adapter;

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
import week1.dianshangjinjie.bw.com.demo4.R;
import week1.dianshangjinjie.bw.com.demo4.bean.CarBean;
import week1.dianshangjinjie.bw.com.demo4.custom.NumView;
import week1.dianshangjinjie.bw.com.demo4.fragment.CarFragment;

/**
 * 作者：Han98
 * 创建时间：2019/11/23
 * 描述：TODO
 * 最近修改：2019/11/23 10:30 modify by liujc
 */
public class TwoAdapter extends RecyclerView.Adapter<TwoAdapter.Holder> {
    Context context;
    List<CarBean.Category.Shopping> shoppingCartList;


    public TwoAdapter(Context context, List<CarBean.Category.Shopping> shoppingCartList) {
        this.context = context;
        this.shoppingCartList = shoppingCartList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.two, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        if (shoppingCartList.get(position).isChecked) {
            holder.twoChec.setChecked(true);
        } else {
            holder.twoChec.setChecked(false);
        }



        Glide.with(context).load(shoppingCartList.get(position).pic).into(holder.imgView);
        holder.textName.setText(shoppingCartList.get(position).commodityName);
        holder.textPrice.setText("$ "+shoppingCartList.get(position).price+"");
        holder.numView.setMyBack(new NumView.MyBack() {
            @Override
            public void getPrice(int i) {
                shoppingCartList.get(position).num= i;
                CarFragment.carFragment.totalPrice();
            }
        });
    }

    @Override
    public int getItemCount() {
        return shoppingCartList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.two_chec)
        CheckBox twoChec;
        @BindView(R.id.img_view)
        ImageView imgView;
        @BindView(R.id.text_name)
        TextView textName;
        @BindView(R.id.text_price)
        TextView textPrice;
        @BindView(R.id.num_view)
        NumView numView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
