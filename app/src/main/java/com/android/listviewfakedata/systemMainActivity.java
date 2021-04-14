package com.android.listviewfakedata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.ButterKnife;

public class systemMainActivity  extends  MainActivity{
             //定义字符串数组
    private String [] arrStr = {"Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry",
            "Mango","Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry",
            "Mango"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.system_main_activity);


                 /*
                 *  3个参数:
                 *  1是Context 传入当前的上下文
                    2是ListView子项布局的ID
                    3是要适配的数据

                  */


        //ArraryAdapter适配器，通过泛型来指定要适配的数据类型，然后在构造函数中把要适配的数据传入。
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String> (
                systemMainActivity.this, android.R.layout.simple_list_item_single_choice,arrStr);
        ListView listView = (ListView) findViewById(R.id.lv);
        listView.setAdapter(arrayAdapter);
                    /*
                    * 单选: android.R.layout.simple_list_item_single_choice      iOS的话:   cell.accessoryType = UITableViewCellAccessoryNone;
                    *
                     * 每行的字符串:  arrStr  iOS的话:arrSTr[i];
                    * */


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //点击index_item获取当前item的值
                //String indexStr = arrStr[];
                Toast.makeText(systemMainActivity.this, arrStr[position], Toast.LENGTH_SHORT).show();
                Intent secondaryPage = new Intent(systemMainActivity.this,MainActivity.class);
                startActivity(secondaryPage);
            }
        });

    }




}
