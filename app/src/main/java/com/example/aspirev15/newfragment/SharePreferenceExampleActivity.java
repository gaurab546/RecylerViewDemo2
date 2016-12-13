package com.example.aspirev15.newfragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharePreferenceExampleActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String NAME="name";
    EditText etName;
    EditText etAddress;
    EditText etPhone;
    Button btnSave;

    SharedPreferences mSharedPreferences;
    public static final String USER_PROFILE = "profile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preference_example);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etName = (EditText) findViewById(R.id.etName);
        etAddress = (EditText) findViewById(R.id.etAddress);
        etPhone = (EditText) findViewById(R.id.etPhone);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        mSharedPreferences = getSharedPreferences(USER_PROFILE, MODE_PRIVATE);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if (isFormValid())
            saveUserInfo();

    }

    private boolean isFormValid() {
        if (TextUtils.isEmpty(etName.getText().toString())) {
            etName.setError("Name can't be empty");
            return false;
        }
        if (TextUtils.isEmpty(etAddress.getText().toString())) {
            etAddress.setError("Address can't be empty");
            return false;
        }
        if (TextUtils.isEmpty(etPhone.getText().toString())) {
            etPhone.setError("phone can't be empty");
            return false;
        }

        return true;
    }

    private void saveUserInfo() {
        String name=etName.getText().toString();
        String address=etAddress.getText().toString();
        String phone=etPhone.getText().toString();

        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putString("phone", phone);
        mEditor.putString("address",address);
        mEditor.putString("name",name);
        mEditor.commit();
        Toast.makeText(this, "Profile Successfully Saved", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent();
        intent.putExtra(NAME,name);
        intent.putExtra("address",address);
        intent.putExtra("phone",phone);
        setResult(RESULT_OK,intent);
        finish();
    }
}
