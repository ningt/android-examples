package me.tangning.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by tang on 20/8/15.
 */
public class FirstActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // method 1: pass data to second activity and get data from second activity
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_data", "Hello Second Activity");
                startActivityForResult(intent, 1);

                // method 2
                // Intent intent = new Intent("me.tangning.intentdemo.ACTION_START");
                // startActivity(intent);

                // Intent intent = new Intent(Intent.ACTION_VIEW);
                // intent.setData(Uri.parse("https://google.com"));
                // startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Log.d("First Activity", data.getStringExtra("data_return"));
                }
                break;
            default:
        }
    }
}
