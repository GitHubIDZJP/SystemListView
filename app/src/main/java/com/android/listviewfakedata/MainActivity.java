package com.android.listviewfakedata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();//空数组

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        initFruits();// 初始化水果数据

        //ArraryAdapter适配器，通过泛型来指定要适配的数据类型，然后在构造函数中把要适配的数据传入。
        FruitAdapter arrayAdapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);

        ListView listView = (ListView) findViewById(R.id.lv);
        listView.setAdapter(arrayAdapter);
        //listView的Item被点击跳转
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //点击index_item获取当前item的值
                Fruit index = fruitList.get(position);
                Toast.makeText(MainActivity.this, index.getName(), Toast.LENGTH_SHORT).show();
                Intent     secondaryPage = new Intent(MainActivity.this,systemMainActivity.class);
                startActivity(secondaryPage);
            }
        });
    }

    //加载假数据
    private void initFruits(){
        for( int i =0; i<2;i++){
            Fruit apple = new Fruit("Apple",R.drawable.hero1);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana",R.drawable.hero2);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange",R.drawable.hero3);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon",R.drawable.hero4);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear",R.drawable.hero5);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape",R.drawable.hero6);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple",R.drawable.hero7);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry",R.drawable.hero8);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry",R.drawable.hero1);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango",R.drawable.hero3);
            fruitList.add(mango);

        }
    }


}