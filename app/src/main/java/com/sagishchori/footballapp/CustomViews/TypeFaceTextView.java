package com.sagishchori.footballapp.CustomViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.sagishchori.footballapp.R;
import com.sagishchori.footballapp.Utils.TypeFaceUtils;

/**
 * Created by Sagi Shchori on 08/11/2017.
 */

public class TypeFaceTextView extends AppCompatTextView {

    public TypeFaceTextView(Context context) {
        this(context, null);
    }

    public TypeFaceTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }

    public TypeFaceTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TypeFaceFont, defStyleAttr, 0);

        int typeFaceFontStyleInt = typedArray.getInt(R.styleable.TypeFaceFont_heebo_type, TypeFaceUtils.Regular);

        setTypeface(TypeFaceUtils.getTypeFace(context, typeFaceFontStyleInt));
    }
}
