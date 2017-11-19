package com.sagishchori.footballapp.CustomViews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sagishchori.footballapp.R;

/**
 * Created by user on 03/10/2017.
 */

public class BottomMenuItemView extends LinearLayout implements View.OnClickListener, View.OnTouchListener{

    private View rootView;
    private ImageView imageView;
    private TextView textView;

    private final SelectableLinearLayout.OnItemSelectedListener onItemSelectedListener;


    public BottomMenuItemView(Context context, SelectableLinearLayout.OnItemSelectedListener onItemSelectedListener) {
        super(context);

        this.onItemSelectedListener = onItemSelectedListener;
        init(context);
    }

    public BottomMenuItemView(Context context, @Nullable AttributeSet attrs, SelectableLinearLayout.OnItemSelectedListener onItemSelectedListener) {
        super(context, attrs);

        this.onItemSelectedListener = onItemSelectedListener;
        init(context);
    }

    public BottomMenuItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, SelectableLinearLayout.OnItemSelectedListener onItemSelectedListener) {
        super(context, attrs, defStyleAttr);

        this.onItemSelectedListener = onItemSelectedListener;
        init(context);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.menu_item, this);

        imageView = (ImageView) rootView.findViewById(R.id.menu_item_iv);
        textView = (TextView) rootView.findViewById(R.id.menu_item_tv);
        setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (onItemSelectedListener != null)
            onItemSelectedListener.onItemSelected((String) view.getTag());
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTextView() {
        return textView;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
