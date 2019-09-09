package sema4.com.CCE_HOLISTIC_CALENDAR;

import android.content.Context;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Handles updating the notification tab layout whenever a new notification is pushed
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mdate = new ArrayList<>();
    private ArrayList<String> mbody = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<String> date, ArrayList<String> body ) {
        this.mdate = date;
        this.mbody = body;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

//        Glide.with(mContext)
//                .asBitmap()
//                .load(mImages.get(position))
//                .into(holder.image);
        holder.image.setImageResource(R.drawable.cce);
        holder.date.setText(mdate.get(position));
        holder.body.setText(mbody.get(position));



        // Uncomment the below code to implement onclick functions in the recycler view on notifications tab


//        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d(TAG, "onClick: clicked on: " + mdate.get(position));
//
//                Toast.makeText(mContext, mdate.get(position), Toast.LENGTH_SHORT).show();
//
//
//                Intent intent = new Intent(mContext, GalleryActivity.class);
//                intent.putExtra("image_url", mbody.get(position));
//                intent.putExtra("image_name", mdate.get(position));
//                mContext.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mdate.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView date;
        TextView body;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            date = itemView.findViewById(R.id.date);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            body = itemView.findViewById(R.id.body);
        }
    }
}















