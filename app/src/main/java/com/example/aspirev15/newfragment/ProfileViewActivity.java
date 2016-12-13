package com.example.aspirev15.newfragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class ProfileViewActivity extends AppCompatActivity {
    TextView txtName;
    TextView txtAddress;
    TextView txtPhone;
    SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);
        txtAddress = (TextView) findViewById(R.id.txtAddress);
        txtName = (TextView) findViewById(R.id.txtName);
        txtPhone = (TextView) findViewById(R.id.txtPhone);
        mSharedPreferences=getSharedPreferences(SharePreferenceExampleActivity.USER_PROFILE,MODE_PRIVATE);
        txtAddress.setText("Address : "+mSharedPreferences.getString("address",""));
        txtName.setText("Name : "+mSharedPreferences.getString("name",""));
        txtPhone.setText("Phone : "+mSharedPreferences.getString("phone","9845"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_profile, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuEdit:
                Intent i = new Intent(ProfileViewActivity.this, SharePreferenceExampleActivity.class);
                startActivityForResult(i, 101);

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("Request code", requestCode + "");
        Log.e("Result code", resultCode + "");
        if (resultCode == RESULT_OK && requestCode == 101) {
            String name=data.getStringExtra(SharePreferenceExampleActivity.NAME);
            String address=data.getStringExtra("address");
            String phone=data.getStringExtra("phone");
            txtName.setText("Name : "+name);
            txtPhone.setText("Phone : "+phone);
            txtAddress.setText("Address : "+address);
        }
    }
}
