package com.sagishchori.footballapp.Utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Sagi Shchori on 08/11/2017.
 */

public class TypeFaceUtils {

    /**
     * Heebo font types paths
     */
    public static final String HEEBO_BOLD_PATH = "Heebo-Bold.ttf";
    public static final String HEEBO_EXTRA_BOLD_PATH = "Heebo-ExtraBold.ttf";
    public static final String HEEBO_LIGHT_PATH = "Heebo-Light.ttf";
    public static final String HEEBO_MEDIUM_PATH = "Heebo-Medium.ttf";
    public static final String HEEBO_REGULAR_PATH = "Heebo-Regular.ttf";
    public static final String HEEBO_THIN_PATH = "Heebo-Thin.ttf";

    /**
     * TypeFace style
     */
    public static final int Bold = 0;
    public static final int Extra_Bold = 1;
    public static final int Light = 2;
    public static final int Medium = 3;
    public static final int Regular = 4;
    public static final int Thin = 5;

    /**
     * Get the requested {@link Typeface} according to the selected style.
     * @param context               context
     * @param typeFaceFontStyleInt  The selected font style
     * @return                      The requested font
     */
    public static Typeface getTypeFace(Context context, int typeFaceFontStyleInt)
    {
        switch (typeFaceFontStyleInt)
        {
            case Bold:
                return Typeface.createFromAsset(context.getAssets(), HEEBO_BOLD_PATH);

            case Extra_Bold:
                return Typeface.createFromAsset(context.getAssets(), HEEBO_EXTRA_BOLD_PATH);

            case Light:
                return Typeface.createFromAsset(context.getAssets(), HEEBO_LIGHT_PATH);

            case Medium:
                return Typeface.createFromAsset(context.getAssets(), HEEBO_MEDIUM_PATH);

            case Regular:
                return Typeface.createFromAsset(context.getAssets(), HEEBO_REGULAR_PATH);

            case Thin:
                return Typeface.createFromAsset(context.getAssets(), HEEBO_THIN_PATH);

            default:
                return Typeface.createFromAsset(context.getAssets(), HEEBO_REGULAR_PATH);
        }
    }
}
