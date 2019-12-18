package week1.dianshangjinjie.bw.com.demo3.fragment;

import android.content.Context;
import android.graphics.Color;
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
import week1.dianshangjinjie.bw.com.demo3.R;

import week1.dianshangjinjie.bw.com.demo3.bean.ShopBean;

/**
 * 作者：Han98
 * 创建时间：2019/11/22
 * 描述：TODO
 * 最近修改：2019/11/22 19:19 modify by liujc
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
        View view = LayoutInflater.from(context).inflate(R.layout.left,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.textView.setText(result.get(position).getName());
        holder.lin_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                callBack.getNum(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.text_name)
        TextView textView;
        @BindView(R.id.lin_id)
        LinearLayout lin_id;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }




    /**
     * 接口回调
     */

    MyCallBack callBack;

    public void setCallBack(MyCallBack callBack) {
        this.callBack = callBack;
    }

    public interface MyCallBack{
        void getNum(int i);
    }
}
