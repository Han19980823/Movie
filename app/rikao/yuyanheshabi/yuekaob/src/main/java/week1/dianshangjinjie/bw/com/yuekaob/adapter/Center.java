package week1.dianshangjinjie.bw.com.yuekaob.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import week1.dianshangjinjie.bw.com.yuekaob.R;
import week1.dianshangjinjie.bw.com.yuekaob.bean.ShopBean;

/**
 * 作者：Han98
 * 创建时间：2019/11/26
 * 描述：TODO
 * 最近修改：2019/11/26 15:40 modify by liujc
 */
public class Center extends RecyclerView.Adapter<Center.Holder> {
    Context context;
    List<ShopBean.ResultBean.SecondCategoryVoBean> secondCategoryVo;

    public Center(Context context, List<ShopBean.ResultBean.SecondCategoryVoBean> secondCategoryVo) {
        this.context = context;
        this.secondCategoryVo = secondCategoryVo;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.center, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.textView.setText(secondCategoryVo.get(position).getName());
        String id = secondCategoryVo.get(position).getId();
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iback.getData(id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return secondCategoryVo.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.line3)
        LinearLayout linearLayout;
        @BindView(R.id.text_name)
        TextView textView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    Iback iback;

    public void setIback(Iback iback) {
        this.iback = iback;
    }

    public interface Iback {
        void getData(String id);
    }
}
