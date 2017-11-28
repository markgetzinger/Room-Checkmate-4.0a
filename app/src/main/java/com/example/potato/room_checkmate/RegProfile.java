package com.example.potato.room_checkmate;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class RegProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_profile);

        //back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //title change
        this.setTitle("Profile Information");

    }

    //back button process
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home){
            // activity end
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }


    public void Reg2Fin(View view){

        Bundle extras = getIntent().getExtras();
        //EditText regName = (EditText)findViewById(R.id.regUserName);
        //EditText regEm = (EditText)findViewById(R.id.regEmail);
        //EditText regPass = (EditText)findViewById(R.id.regPW);
        //EditText regRepPass = (EditText)findViewById(R.id.regRPW);
        EditText profFirstName = (EditText)findViewById(R.id.firstName);
        EditText profLastName = (EditText)findViewById(R.id.lastName);
        EditText profAddress = (EditText)findViewById(R.id.regAddress);
        EditText profCity = (EditText)findViewById(R.id.regCity);
        EditText profState = (EditText)findViewById(R.id.regState);
        EditText profZip = (EditText)findViewById(R.id.regZip);
        EditText profPhone = (EditText)findViewById(R.id.regPhone);

        //String userName = regName.getText().toString();
        // use value  = extras.getString();
        //String userEmail = regEm.getText().toString();
        // use value  = extras.getString();
        //String userPassword = regPass.getText().toString();
        // use value  = extras.getString();
        //String userRetype = regRepPass.getText().toString();
        // use value  = extras.getString();
        String userFirstName = profFirstName.getText().toString();
        String userLastName = profLastName.getText().toString();
        String userAddress = profAddress.getText().toString();
        String userCity = profCity.getText().toString();
        String userState = profState.getText().toString();
        String userZip = profZip.getText().toString();
        String userPhone = profPhone.getText().toString();

        //add regex / input validation

            //send all data to the database

            User user = new User();
            user.setUsername(extras.getString("RegLandUserName"));
            user.setPassword(extras.getString("RegLandPassword"));
            user.setEmail(extras.getString("RegLandEmail"));
            user.setFirst_name(userFirstName);
            user.setLast_name(userLastName);
            user.setAddress(userAddress);
            user.setCity(userCity);
            user.setState(userState);
            user.setZip(userZip);
            user.setPhone(userPhone);


        //add user to db
        DBHandler db = new DBHandler(this);
        db.insertNewUser(user);

        //user was inserted into database, make sure its there before continuing
        User user2 = db.findUsername(user.getUsername());
        if(user2 != null) {
            Intent startNewActivity = new Intent(this, LoginLandingMenu.class);
            startActivity(startNewActivity);
            this.overridePendingTransition(0, 0);
        }
    }

    /*
    public void Reg2Back(View view){
        Intent startNewActivity = new Intent(this, RegLand.class);
        startActivity(startNewActivity);
        this.overridePendingTransition(0, 0);
    }
    */
}
