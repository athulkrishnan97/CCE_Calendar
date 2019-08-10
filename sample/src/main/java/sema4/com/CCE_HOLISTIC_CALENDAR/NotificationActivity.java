package sema4.com.CCE_HOLISTIC_CALENDAR;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Bundle b = getIntent().getExtras();
        try {
            String title = b.getString("title");
            String body  = b.getString("body");

            Toast.makeText(getApplicationContext(),title,Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(),body,Toast.LENGTH_LONG).show();
        }

        catch (NullPointerException e){

            Toast.makeText(getApplicationContext(),"Exception",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onBackPressed() {

        Intent myIntent = new Intent(NotificationActivity.this, MainActivity.class);

        NotificationActivity.this.startActivity(myIntent);
        finish();

    }
}
