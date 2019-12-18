package week1.dianshangjinjie.bw.com.demo4.adapter;

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
import week1.dianshangjinjie.bw.com.demo4.R;
import week1.dianshangjinjie.bw.com.demo4.bean.ShopBean;

/**
 * 作者：Han98
 * 创建时间：2019/11/23
 * 描述：TODO
 * 最近修改：2019/11/23 09:46 modify by liujc
 */
public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.Holder> {
    Context context;
    List<ShopBean.ResultBean> result;

    public LeftAdapter(Context context, List<ShopBean.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.clz_item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.shop_name.setText(result.get(position).getName());
        holder.lin_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.success(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.shop_name)
        TextView shop_name;
        @BindView(R.id.lin_id)
        LinearLayout lin_id;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    /**
     *
     * 接口回掉
     */
    MyCallBack callBack;

    public void setCallBack(MyCallBack callBack) {
        this.callBack = callBack;
    }

    public interface MyCallBack{
        void success(int i);
    }
}
