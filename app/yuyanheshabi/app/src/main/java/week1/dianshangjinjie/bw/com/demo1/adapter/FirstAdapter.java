package week1.dianshangjinjie.bw.com.demo1.adapter;

import android.content.Context;
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
import week1.dianshangjinjie.bw.com.demo1.CarBean;
import week1.dianshangjinjie.bw.com.demo1.R;

/**
 * 作者：Han98
 * 创建时间：2019/11/21
 * 描述：TODO
 * 最近修改：2019/11/21 19:25 modify by liujc
 */
public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.Holder> {
    Context context;
    List<CarBean.ResultBean> result;

    public FirstAdapter(Context context, List<CarBean.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.first, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.textView.setText(result.get(position).getName());
        holder.lin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataCallBack.callBack(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

   public dataCallBack dataCallBack;

    public void setDataCallBack(FirstAdapter.dataCallBack dataCallBack) {
        this.dataCallBack = dataCallBack;
    }

    public interface dataCallBack{
        void callBack(int i);
    }

    class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.text_name)
        TextView textView;
        @BindView(R.id.lin_btn)
        LinearLayout lin_btn;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
