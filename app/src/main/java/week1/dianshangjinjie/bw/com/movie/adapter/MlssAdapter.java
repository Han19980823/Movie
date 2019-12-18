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
import week1.dianshangjinjie.bw.com.movie.bean.HomeBean;

/**
 * 作者：Han98
 * 创建时间：2019/12/12
 * 描述：TODO
 * 最近修改：2019/12/12 09:03 modify by liujc
 */
public class MlssAdapter extends RecyclerView.Adapter<MlssAdapter.Holder> {
    List<HomeBean.ResultBean.MlssBean.CommodityListBeanXX> mlss;
    Context context;


    public MlssAdapter( List<HomeBean.ResultBean.MlssBean.CommodityListBeanXX> mlss , Context context) {
        this.mlss = mlss;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mlss, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(mlss.get(position).getMasterPic()).into(holder.img);
        holder.text.setText(mlss.get(position).getCommodityName());
    }

    @Override
    public int getItemCount() {
        return mlss.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.text)
        TextView text;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
