package com.sagishchori.footballapp.CustomViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.sagishchori.footballapp.R;
import com.sagishchori.footballapp.Utils.TypeFaceUtils;

/**
 * Created by Sagi Shchori on 09/11/2017.
 */

public class TypeFaceEditText extends AppCompatEditText {

    public TypeFaceEditText(Context context) {
        this(context, null);
    }

    public TypeFaceEditText(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.editTextStyle);
    }

    public TypeFaceEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TypeFaceFont, defStyleAttr, 0);

        int typeFaceFontStyleInt = typedArray.getInt(R.styleable.TypeFaceFont_heebo_type, TypeFaceUtils.Regular);

        setTypeface(TypeFaceUtils.getTypeFace(context, typeFaceFontStyleInt));
    }
}
