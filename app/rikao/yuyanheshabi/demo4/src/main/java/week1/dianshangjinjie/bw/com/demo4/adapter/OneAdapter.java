package week1.dianshangjinjie.bw.com.demo4.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import week1.dianshangjinjie.bw.com.demo4.R;
import week1.dianshangjinjie.bw.com.demo4.bean.CarBean;
import week1.dianshangjinjie.bw.com.demo4.fragment.CarFragment;

/**
 * 作者：Han98
 * 创建时间：2019/11/23
 * 描述：TODO
 * 最近修改：2019/11/23 10:23 modify by liujc
 */
public class OneAdapter extends RecyclerView.Adapter<OneAdapter.Holder> {
    Context context;
    List<CarBean.Category> result;

    public OneAdapter(Context context, List<CarBean.Category> result) {
        this.context = context;
        this.result = result;
    }

    public List<CarBean.Category> getCategories() {
        return result;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.one,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        if (result.get(position).isChecked){
            holder.one_chec.setChecked(true);
        }else{
            holder.one_chec.setChecked(false);
        }

            holder.textView.setText(result.get(position).categoryName);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        holder.one_recy.setLayoutManager(manager);
        List<CarBean.Category.Shopping> shoppingCartList = result.get(position).shoppingCartList;
        TwoAdapter adapter = new TwoAdapter(context,shoppingCartList);
        holder.one_recy.setAdapter(adapter);
        holder.one_chec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (CarBean.Category.Shopping shopping : result.get(position).shoppingCartList) {
                    if (holder.one_chec.isChecked()){
                        shopping.isChecked = true;
                    }else{
                        shopping.isChecked = false;
                    }

                }

                adapter.notifyDataSetChanged();

               CarFragment.carFragment.totalPrice();

            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class  Holder extends RecyclerView.ViewHolder{
            @BindView(R.id.one_chec)
        CheckBox one_chec;
            @BindView(R.id.one_recy)
            RecyclerView one_recy;
            @BindView(R.id.text_name)
        TextView textView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
