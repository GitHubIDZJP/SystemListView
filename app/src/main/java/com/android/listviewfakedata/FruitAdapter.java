package com.android.listviewfakedata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;

    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;

    }


    @Override
    //重写getView（）方法，这个方法在每个子项被滚动到屏幕内的时候会被调用。
    public View getView(int position, View convertView, ViewGroup parent){
         //首先通过getItem()得到当前的项的Fruit实例，然后使用LayoutInflater来为这个子项加载我们传入的布局。
        Fruit fruit = getItem(position); //获取当前项的Fruit实例

        /*
         三个参数
                一个是加载的布局文件id
        另一个是给加载好的布局再添加一个父布局
        false表示只让我们在父布局中声明的layout属性生效，但不会为这个view添加父布局
        */


//         View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
//
//         ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
//
//        TextView fruitName =(TextView) view.findViewById(R.id.fruitname);
//
//        fruitImage.setImageResource(fruit.getImageId());
//
//        fruitName.setText(fruit.getName());
//
//        return view;
        /*
        提升ListView的运行效率
        上面的代码中，FruitAdapter的getView()每次都将布局重新加载了一遍，当ListView快速滚动时，就会成为性能的瓶颈。
        为了解决这问题，需要对ListView进行优化。
        */

          //判断是否为空 类似iOS的if(!=nill){初始化cell} --- 赋用item(cell )
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruitName =(TextView) view.findViewById(R.id.fruitname);
            view.setTag(viewHolder);// 将ViewHolder存储在View中。
        }else
        {
            view = convertView;
            viewHolder=(ViewHolder)view.getTag(); //重新获取ViewHolder

        }
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;

    }
    //这个要先写，不然上面的 viewHolder.fruitImage会报错
    class ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }
}
 /*
getView中的convertView参数，用于将之前加载好的布局进行缓存，以便以后可以进行重用。

        convertView为null时，使用LayoutInflater去加载布局。
        如果不是Null,则直接对convertView进行重用。
        内部类ViewHolder用于对控件的实例进行缓存。

        当convertView为null时
        创建ViewHolder对象，并将控件的实例都存到ViewHolder去，然后调用View的setTag()方法，将ViewHolder对象存储于View中。
        当convertView不为null时
        调用View的setTag()方法，把ViewHolder重新取出
*/