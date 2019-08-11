package sema4.com.CCE_HOLISTIC_CALENDAR;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;


public class Tab3 extends Fragment {

    private DatabaseReference myRef1;
    private ArrayList<String> dateArray = new ArrayList<>();
    private ArrayList<String> bodyArray = new ArrayList<>();
    private static final String TAG = "Tab3";
    private View v;
    private FirebaseDatabase database;
    RecyclerViewAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.tab_3,container,false);
        database = FirebaseDatabase.getInstance();
        myRef1 = database.getReference().child("notificationList");


        try {
            myRef1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    //String value = dataSnapshot.getValue(String.class);
                    // Log.d(TAG, "Value is: " + value);
                    //Toast.makeText(getContext(),value,Toast.LENGTH_LONG).show();
                    dateArray.clear();
                    bodyArray.clear();
                    collectDatesAndBody((Map<String, Object>) dataSnapshot.getValue());
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException());
                }
            });
        }

        catch (Exception e ){

            Toast.makeText(getContext(),"Exception in Notification Tab."+e.getMessage(),Toast.LENGTH_LONG).show();
            Log.w(TAG, "Exception in Notification Tab."+e.getMessage());

        }

        initRecyclerView();

        return v;

    }


    private void collectDatesAndBody(Map<String,Object> notificationList) {


    try {
    //iterate through each user, ignoring their UID
        for (Map.Entry<String, Object> entry : notificationList.entrySet()) {

            //Get user map
            Map singleUser = (Map) entry.getValue();
            //Get phone field and append to list
            dateArray.add((String) singleUser.get("date"));
            bodyArray.add((String) singleUser.get("body"));
        }
        }
        catch (Exception e){

        Toast.makeText(getContext(),"Could not parse database. Is your app updated?",Toast.LENGTH_LONG).show();

        }



        adapter.notifyDataSetChanged();

        System.out.println(dateArray.toString());
    }



//    private void initImageBitmaps(){
//
//
//
//
//
//        //bodyArray.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
//        dateArray.add("Havasu Falls");
//
//        //bodyArray.add("https://i.redd.it/tpsnoz5bzo501.jpg");
//        dateArray.add("Trondheim");
//
//        //bodyArray.add("https://i.redd.it/qn7f9oqu7o501.jpg");
//        dateArray.add("Portugal");
//
//        //bodyArray.add("https://i.redd.it/j6myfqglup501.jpg");
//        dateArray.add("Rocky Mountain National Park");
//
//
//       // bodyArray.add("https://i.redd.it/0h2gm1ix6p501.jpg");
//        dateArray.add("Mahahual");
//
//        //bodyArray.add("https://i.redd.it/k98uzl68eh501.jpg");
//        dateArray.add("Frozen Lake");
//
//
//       // bodyArray.add("https://i.redd.it/glin0nwndo501.jpg");
//        dateArray.add("White Sands Desert");
//
//        //bodyArray.add("https://i.redd.it/obx4zydshg601.jpg");
//        dateArray.add("Austrailia");
//
//        //bodyArray.add("https://i.imgur.com/ZcLLrkY.jpg");
//        dateArray.add("Washington");
//        dateArray.add("Puthenchira");
//
//
//    }


    private void initRecyclerView() {
        final FragmentActivity c = getActivity();

        final RecyclerView recyclerView = v.findViewById(R.id.recyclerv_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(c));


        new Thread(new Runnable() {
            @Override
            public void run() {
                adapter = new RecyclerViewAdapter(c, dateArray, bodyArray);
                adapter.notifyDataSetChanged();
                c.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        recyclerView.setAdapter(adapter);

                    }
                });
            }
        }).start();


    }




}
