package week1.dianshangjinjie.bw.com.demo1.adapter;

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
import week1.dianshangjinjie.bw.com.demo1.CarBean;
import week1.dianshangjinjie.bw.com.demo1.R;

/**
 * 作者：Han98
 * 创建时间：2019/11/21
 * 描述：TODO
 * 最近修改：2019/11/21 19:25 modify by liujc
 */
public class SeconAdapter extends RecyclerView.Adapter<SeconAdapter.Holder> {
    Context context;
    List<CarBean.ResultBean.SecondCategoryVoBean>  secondCategoryVo;

    public SeconAdapter(Context context, List<CarBean.ResultBean.SecondCategoryVoBean> secondCategoryVo) {
        this.context = context;
        this.secondCategoryVo = secondCategoryVo;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.two, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.textView.setText(secondCategoryVo.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return secondCategoryVo.size();
    }



    class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.text_name)
        TextView textView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
