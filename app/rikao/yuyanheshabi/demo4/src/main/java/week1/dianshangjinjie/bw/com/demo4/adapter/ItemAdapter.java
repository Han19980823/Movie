package week1.dianshangjinjie.bw.com.demo4.adapter;

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
import week1.dianshangjinjie.bw.com.demo4.R;
import week1.dianshangjinjie.bw.com.demo4.bean.Product;

/**
 * 作者：Han98
 * 创建时间：2019/11/24
 * 描述：TODO
 * 最近修改：2019/11/24 19:21 modify by liujc
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.Holder> {
    Context context;
    List<Product.ResultBean> result;

    public ItemAdapter(Context context, List<Product.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(result.get(position).getMasterPic()).into(holder.imageView);
        holder.textView.setText(result.get(position).getCommodityName());
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.img_bire)
        ImageView imageView;
        @BindView(R.id.text_product)
        TextView textView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
