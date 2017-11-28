package com.example.potato.room_checkmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import static com.example.potato.room_checkmate.Home.ACTIVE_USER;
import static com.example.potato.room_checkmate.UserPreference.differenceComparator;

public class CheckMatch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_match);
        //back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //title change
        this.setTitle("Check Match");

        /*
        DBHandler db = new DBHandler(this);
        User user = new User();
        User user2 = db.findUsername(user.toString());
        if(user2 != null) {
            Log.d("COMPARISON OF USERS", user.toString() + "\n" + user2.toString());
        }
        */

    }

    public void receiveMatch(View view){
        DBHandler db = new DBHandler(this);
        AlgMatch matchedAlg = new AlgMatch();
        ArrayList<ArrayList<User>> captureSplit;
        captureSplit = db.splitUsers(db.getAllUsers());

        TextView match_Username = (TextView) findViewById(R.id.matchUsername);
        TextView match_Email = (TextView) findViewById(R.id.matchEmail);
        TextView match_Prank = (TextView) findViewById(R.id.matchPrank);
        TextView user_Prank = (TextView) findViewById(R.id.userPrank);
        TextView match_Rank = (TextView) findViewById(R.id.matchRank);
        TextView user_Rank = (TextView) findViewById(R.id.userRank);




        for(int b = 0; b < captureSplit.get(0).size(); b++)
        {
            for(int g = 0; g < captureSplit.get(1).size(); g++)
            {
                captureSplit.get(0).get(b).preferenceList.add(db.setPreference(captureSplit,b,g));
            }
            Collections.sort(captureSplit.get(0).get(b).preferenceList,differenceComparator);
            Log.d("Preference List: ", captureSplit.get(0).get(b).preferenceList.toString());
        }

        //old = match.matchUser(captureSplit)
        @SuppressWarnings("Unchecked")
        ArrayList<ArrayList<Integer>> hashyMatchy = matchedAlg.matchUser(captureSplit);


        //Log.d("all values:: ", hashyMatchy.toString());
        Log.d("ACTIVE Username :: ", ACTIVE_USER.getUsername());

        //try {
            Log.d("active user tostr", ACTIVE_USER.toString());
            Log.d("Active Index: ", hashyMatchy.get(0).indexOf(ACTIVE_USER.getId())+"");
            User match = new User();

            if(hashyMatchy.get(0).indexOf(ACTIVE_USER.getId()) == -1) {

                match = db.findId(hashyMatchy.get(0).get(hashyMatchy.get(1).indexOf(ACTIVE_USER.getId())));
            }
            else

            {
                match = db.findId(hashyMatchy.get(1).get(hashyMatchy.get(0).indexOf(ACTIVE_USER.getId())));
            }
            Log.d("Match: ", match.toString());


        match_Username.setText("You've Matched With: " + match.getUsername());
        match_Email.setText("Match's Email: " + match.getEmail());
        match_Prank.setText("Match Prank: " + match.getPrank() + " vs ");
        user_Prank.setText("Your Prank: " + ACTIVE_USER.getPrank());
        match_Rank.setText("Match Rank: " + match.getRankings()+ " vs ");
        user_Rank.setText("Your Rank: " + ACTIVE_USER.getRankings());




        //}catch(NullPointerException npe){
            //Log.d("null pointer exception", "::balls.");
        //}
        /*
        //old bullshit

        DBHandler dbHandler = new DBHandler(this);
        User matchedUser;
        String pRankSearch = "";
        Random rand = new Random();
        TextView matchOut = (TextView) findViewById(R.id.matchDisplay);

        for (int index = 0; index < 4; index++) {
            pRankSearch += rand.nextInt(4) + 1;
        }

        Log.d("thePrank:", pRankSearch);
        //Log.d("currentUser", currentUser.toString())
        matchedUser = dbHandler.findPrank(pRankSearch);
        if(matchedUser != null) {
            //Log.d("found match", (dbHandler.findPrank(pRankSearch)).toString());
            //matchedUser = (dbHandler.findPrank(pRankSearch));
            //Log.d("search Return", matchedUser.getUsername());

            matchOut.setText("Youve matched with " + matchedUser.getUsername() + " !");
        }
        else{
            //Log.d("Error in user match","poop");

        }
        */

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




    /*
    public void checkMatchBack(View view){
        Intent startNewActivity = new Intent(this, LoginLandingMenu.class);
        startActivity(startNewActivity);
        this.overridePendingTransition(0, 0);
    }
    */

}
