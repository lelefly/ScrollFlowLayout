package com.le.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> list = new ArrayList<>();

    LinearLayout linearLayout;

    JLHorizontalScrollView jhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = (LinearLayout) findViewById(R.id.ll);
        jhs = (JLHorizontalScrollView) findViewById(R.id.jhs);

        initList();
        switchTagView(list);
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                list.add("态度恶劣");
                list.add("服务周到");
                list.add("迟到");
                list.add("不专业");
                list.add("仪表举止不得体");
                list.add("没有良好购房建议");
                list.add("专车体验不好");
                list.add("服务");
                list.add("讲解专业");
                list.add("价值");
                list.add("仪表举止得体");
                list.add("考虑周全");
                list.add("购房建议有价值");
                list.add("为客户着想");
                list.add("守时");
                switchTagView(list);
            }
        });

        findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                initList();
                switchTagView(list);
            }
        });
    }

    private void switchTagView(List<String> list) {
        jhs.setData(list, new JLHorizontalScrollView.OnCompleteCallback() {
            @Override
            public void onComplete(int count) {
                linearLayout.removeAllViews();
                for(int i = 0;i < count; i++){
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    RadioButton radioButton = new RadioButton(MainActivity.this);
                    layoutParams.leftMargin = 20;
                    radioButton.setButtonDrawable(R.drawable.radiobutton_selector);
                    radioButton.setLayoutParams(layoutParams);
                    radioButton.setClickable(false);
                    if(i == 0){
                        radioButton.setChecked(true);
                    }
                    linearLayout.addView(radioButton);
                }
            }

            @Override
            public void onScroll(int index) {
                for(int i = 0;i<linearLayout.getChildCount(); i++){
                    RadioButton radioButton = (RadioButton) linearLayout.getChildAt(i);
                    if(i == index){
                        radioButton.setChecked(true);
                    }else{
                        radioButton.setChecked(false);
                    }
                }
            }
        });
    }

    private void initList() {
        for (int i = 0; i < 30; i++) {
            list.add("---" + i + "---");
        }


    }
}
