package com.example.potato.room_checkmate;
import android.test.suitebuilder.annotation.Suppress;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;

/**
 * Created by Christian on 11/20/2017.
 */
public class AlgMatch {

    public ArrayList<ArrayList<Integer>> matchUser(ArrayList<ArrayList<User>> UserLists){



        ArrayList<User> B = UserLists.get(0);
        ArrayList<User> G = UserLists.get(1);

        HashMap HashB = new HashMap<User, User>();
        HashMap HashG = new HashMap<User, User>();


        for (int i = 0; i < B.size(); i++){
            HashB.put(B.get(i), null);
        }


        int numCurrentlyMatched = 0;

            while (numCurrentlyMatched < B.size()) {

                for (int currentB = 0; currentB < B.size(); currentB++) {

                    User currentUserToBeMatched = B.get(currentB);

                    ArrayList<UserPreference> currentBPreferenceList = currentUserToBeMatched.getPreferenceList();

                    Log.d("Current B Preferences::", currentBPreferenceList.toString());

                    int nextMatchIndex = currentBPreferenceList.get(0).getIndex();

                    User nextMatch = G.get(currentBPreferenceList.get(0).getIndex());


                    if (HashB.get(currentUserToBeMatched) == null) {


                        if (!HashG.containsKey(nextMatch)) {
                            HashB.put(currentUserToBeMatched, nextMatch);
                            HashG.put(nextMatch, currentUserToBeMatched);
                            B.get(currentB).getPreferenceList().remove(0);
                            numCurrentlyMatched++;
                        }
                        else {
                            if (userDifference(currentUserToBeMatched, nextMatch) < userDifference((User) HashG.get(nextMatch), nextMatch)) {
                                B.get(currentB).getPreferenceList().remove(0);

                                //TODO
                                ((User) HashG.get(nextMatch)).getPreferenceList().remove(0);
                                HashB.put(HashG.get(nextMatch), null);
                                HashB.put(currentUserToBeMatched, nextMatch);
                                HashG.put(nextMatch, currentUserToBeMatched);

                            }
                            else {
                                B.get(currentB).getPreferenceList().remove(0);
                            }


                        }
                    }


                }
            }

            /*
        HashMap <User, User> combinedHash = new HashMap<>();
        combinedHash.putAll(HashB);
        combinedHash.putAll(HashG);


        for (int i = 0; i < 20; i++)
        {
            //Log.d("key: ", combinedHash.get(B.get(i)).toString());
            Log.d("key: ", B.get(i).toString());
            Log.d("value: ", combinedHash.get(B.get(i)).toString());
        }
        for (int i = 0; i < 20; i++)
        {
            //Log.d("key: ", combinedHash.get(B.get(i)).toString());
            Log.d("key: ", G.get(i).toString());
            Log.d("value: ", combinedHash.get(G.get(i)).toString());
        }

        return combinedHash;
*/
        ArrayList<ArrayList<Integer>> matches = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> matchedUser1 = new ArrayList<Integer>();
        ArrayList<Integer> matchedUser2 = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++){
            User currentUser = B.get(i);
            matchedUser1.add(i, currentUser.getId());
            matchedUser2.add(i, ((User)HashB.get(currentUser)).getId());
        } matches.add(matchedUser1);
        matches.add(matchedUser2);
        for (int i = 0; i < 20; i++){
            Log.d("User1: ", matches.get(0).get(i).toString());
            Log.d("User1's match: ", matches.get(1).get(i).toString());
        }
        return matches;

    }

    public int userDifference(User user1, User user2)
    {
        int difference = 0;
        for(int index = 0; index < 4; index++)
        {
            difference += abs(Character.getNumericValue (user1.getPrank().charAt(index))-
                    Character.getNumericValue(user2.getRankings().charAt(index)) ) +
                    abs(Character.getNumericValue (user2.getPrank().charAt(index))-
                            Character.getNumericValue(user1.getRankings().charAt(index)));
        }return difference;
    }

}
