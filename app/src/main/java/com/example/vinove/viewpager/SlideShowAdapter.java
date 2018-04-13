package com.example.vinove.viewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

public class SlideShowAdapter extends PagerAdapter {

    public int[] images = {

            R.drawable.angrybird,
            R.drawable.asphalt8,
            R.drawable.clashofclans,
            R.drawable.cuttherope,
            R.drawable.fruitninja,
            R.drawable.pou,
            R.drawable.wheresmywhater,
            R.drawable.talkingtom,
            R.drawable.worms3
    };

    private Context context;

    private LayoutInflater inflater;

    public SlideShowAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return images.length;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slideshow, container, false);

        ImageView imageView = view.findViewById(R.id.imageview_id);
        // imageView.setImageResource(images[position]);

        Glide.with(context).load(images[position]).into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Image " + (position + 1), Snackbar.LENGTH_LONG).show();
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

}
