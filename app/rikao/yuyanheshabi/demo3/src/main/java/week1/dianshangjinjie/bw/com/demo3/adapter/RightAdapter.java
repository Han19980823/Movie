package week1.dianshangjinjie.bw.com.demo3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import week1.dianshangjinjie.bw.com.demo3.R;

import week1.dianshangjinjie.bw.com.demo3.bean.ShopBean;
import week1.dianshangjinjie.bw.com.demo3.fragment.LeftAdapter;

/**
 * 作者：Han98
 * 创建时间：2019/11/22
 * 描述：TODO
 * 最近修改：2019/11/22 19:32 modify by liujc
 */
public class RightAdapter extends RecyclerView.Adapter<RightAdapter.Holder> {

    Context context;
    List<ShopBean.ResultBean.SecondCategoryVoBean> secondCategoryVo;

    public RightAdapter(Context context, List<ShopBean.ResultBean.SecondCategoryVoBean> secondCategoryVo) {
        this.context = context;
        this.secondCategoryVo = secondCategoryVo;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.right,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
      Glide.with(context).load(secondCategoryVo.get(position).getMasterPic()).into(holder.img_item);
      holder.shop_name.setText(secondCategoryVo.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return secondCategoryVo.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.img2)
        ImageView img_item;
        @BindView(R.id.shop_name)
        TextView shop_name;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
