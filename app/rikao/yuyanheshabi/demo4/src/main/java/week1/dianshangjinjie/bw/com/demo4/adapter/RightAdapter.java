package week1.dianshangjinjie.bw.com.demo4.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import javax.microedition.khronos.opengles.GL;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import week1.dianshangjinjie.bw.com.demo4.R;
import week1.dianshangjinjie.bw.com.demo4.bean.Product;
import week1.dianshangjinjie.bw.com.demo4.bean.ShopBean;

/**
 * 作者：Han98
 * 创建时间：2019/11/23
 * 描述：TODO
 * 最近修改：2019/11/23 09:46 modify by liujc
 */
public class RightAdapter extends RecyclerView.Adapter<RightAdapter.Holder> {
    Context context;
    List<ShopBean.ResultBean.SecondCategoryVoBean> secondCategoryVo;
    List<Product.ResultBean> result;


    public RightAdapter(Context context, List<ShopBean.ResultBean.SecondCategoryVoBean> secondCategoryVo, List<Product.ResultBean> result) {
        this.context = context;
        this.secondCategoryVo = secondCategoryVo;
        this.result = result;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.car_item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.textView.setText(secondCategoryVo.get(position).getName());
        GridLayoutManager manage1r = new GridLayoutManager(context,3);
        holder.recyclerView.setLayoutManager(manage1r);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             back.callBack();
            }
        });

    }

    MyCallBack back;

    public void setBack(MyCallBack back) {
        this.back = back;
    }

    public interface MyCallBack{
        void callBack();
    }


    @Override
    public int getItemCount() {
        return secondCategoryVo.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.text_name)
        TextView textView;
        @BindView(R.id.recy_id_item)
        RecyclerView recyclerView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
