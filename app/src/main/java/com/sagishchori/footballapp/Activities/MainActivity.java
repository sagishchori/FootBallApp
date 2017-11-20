package com.sagishchori.footballapp.Activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.sagishchori.footballapp.Fragments.AboutFragment;
import com.sagishchori.footballapp.Fragments.HomeFragment;
import com.sagishchori.footballapp.Models.MenuItemDataModel;
import com.sagishchori.footballapp.Fragments.PersonalInfoFragment;
import com.sagishchori.footballapp.R;
import com.sagishchori.footballapp.CustomViews.SelectableLinearLayout;

import java.util.ArrayList;

public class MainActivity extends MainApplicationActivity implements SelectableLinearLayout.OnItemSelectedListener
{
    public static final String HOME_TAB = "HOME_TAB";
    public static final String PERSONAL_INFO_TAB = "PERSONAL_INFO_TAB";
    public static final String ABOUT_TAB = "ABOUT_TAB";

    public static final String EXTRA_ACTION_TAB_SELECTION = "EXTRA_ACTION_TAB_SELECTION";

    private TextView mTextMessage;
    private FrameLayout frameLayout;

    /**
     * Show the requested {@link Fragment} according to user selection
     * @param whichTab  Which navigation tab the user selected
     */
    private void showFragment(String whichTab)
    {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        Fragment fragment = getFragment(whichTab, fragmentManager);
        String fragmentTag = getFragmentTag(whichTab);

        if (fragment == null || fragmentTag == null)
            return;

        transaction.replace(frameLayout.getId(), fragment, fragmentTag).commit();
    }

    /**
     * Get the TAG of the requested {@link Fragment}
     * @param whichTab  The navigation tab the user selected
     * @return          The {@link Fragment}'s TAG
     */
    private String getFragmentTag(String whichTab)
    {
        switch (whichTab)
        {
            case HOME_TAB:
                return HomeFragment.TAG;

            case PERSONAL_INFO_TAB:
                return PersonalInfoFragment.TAG;

            case ABOUT_TAB:
                return AboutFragment.TAG;
            default:
                return null;
        }
    }

    /**
     * Get the requested {@link Fragment}. If the {@link Fragment} != null return it, otherwise return newInstance() of it
     * @param whichTab          Which navigation tab the user selected
     * @param fragmentManager
     * @return                  The requested {@link Fragment}
     */
    private Fragment getFragment(String whichTab, FragmentManager fragmentManager)
    {
        Bundle bundle = null;
        switch (whichTab)
        {
            case HOME_TAB:
                HomeFragment homeFragment;
                if ((homeFragment = (HomeFragment) fragmentManager.findFragmentByTag(HomeFragment.TAG)) != null)
                    return homeFragment;
                else
                    return HomeFragment.newInstance(bundle);

            case PERSONAL_INFO_TAB:
                PersonalInfoFragment personalInfoFragment;
                if ((personalInfoFragment = (PersonalInfoFragment) fragmentManager.findFragmentByTag(PersonalInfoFragment.TAG)) != null)
                    return personalInfoFragment;
                else
                    return PersonalInfoFragment.newInstance(bundle);

            case ABOUT_TAB:
                AboutFragment aboutFragment;
                if ((aboutFragment = (AboutFragment) fragmentManager.findFragmentByTag(AboutFragment.TAG)) != null)
                    return aboutFragment;
                else
                    return AboutFragment.newInstance(bundle);
            default:
                return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        SelectableLinearLayout linearLayout = (SelectableLinearLayout) findViewById(R.id.menu_bottom_bar);
        linearLayout.setOnItemSelectedListener(this);
        linearLayout.setMenuItemsToView(getMenuItemsList());

        frameLayout = (FrameLayout) findViewById(R.id.content);

        // TODO: This will need to change once a sign in screen will be applied
        if (getIntent().getExtras() != null && getIntent().getExtras().containsKey(EXTRA_ACTION_TAB_SELECTION))
            showFragment(getIntent().getExtras().getString(EXTRA_ACTION_TAB_SELECTION, HOME_TAB));
        else
            showFragment(HOME_TAB);
    }

    @Override
    protected int getViewResourceId()
    {
        return R.layout.activity_main;
    }

    /**
     * A method to get the Menu items list which the bottom navigation bar will be build upon
     * @return  The {@link MenuItemDataModel} {@link ArrayList}
     */
    private ArrayList<MenuItemDataModel> getMenuItemsList()
    {
        ArrayList<MenuItemDataModel> list = new ArrayList<>();

        int[] drawableResources = new int[]{R.drawable.ic_home, R.drawable.ic_person_outline, R.drawable.ic_info};
        int[] stringResources = new int[]{R.string.title_home, R.string.title_personal_info, R.string.title_about};
        String[] tagArray = new String[]{HOME_TAB, PERSONAL_INFO_TAB, ABOUT_TAB};

        for (int i = 0; i < drawableResources.length; i++) {
            MenuItemDataModel model = new MenuItemDataModel();

            model.setTag(tagArray[i]);
            model.setDrawableResource(drawableResources[i]);
            model.setStringResource(stringResources[i]);

            list.add(model);
        }

        return list;
    }

    @Override
    public void onItemSelected(String itemTag) {
        showFragment(itemTag);
    }
}
