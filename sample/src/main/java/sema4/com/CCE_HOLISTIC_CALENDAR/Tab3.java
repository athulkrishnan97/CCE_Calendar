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
import com.google.firebase.database.ValueEventListener;
import java.util.Arrays;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

/**
This is the notification tab
**/
public class Tab3 extends Fragment {

    private DatabaseReference myRef1;
    private ArrayList<String> dateArrayList = new ArrayList<>();
    private ArrayList<String> bodyArrayList = new ArrayList<>();
    private ArrayList<NotificationObject> notificationObjectsArrayList = new ArrayList<>();
    private static final String TAG = "Tab3";
    private View v;
    private FirebaseDatabase database;
    RecyclerViewAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.tab_3,container,false);

        //Gets the online database
        database = FirebaseDatabase.getInstance();
        myRef1 = database.getReference().child("notificationList");


        try {
            myRef1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.

                    dateArrayList.clear();
                    bodyArrayList.clear();
                    notificationObjectsArrayList.clear();
                    collectDatesAndBody((Map<String, Object>) Objects.requireNonNull(dataSnapshot.getValue()));

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
            //Toast.makeText(getContext(),""+Integer.parseInt((String)singleUser.get("order")),Toast.LENGTH_LONG).show();
            if ((String)singleUser.get("order")!=null) {
                notificationObjectsArrayList.add(new NotificationObject(Integer.parseInt((String) singleUser.get("order")), (String) singleUser.get("date"), (String) singleUser.get("body")));
            }

        }

        NotificationObject[] notificationObjectsArray=new NotificationObject[(notificationObjectsArrayList.size())];
        notificationObjectsArrayList.toArray(notificationObjectsArray);


        //The below block of code sorts the notification list in the notification tab
        Arrays.sort(notificationObjectsArray, new Comparator<NotificationObject>(){
            @Override
            public int compare(NotificationObject noti_1, NotificationObject noti_2){
                return noti_2.order - noti_1.order;
            }
        });

        for(NotificationObject i:notificationObjectsArray){
            dateArrayList.add(i.date);
            bodyArrayList.add(i.body);

        }

    }
        catch (NullPointerException e){

        Toast.makeText(getContext(),"Could not parse database. Is your app updated?",Toast.LENGTH_LONG).show();

        }



        adapter.notifyDataSetChanged();


    }



//    private void initImageBitmaps(){
//
//
//
//
//
//        //bodyArrayList.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
//        dateArrayList.add("Havasu Falls");
//
//
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
                adapter = new RecyclerViewAdapter(c, dateArrayList, bodyArrayList);
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
