package com.sagishchori.footballapp.Adapters;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sagishchori.footballapp.CustomViews.CustomImageView;
import com.sagishchori.footballapp.R;

/**
 * Created by user on 05/10/2017.
 */

public class GameBoardRecyclerViewAdapter extends RecyclerView.Adapter<GameBoardRecyclerViewAdapter.GameBoardItem>
{
    private static final int GAME_BOAR_ITEMS_NUMBER = 9;

    @Override
    public GameBoardItem onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_game_board_item, parent, false);
        return new GameBoardItem(view);
    }

    @Override
    public void onBindViewHolder(GameBoardItem holder, int position)
    {
        holder.scratchView.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent)
            {
                switch (motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                        BitmapDrawable bitmapDrawable = (BitmapDrawable) ((ImageView) view).getDrawable();
                        Bitmap bitmap = bitmapDrawable.getBitmap();
                        final int x = ((int) motionEvent.getX()), y = ((int) motionEvent.getY());
                        int scalingMultiplier = view.getWidth() > view.getHeight() ? view.getHeight() : view.getWidth();
                        int x1 = (x - (view.getWidth() - scalingMultiplier)/2)*bitmap.getWidth()/scalingMultiplier;
                        int y1 = (y - (view.getHeight() - scalingMultiplier)/2)*bitmap.getHeight()/scalingMultiplier;
                        if (bitmap != null) {
                            Bitmap newBitmap = bitmap.copy(Bitmap.Config.ARGB_8888,true);
                            for (int i = -25; i < 25; i++) {
                                for (int j = -25; j < 25; j++) {
                                    if (x + i >= view.getRight() || x + i <= view.getLeft())
                                        break;

                                    if (y + j >= view.getBottom() || y + j <= view.getTop())
                                        break;

                                    newBitmap.setPixel(x1 + i, y1 + j, Color.TRANSPARENT);
                                }
                            }

                            ((ImageView) view).setImageBitmap(newBitmap);
                        }
                        break;


                    default:
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return GAME_BOAR_ITEMS_NUMBER;
    }

    class GameBoardItem extends RecyclerView.ViewHolder
    {
        private CustomImageView scoreVIew, scratchView;

        public GameBoardItem(View itemView)
        {
            super(itemView);

            scoreVIew = (CustomImageView) itemView.findViewById(R.id.score_circle);
            scratchView = (CustomImageView) itemView.findViewById(R.id.scratch_circle);
        }
    }
}
