package sema4.com.CCE_HOLISTIC_CALENDAR;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
 /**
    Handles the display of  tab titles on the top of the app.
 **/
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence titles[];
    int numbOfTabs;
    int showNotificationTab;


    public ViewPagerAdapter(FragmentManager fm, CharSequence titles[], int mNumbOfTabs, int showNotificationTab ) {
        super(fm);
        this.titles = titles;
        this.numbOfTabs = mNumbOfTabs;
        this.showNotificationTab = showNotificationTab;
    }




    @Override
    public Fragment getItem(int position) {

//        if(showNotificationTab==1){
//
//           position=1;
//            showNotificationTab=0;
//        }

        if (position == 0) {
            CompactCalendarTab compactCalendarTab = new CompactCalendarTab();
            return compactCalendarTab;
        }

        else {
            Tab3 tab3 = new Tab3();

            return tab3;
        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        return numbOfTabs;
    }
}