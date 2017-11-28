package com.example.potato.room_checkmate;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void equal()
    {
        User user1 = new User();
        User user2 = new User();
        user1.setZip("90808");

        user2.setZip("90808");


        assertTrue(user1.equals(user2));
    }
    @Test
    public void notEqual()
    {
        User user1 = new User();
        User user2 = new User();
        user1.setZip("90808");

        user2.setZip("770707");


        assertFalse(user1.equals(user2));
    }

}