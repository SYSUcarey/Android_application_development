package com.example.chenbb.personalproject1_finaltask;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.OvershootInLeftAnimator;

public class MainActivity extends AppCompatActivity {

    private int view_tag = 0;
    private List<Map<String, Object>> favorite = new ArrayList<>();
    private ListView listview;
    private SimpleAdapter simpleAdapter;
    private MyRecyclerViewAdapter myAdapter;
    private MyRecyclerViewAdapter myFavoriteAdapter;
    private RecyclerView recyclerView;
    private List<Collection> data;
    //private List<Collection> favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * favorite ListView
         * SimpleAdapter + ListView
         * Show the favorite list
         * deal with the ClickListener
         */
        // 初始化收藏夹数据，列表为空，只有收藏夹
        String[] favorite_foodType = new String[]{"*"};
        String[] favorite_foodName = new String[]{"收藏夹"};
        for(int i = 0; i < 1; i++) {
            Map<String, Object> temp = new LinkedHashMap<>();
            temp.put("type", favorite_foodType[i]);
            temp.put("name", favorite_foodName[i]);
            temp.put("longType", "longType");
            temp.put("nutrition", "nutrition");
            temp.put("color", "color");
            temp.put("isCollected", false);
            favorite.add(temp);
        }
        listview = (ListView)findViewById(R.id.listView);
        simpleAdapter = new SimpleAdapter(this, favorite, R.layout.item, new String[]{"type", "name"}, new int[] {R.id.type, R.id.name});
        listview.setAdapter(simpleAdapter);

        //短按事件处理
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 如果点击到收藏夹，无反应
                if(favorite.get(position).get("name").toString().equals("收藏夹")) return;
                // 处理单击事件
                //Toast.makeText(MainActivity.this, "跳转到详情页面", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(MainActivity.this, DetailActivity.class);
                Bundle bundle = new Bundle();
                Map<String, Object> tempMap = favorite.get(position);
                Collection temp = new Collection(tempMap.get("type").toString(),tempMap.get("name").toString(), tempMap.get("longType").toString(),
                        tempMap.get("nutrition").toString(), tempMap.get("color").toString(), false);
                bundle.putSerializable("data", temp);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        });


        //长按事件处理
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                // 如果点击到收藏夹，无反应
                if(favorite.get(position).get("name").toString().equals("收藏夹")) return true;
                // 处理长按事件
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("删除");
                builder.setMessage("确定删除" + favorite.get(position).get("name").toString() + "?" );
                // 设置正面按钮
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        favorite.remove(position);
                        simpleAdapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
                // 设置反面按钮
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            }
        });


        /*
         * myAdapter + RecylerView
         * show foodType and foodName
         * define the abstract function convert()
         * achieve Animation effect
         */

        // 初始化食谱数据
        data = new ArrayList<>();
        String[] foodType = new String[]{"粮", "蔬", "饮", "肉", "蔬", "饮", "蔬", "蔬", "粮", "杂"};
        String[] foodName = new String[]{"大豆", "十字花科蔬菜", "牛奶", "海鱼", "菌菇类", "绿茶", "番茄", "胡萝卜", "荞麦", "鸡蛋"};
        String[] longType = new String[]{"粮食", "蔬菜", "饮品", "肉食", "蔬菜", "饮品", "蔬菜", "蔬菜", "粮食", "杂"};
        String[] foodNutrition = new String[]{"蛋白质", "维生素C", "钙", "蛋白质", "微量元素", "无机矿质元素", "番茄红素", "胡萝卜素", "膳食纤维", "几乎所有物质"};
        String[] color = new String[]{"#BB4C3B", "#C48D30", "#4469B0", "#20A17B", "#BB4C3B", "#C48D30", "#4469B0", "#20A17B", "#BB4C3B", "#C48D30"};
        for (int i = 0; i < 10; i++) {
            Collection temp = new Collection(foodType[i], foodName[i], longType[i], foodNutrition[i], color[i], false);
            data.add(temp);
        }

        // 创建MyRecyclerViewAdapter<Collection>
        myAdapter = new MyRecyclerViewAdapter<Collection>(MainActivity.this, R.layout.item, data) {
            @Override
            public void convert(MyViewHolder holder, Collection s) {
                // Colloction是自定义的一个类，封装了数据信息，也可以直接将数据做成一个Map，那么这里就是Map<String, Object>
                TextView name = holder.getView(R.id.name);
                name.setText(s.getName().toString());
                Button type = holder.getView(R.id.type);
                type.setText(s.getType().toString());
            }
        };


        // 定义自定义适配器MyRecyclerViewAdapter的点击响应事件
        myAdapter.setOnItemClickListener(new MyRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                //Toast.makeText(MainActivity.this, "跳转到" + data.get(position).getName().toString() + "详情界面", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(MainActivity.this, DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", data.get(position));
                intent.putExtras(bundle);
                startActivityForResult(intent, 0);
            }

            @Override
            public void onLongClick(int position) {
                Toast.makeText(MainActivity.this, "删除" + data.get(position).getName().toString(), Toast.LENGTH_SHORT).show();
                data.remove(position);
                myAdapter.notifyDataSetChanged();
            }
        });


        // 动画效果
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ScaleInAnimationAdapter scaleInAnimationAdapter = new ScaleInAnimationAdapter(myAdapter);
        scaleInAnimationAdapter.setDuration(1000);
        recyclerView.setAdapter((scaleInAnimationAdapter));
        recyclerView.setItemAnimator(new OvershootInLeftAnimator());




        /*
         * FloatingActionButton 的点击响应事件
         * 1.调换列表
         * 2.修改Tag
         * 3.修改图片
         */
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.btn);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 根据view_tag分为食谱界面和收藏夹界面
                if(view_tag == 0) {
                    //调换列表
                    listview.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.INVISIBLE);
                    // 修改tag
                    view_tag = 1;
                    // 修改FloatingActionButton图片
                    fab.setImageResource(R.mipmap.mainpage);
                }
                else {
                    //调换列表
                    listview.setVisibility(View.INVISIBLE);
                    recyclerView.setVisibility(View.VISIBLE);
                    // 修改tag
                    view_tag = 0;
                    // 修改FloatingActionButton图片
                    fab.setImageResource(R.mipmap.collect);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
        if(_resultCode == RESULT_OK) {
            Intent intent = _data;
            Bundle bundle = intent.getExtras();
            Collection temp = (Collection) bundle.getSerializable("data");
            Map<String, Object> tempMap = new LinkedHashMap<>();
            tempMap.put("type", temp.getType().toString());
            tempMap.put("name", temp.getName().toString());
            tempMap.put("longType", temp.getLongType().toString());
            tempMap.put("nutrition", temp.getNutrition().toString());
            tempMap.put("color", temp.getColor().toString());
            tempMap.put("isCollected", (Boolean)temp.getIsCollected());
            favorite.add(tempMap);
            simpleAdapter.notifyDataSetChanged();
        }

    }
}
