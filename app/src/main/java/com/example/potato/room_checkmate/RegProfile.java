package com.example.potato.room_checkmate;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class RegProfile extends AppCompatActivity {

    private SeekBar cleanSeekbar;
    private TextView cleanProgressTextView;
    private SeekBar timeSeekbar;
    private TextView timeProgressTextView;
    private SeekBar socialSeekbar;
    private TextView socialProgressTextView;
    private SeekBar soundSeekbar;
    private TextView soundProgressTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_profile);



        //seek bar captures


        cleanSeekbar = (SeekBar) findViewById(R.id.cleanBar);
        cleanProgressTextView = (TextView) findViewById(R.id.cleanPrank);
        cleanSeekbar.setMax(4);
        cleanSeekbar.setProgress(0);

        // perform seek bar change listener event used for getting the progress value
        cleanSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                               int progressChangedValue = 0;
                                               public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                                   progressChangedValue = progress;
                                               }
                                               public void onStartTrackingTouch(SeekBar seekBar) {
                                                   // TODO Auto-generated method stub
                                               }
                                               public void onStopTrackingTouch(SeekBar seekBar) {
                                                   cleanProgressTextView.setText("Cleanliness - "+(progressChangedValue+1));
                                               }
        });


        timeSeekbar = (SeekBar) findViewById(R.id.timeBar);
        timeProgressTextView = (TextView) findViewById(R.id.timePrank);
        timeSeekbar.setMax(4);
        timeSeekbar.setProgress(0);

        // perform seek bar change listener event used for getting the progress value
        timeSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            public void onStopTrackingTouch(SeekBar seekBar) {
                timeProgressTextView.setText("\n\nHours of Activity - "+(progressChangedValue+1));
            }
        });

        socialSeekbar = (SeekBar) findViewById(R.id.socialBar);
        socialProgressTextView = (TextView) findViewById(R.id.socialPrank);
        socialSeekbar.setMax(4);
        socialSeekbar.setProgress(0);

        // perform seek bar change listener event used for getting the progress value
        socialSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            public void onStopTrackingTouch(SeekBar seekBar) {
                socialProgressTextView.setText("\n\nSociability - "+(progressChangedValue+1));
            }
        });

        soundSeekbar = (SeekBar) findViewById(R.id.soundBar);
        soundProgressTextView = (TextView) findViewById(R.id.soundPrank);
        soundSeekbar.setMax(4);
        soundSeekbar.setProgress(0);

        // perform seek bar change listener event used for getting the progress value
        soundSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            public void onStopTrackingTouch(SeekBar seekBar) {
                soundProgressTextView.setText("\n\nSound Levels - "+(progressChangedValue+1));
            }
        });










        // SPINNER STUFF
        Spinner spinner = (Spinner) findViewById(R.id.prankSpin);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.prefPrank, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


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
            Home.ACTIVE_USER = user2;
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
