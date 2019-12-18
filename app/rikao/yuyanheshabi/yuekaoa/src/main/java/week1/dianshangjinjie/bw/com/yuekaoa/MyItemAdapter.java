package week1.dianshangjinjie.bw.com.yuekaoa;

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
import week1.dianshangjinjie.bw.com.yuekaoa.bean.CarBean;

/**
 * 作者：Han98
 * 创建时间：2019/11/26
 * 描述：TODO
 * 最近修改：2019/11/26 09:39 modify by liujc
 */
public class MyItemAdapter extends RecyclerView.Adapter<MyItemAdapter.Holder> {
    Context context;
    List<CarBean.Category.Shopping> shoppingCartList;


    public MyItemAdapter(Context context, List<CarBean.Category.Shopping> shoppingCartList) {
        this.context = context;
        this.shoppingCartList = shoppingCartList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        if (shoppingCartList.get(position).isChecked){
            holder.checked.setChecked(true);
        }else {
            holder.checked.setChecked(false);
        }
        Glide.with(context).load(shoppingCartList.get(position).pic).into(holder.imgView);
        holder.textName.setText(shoppingCartList.get(position).commodityName);
        holder.textPrice.setText("$ "+shoppingCartList.get(position).price+"");

    }

    @Override
    public int getItemCount() {
        return shoppingCartList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_view)
        ImageView imgView;
        @BindView(R.id.text_name)
        TextView textName;
        @BindView(R.id.text_price)
        TextView textPrice;
        @BindView(R.id.checked)
        CheckBox checked;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
