package week1.dianshangjinjie.bw.com.yuekaoa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import week1.dianshangjinjie.bw.com.yuekaoa.bean.CarBean;

/**
 * 作者：Han98
 * 创建时间：2019/11/26
 * 描述：TODO
 * 最近修改：2019/11/26 09:33 modify by liujc
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    Context context;
    List<CarBean.Category> result;

    public MyAdapter(Context context, List<CarBean.Category> result) {
        this.context = context;
        this.result = result;
    }
    public   List<CarBean.Category> list () {
        return result;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.car,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        if (result.get(position).isChecked){
            holder.checkbox.setChecked(true);
        }else{
            holder.checkbox.setChecked(false);
        }
        holder.textView.setText(result.get(position).categoryName);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        holder.recyclerView.setLayoutManager(manager);
        List<CarBean.Category.Shopping> shoppingCartList = result.get(position).shoppingCartList;
        MyItemAdapter adapter = new MyItemAdapter(context,shoppingCartList);
        holder.recyclerView.setAdapter(adapter);

    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.text_name)
        TextView textView;
        @BindView(R.id.recyclerView)
        RecyclerView recyclerView;
        @BindView(R.id.checkbox)
        CheckBox checkbox;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }


}
