package com.example.chenbb.personalproject1_finaltask;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DetailActivity extends AppCompatActivity {
    private ImageView backView;
    private ImageView starView;
    private ImageView collectView;
    private ListView listView;
    private List<Map<String, Object>> opertions = new ArrayList<>();
    private SimpleAdapter simpleAdapter;
    private int star_tag = 0;
    private Collection data;
    private RelativeLayout layout1;
    private TextView foodNameView;
    private TextView foodTypeView;
    private TextView foodNutritionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        // 获取Intent, bundle传过来的数据data: Collection
        final Intent intent = this.getIntent();
        final Bundle bundle = intent.getExtras();
        data = (Collection) bundle.getSerializable("data");
        data.setCollected(false);

        /*
         * 根据data: Collection设置页面信息
         * 1.设置顶层颜色信息
         * 2.设置食物名字信息
         * 3.设置食物类型信息
         * 4.设置营养物质信息
         */
        layout1 = (RelativeLayout)findViewById(R.id.layout1);
        layout1.setBackgroundColor(Color.parseColor(data.getColor()));
        foodNameView = (TextView)findViewById(R.id.foodName);
        foodNameView.setText(data.getName().toString());
        foodTypeView = (TextView)findViewById(R.id.foodType);
        foodTypeView.setText(data.getLongType().toString());
        foodNutritionView = (TextView)findViewById(R.id.foodNutrition);
        foodNutritionView.setText(data.getNutrition().toString());


        // 设置返回按钮的点击处理事件
        backView = (ImageView) findViewById(R.id.back);
        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(data.getIsCollected() == true) {
                    Intent intent1 = new Intent(DetailActivity.this, MainActivity.class);
                    Bundle bundle1 = new Bundle();
                    bundle1.putSerializable("data", data);
                    intent1.putExtras(bundle1);
                    setResult(RESULT_OK, intent1);
                }
                finish();
            }
        });

        // 设置star按钮的点击处理事件
        starView = (ImageView) findViewById(R.id.star);
        starView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(star_tag == 0) {
                    starView.setImageResource(R.mipmap.full_star);
                    star_tag = 1;
                }
                else {
                    starView.setImageResource(R.mipmap.empty_star);
                    star_tag = 0;
                }
            }
        });


        // 设置收藏按钮的点击处理事件
        collectView = (ImageView) findViewById(R.id.collect);
        collectView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setCollected(true);
                Toast.makeText(DetailActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
            }
        });


        // 设置页面底部ListView
        listView = (ListView)findViewById(R.id.listView);
        String str[] = {"分享信息", "不感兴趣", "查看更多信息", "出错反馈"};
        for(int i = 0; i < 4; i++) {
            Map<String, Object> temp = new LinkedHashMap<>();
            temp.put("type", str[i]);
            opertions.add(temp);
        }
        simpleAdapter = new SimpleAdapter(this, opertions, R.layout.operation, new String[]{"type"}, new int[] {R.id.type});
        listView.setAdapter(simpleAdapter);
    }
}
