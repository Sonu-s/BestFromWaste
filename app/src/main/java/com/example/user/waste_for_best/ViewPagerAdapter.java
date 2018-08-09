package com.example.user.waste_for_best;


import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images = {R.drawable.smartbin,R.drawable.ic_menu_camera,R.drawable.ic_menu_send};

    public ViewPagerAdapter(Context context) {

        this.context = context;
    }

    @Override
    public int getCount() {

        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (position == 0){

                    Toast.makeText(context,"Smart Bin",Toast.LENGTH_SHORT).show();

                }else if (position == 1){

                    Intent intent = new Intent(view.getContext(),FoodWasteActivity.class);
                    view.getContext().startActivity(intent);

                    Toast.makeText(context,"Food Waste",Toast.LENGTH_SHORT).show();

                }else if (position ==2){

                    Intent intent = new Intent(view.getContext(),GridViewActivity.class);
                    view.getContext().startActivity(intent);

                    Toast.makeText(context,"Sell Buy",Toast.LENGTH_SHORT).show();
                }
            }
        });


        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}