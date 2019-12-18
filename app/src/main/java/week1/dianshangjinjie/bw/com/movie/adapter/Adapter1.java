package week1.dianshangjinjie.bw.com.movie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
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
public class Adapter1 extends RecyclerView.Adapter<Adapter1.Holder> {
    List<CardBean.ResultBean> result;
    Context context;


    public Adapter1(List<CardBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter1, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.name.setText(result.get(position).getCategoryName());
        LinearLayoutManager manager = new LinearLayoutManager(context);
        holder.recy.setLayoutManager(manager);
        List<CardBean.ResultBean.ShoppingCartListBean> shoppingCartList = result.get(position).getShoppingCartList();
        Adapter2 adapter2 = new Adapter2(shoppingCartList,context);
        holder.recy.setAdapter(adapter2);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.recy)
        RecyclerView recy;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
