package week1.dianshangjinjie.bw.com.demo5.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import week1.dianshangjinjie.bw.com.demo5.bean.ClzBean;
import week1.dianshangjinjie.bw.com.demo5.R;

/**
 * 作者：Han98
 * 创建时间：2019/11/25
 * 描述：TODO
 * 最近修改：2019/11/25 13:40 modify by liujc
 */
public class CenterAdapter extends RecyclerView.Adapter<CenterAdapter.Holder> {
    Context context;
    List<ClzBean.ResultBean.SecondCategoryVoBean> secondCategoryVo;

    public CenterAdapter(Context context, List<ClzBean.ResultBean.SecondCategoryVoBean> secondCategoryVo) {
        this.context = context;
        this.secondCategoryVo = secondCategoryVo;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.clz_right_one,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.textView.setText(secondCategoryVo.get(position).getName());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = secondCategoryVo.get(position).getId();
                Toast.makeText(context, secondCategoryVo.get(position).getName(), Toast.LENGTH_SHORT).show();
                iBack.success(id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return secondCategoryVo.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.text_shop_name)
        TextView textView ;
        @BindView(R.id.lin_id_item)
        LinearLayout linearLayout;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    IBack iBack;

    public void setiBack(IBack iBack) {
        this.iBack = iBack;
    }

    public interface IBack{
        void success(String id);
    }
}
