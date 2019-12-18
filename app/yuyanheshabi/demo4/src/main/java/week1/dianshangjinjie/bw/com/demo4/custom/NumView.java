package week1.dianshangjinjie.bw.com.demo4.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import week1.dianshangjinjie.bw.com.demo4.R;

/**
 * 作者：Han98
 * 创建时间：2019/11/23
 * 描述：TODO
 * 最近修改：2019/11/23 10:51 modify by liujc
 */
public class NumView  extends LinearLayout {

    public EditText ed_num;
    public Button jia;
    public Button jian;
    int i = 1;

    public NumView(Context context) {
        super(context);
    }

    public NumView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.num,this,true);
        jian = view.findViewById(R.id.jian);
        jia = view.findViewById(R.id.jia);
        ed_num = view.findViewById(R.id.ed_num);
        jia.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
               i++;
                ed_num.setText(i+"");

            }
        });
        jian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
               i--;
               if (i==1){
                   Toast.makeText(context, "数量至少是一个", Toast.LENGTH_SHORT).show();
                   i=1;
               }
                ed_num.setText(i+"");
                myBack.getPrice(i);
            }
        });

    }


    MyBack myBack;

    public void setMyBack(MyBack myBack) {
        this.myBack = myBack;
    }

    public interface MyBack{
        void getPrice(int i);
    }
}
