package com.example.addressBook;

import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    @Test
    public void getName() {
        BuddyInfo buddy1 = new BuddyInfo("Michelle Sportsman", "424-555-8637", "townsville");

        assertEquals("Michelle Sportsman", buddy1.getName());
    }

    @Test
    public void getNumber() {
        BuddyInfo buddy1 = new BuddyInfo("Yummy Elliot", "424-555-7475", "townsville");

        assertEquals("424-555-7475", buddy1.getPhoneNumber());
    }

    @Test
    public void getAddress() {
        BuddyInfo buddy1 = new BuddyInfo("Games Pergame", "555-555-5555", "society");

        assertEquals("society", buddy1.getAddress());
    }
}
