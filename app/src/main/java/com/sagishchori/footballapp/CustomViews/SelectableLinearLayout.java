package com.sagishchori.footballapp.CustomViews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.sagishchori.footballapp.Models.MenuItemDataModel;

import java.util.ArrayList;

/**
 * Created by user on 03/10/2017.
 */

public class SelectableLinearLayout extends LinearLayout {

    private OnItemSelectedListener onItemSelectedListener;

    public SelectableLinearLayout(Context context) {
        super(context);
    }

    public SelectableLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SelectableLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Set the menu items to view
     * @param menuItemsList List of {@link MenuItemDataModel} in which the view will be build upon
     */
    public void setMenuItemsToView(ArrayList<MenuItemDataModel> menuItemsList)
    {
        setWeightSum(menuItemsList.size());

        if (menuItemsList == null || menuItemsList.size() == 0)
            return;

        for (int i = 0; i < menuItemsList.size(); i++)
        {
            BottomMenuItemView bottomMenuItemView = new BottomMenuItemView(getContext(), onItemSelectedListener);

            bottomMenuItemView.setTag(menuItemsList.get(i).getTag());
            bottomMenuItemView.getImageView().setImageDrawable(getContext().getDrawable(menuItemsList.get(i).getDrawableResource()));
            bottomMenuItemView.getTextView().setText(getContext().getString(menuItemsList.get(i).getStringResource()));

            LinearLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1);

            bottomMenuItemView.setLayoutParams(params);

            addView(bottomMenuItemView);
        }
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener)
    {
        this.onItemSelectedListener = onItemSelectedListener;
    }

    /**
     * An Interface to indicate a selection has been made
     */
    public interface OnItemSelectedListener
    {
        /**
         * A method to indicate which item were selected
         * @param itemTag   The TAG of the item
         */
        void onItemSelected(String itemTag);
    }
}
