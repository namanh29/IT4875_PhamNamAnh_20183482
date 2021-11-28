package com.example.gmail;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import java.util.List;

public class ItemAdapter extends BaseAdapter {

    List<ItemModel> items;

    public ItemAdapter(List<ItemModel> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_item_layout, null);

            viewHolder = new ViewHolder();
            viewHolder.imageAvatar = view.findViewById(R.id.image_avatar);
            viewHolder.textName = view.findViewById(R.id.text_name);
            viewHolder.textTitle = view.findViewById(R.id.text_title);
            viewHolder.textContent = view.findViewById(R.id.text_content);
            viewHolder.textTime = view.findViewById(R.id.text_time);
            viewHolder.buttonFavor = view.findViewById(R.id.button_favor);

            view.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) view.getTag();

        ItemModel item = items.get(i);
        //Drawable drawable = ContextCompat.getDrawable(MainActivity.class.getA, R.drawable.image_avatar, null);
        //viewHolder.imageAvatar.setBackgroundColor(item.getAvatarResource());
        ((GradientDrawable)viewHolder.imageAvatar.getBackground()).setColor(item.getAvatarResource());
        viewHolder.imageAvatar.setText((item.getName().toUpperCase().substring(0,1)));
        viewHolder.textName.setText(item.getName());
        viewHolder.textTitle.setText(item.getTitle());
        viewHolder.textContent.setText(item.getContent());
        viewHolder.textTime.setText(item.getTime());
        if(item.isSelected()){
            viewHolder.buttonFavor.setImageResource(R.drawable.ic_baseline_star_24);
            viewHolder.buttonFavor.setColorFilter(Color.YELLOW);
        }

        else{
            viewHolder.buttonFavor.setColorFilter(Color.GRAY);
            viewHolder.buttonFavor.setImageResource(R.drawable.ic_baseline_star_border_24);
        }

        viewHolder.buttonFavor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.setSelected(!item.isSelected());
                notifyDataSetChanged();
            }
        });


        return view;
    }

    private class ViewHolder {
        public TextView imageAvatar;
        public TextView textName;
        public TextView textTitle;
        public TextView textContent;
        public TextView textTime;
        public ImageButton buttonFavor;
    }
}