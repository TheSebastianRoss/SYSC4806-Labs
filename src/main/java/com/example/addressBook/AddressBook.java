package com.example.addressBook;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany
    private List<BuddyInfo> buddies;

    public AddressBook() {
        this.buddies = new ArrayList<>();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumBuddies() {
        return this.buddies.size();
    }

    public void addBuddy(BuddyInfo buddy) {
        this.buddies.add(buddy);
    }

    public BuddyInfo getBuddyAtIndex(int index) {
        return this.buddies.get(index);
    }

    public List<BuddyInfo> getBuddies() {
        return this.buddies;
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    @Override
    public String toString() {
        return "AddressBook.AddressBook{" +
                "buddies=" + buddies +
                '}';
    }

    public static void main(String[] args) {
        AddressBook myFriends = new AddressBook();
        BuddyInfo buddy1 = new BuddyInfo("Wyatt Mason", "424-555-5425", "townsville");
        BuddyInfo buddy2 = new BuddyInfo("Lee Davenport", "424-555-6786", "townsville");
        BuddyInfo buddy3 = new BuddyInfo("Taiga Quitter", "424-555-6389", "townsville");
        BuddyInfo buddy4 = new BuddyInfo("Wanda Pothos", "424-555-7836", "townsville");

        myFriends.addBuddy(buddy1);
        myFriends.addBuddy(buddy2);
        myFriends.addBuddy(buddy3);
        myFriends.addBuddy(buddy4);

        System.out.println(myFriends);
    }
}
