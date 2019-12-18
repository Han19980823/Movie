package week1.dianshangjinjie.bw.com.yuekaob.adapter;

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
import week1.dianshangjinjie.bw.com.yuekaob.R;
import week1.dianshangjinjie.bw.com.yuekaob.bean.ChaBean;

/**
 * 作者：Han98
 * 创建时间：2019/11/26
 * 描述：TODO
 * 最近修改：2019/11/26 16:01 modify by liujc
 */
public class BottonAdapter extends RecyclerView.Adapter<BottonAdapter.Holder> {
    Context context;
    List<ChaBean.ResultBean> result;


    public BottonAdapter(Context context, List<ChaBean.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bottom, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(result.get(position).getMasterPic()).into(holder.imgView);
        holder.textName.setText(result.get(position).getCommodityName());
        holder.textPrice.setText("$ " + result.get(position).getPrice() + "");

    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_view)
        ImageView imgView;
        @BindView(R.id.text_name)
        TextView textName;
        @BindView(R.id.text_price)
        TextView textPrice;

        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
