package com.sagishchori.footballapp.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sagishchori.footballapp.Adapters.GameBoardRecyclerViewAdapter;
import com.sagishchori.footballapp.CustomViews.CustomRecyclerView;
import com.sagishchori.footballapp.R;

/**
 * Created by user on 05/10/2017.
 */

public class FirstStageFragment extends Fragment
{

    public static final String TAG = FirstStageFragment.class.getSimpleName();

    private View rootView;
    private CustomRecyclerView gameBoardRecyclerView;
    private TextView winningTextView;
    private TextView nextStageButton;
    private GameBoardRecyclerViewAdapter adapter;

    public static FirstStageFragment newInstance(Bundle bundle)
    {
        FirstStageFragment firstStageFragment = new FirstStageFragment();
        firstStageFragment.setArguments(bundle);
        return firstStageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_first_stage, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        rootView = view;

        gameBoardRecyclerView = (CustomRecyclerView) view.findViewById(R.id.game_board_recycler_view);
        winningTextView = (TextView) view.findViewById(R.id.winning_text_view);
        nextStageButton = (TextView) view.findViewById(R.id.next_stage_button);

        setAdpter();
    }

    private void setAdpter()
    {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        gameBoardRecyclerView.setLayoutManager(gridLayoutManager);

        adapter = new GameBoardRecyclerViewAdapter();
        gameBoardRecyclerView.setAdapter(adapter);
    }
}
