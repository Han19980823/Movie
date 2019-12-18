package week1.dianshangjinjie.bw.com.demo5.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import week1.dianshangjinjie.bw.com.demo5.R;

/**
 * 作者：Han98
 * 创建时间：2019/11/25
 * 描述：TODO
 * 最近修改：2019/11/25 15:04 modify by liujc
 */
public class NumView extends LinearLayout {
    int i=1;
    public NumView(Context context) {
        super(context);
    }

    public NumView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
         View view = LayoutInflater.from(context).inflate(R.layout.num,this,true);
        Button jian =  view.findViewById(R.id.jian);
        EditText  edit_query = view.findViewById(R.id.edit_query);
        Button jia =  view.findViewById(R.id.jia);
        jia.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                edit_query.setText(i+"");
            }
        });
        jian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                i--;
                if (i!=1){
                    Toast.makeText(context, "数量最少是一个", Toast.LENGTH_SHORT).show();
                    i=1;
                }

                edit_query.setText(i+"");
            }
        });


    }


    ViewCallBack callBack;

    public void setCallBack(ViewCallBack callBack) {
        this.callBack = callBack;
    }

    public interface ViewCallBack{
        void getNum();
    }
}
