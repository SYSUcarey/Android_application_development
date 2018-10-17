package com.example.chenbb.personalproject1;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button1);
        final EditText searchContent = (EditText) findViewById(R.id.search_box);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rb0);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 事件处理
                if(TextUtils.isEmpty(searchContent.getText().toString())) {
                    // 弹出Toast消息
                    Toast.makeText(MainActivity.this,"搜索内容不能为空", Toast.LENGTH_SHORT).show();
                }
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("提示");
                    String content = "问答";
                    switch (radioGroup.getCheckedRadioButtonId()){
                        case R.id.rb1:
                            content = "图片";
                            break;
                        case R.id.rb2:
                            content = "视频";
                            break;
                        case R.id.rb3:
                            content = "问答";
                            break;
                        case R.id.rb4:
                            content = "资讯";
                            break;
                    }
                    builder.setMessage(content + "搜索成功");
                    builder.setCancelable(false);
                    if(!searchContent.getText().toString().equals("Health")) {
                        builder.setMessage("搜索失败");
                    }
                    // 设置正面按钮
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "对话框\"确定\"按钮被点击", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });
                    // 设置反面按钮
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "对话框\"取消\"按钮被点击", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb1:
                        Toast.makeText(MainActivity.this,"图片被选中", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb2:
                        Toast.makeText(MainActivity.this,"视频被选中", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb3:
                        Toast.makeText(MainActivity.this,"问答被选中", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb4:
                        Toast.makeText(MainActivity.this,"资讯被选中", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }


}
