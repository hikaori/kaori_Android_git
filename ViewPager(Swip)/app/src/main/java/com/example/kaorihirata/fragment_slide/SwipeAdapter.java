package com.example.kaorihirata.fragment_slide;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by kaorihirata on 2017-06-14.
 */

public class SwipeAdapter extends PagerAdapter {
    // ADD IMG
    private int[] img_resouces ={R.drawable.dog,R.drawable.cat,R.drawable.beach};

    private Context mctx;
    private LayoutInflater mlayoutInflater;

    //CONSTRUCTOR
    public SwipeAdapter(Context ctx){
        this.mctx=ctx;
    }

    // MUST OVERRIDE METHOD
    //  'getCount()' / 'isViewFromObject(View, Object)' /'instantiateItem(ViewGroup, int)' / destroyItem(ViewGroup, int, Object)
    @Override
    public int getCount() { // HOW MANY CONTENT NEED TO GET
        return img_resouces.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        mlayoutInflater=(LayoutInflater) mctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = mlayoutInflater.inflate(R.layout.swip_layout,container,false);
        ImageView imageView =(ImageView) item_view.findViewById(R.id.imageView1);
        TextView textView =(TextView) item_view.findViewById(R.id.img_count);

        imageView.setImageResource(img_resouces[position]);
        textView.setText("IMG:"+position);

        container.addView(item_view);

        return item_view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
