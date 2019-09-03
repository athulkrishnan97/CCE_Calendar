package sema4.com.CCE_HOLISTIC_CALENDAR;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager pager;
    private ViewPagerAdapter adapter;
    private SlidingTabLayout tabs;
    private CharSequence titles[]= {"Calendar","Notifications","About Us"};
    private int numberOfTabs = 3;
    private static final String TAG = "MainActivity";
    boolean jumpToNotificationOnLaunch;

    //vars



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getSupportActionBar().setElevation(0);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        toolbar.setBackgroundColor(Color.parseColor("#FF1976D2"));

      ////////////////////////////////////////////////////////////
        Bundle b = getIntent().getExtras();
        try {

            //Check to see if the app was opened from an activity
            String goToNotification = b.getString("Go to Notification Tab");

            //Toast.makeText(getApplicationContext(),goToNotification,Toast.LENGTH_LONG).show();
            if(goToNotification.equals("true")){

            jumpToNotificationOnLaunch=true;

            }

        }

        catch (NullPointerException e){

            Log.d(TAG,"No Intent to pass");

            //Toast.makeText(getApplicationContext(),"Exception in indent passing",Toast.LENGTH_LONG).show();
        }

        catch (Exception e){

            Log.d(TAG,"Unknown exception at main activity intent passing");

        }

        //////////////////////////////////////////////////////////////////


        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter =  new ViewPagerAdapter(getSupportFragmentManager(), titles, numberOfTabs,1);



        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);



        //Checks to see whether the app was lunched from a notification. If so, jumps to the notification tab directly

        if(jumpToNotificationOnLaunch) {

            pager.setCurrentItem(1);

        }
        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);

        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width


        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.white);
            }

        });



        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }






}
