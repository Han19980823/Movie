package week1.dianshangjinjie.bw.com.demo5.adapter;

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
import week1.dianshangjinjie.bw.com.demo5.R;
import week1.dianshangjinjie.bw.com.demo5.bean.ShopBean;

/**
 * 作者：Han98
 * 创建时间：2019/11/25
 * 描述：TODO
 * 最近修改：2019/11/25 14:10 modify by liujc
 */
public class RogihtAdapter extends RecyclerView.Adapter<RogihtAdapter.Holder> {
    Context context;
    List<ShopBean.ResultBean> result;

    public RogihtAdapter(Context context, List<ShopBean.ResultBean> result) {
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
        Glide.with(context).load(result.get(position).getMasterPic()).into(holder.img_view);
        holder.textView.setText(result.get(position).getCommodityName());

    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.img_view)
        ImageView img_view;
        @BindView(R.id.text_da)
        TextView textView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
