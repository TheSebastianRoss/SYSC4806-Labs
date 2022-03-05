package com.example.accessingdatajpa;

import com.example.addressBook.BuddyInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan(basePackages = "addressBook")
public class AccessingDataJpaApplication {
    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);
/*
    public static void main(String[] args) {
        System.out.println("CP 1");
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }
*/
    /*
    @Bean
    public CommandLineRunner demo(AddressBookRepository repository) {
        return (args) -> {
            System.out.println("CP 2");
            // set up address books
            AddressBook wormsPlayers = new AddressBook();
            AddressBook tacosPlayers = new AddressBook();
            AddressBook badPlayers = new AddressBook();

            wormsPlayers.addBuddy(new BuddyInfo("Geraldine Hunt", "1-001"));
            wormsPlayers.addBuddy(new BuddyInfo("Zagreus Zetterling", "1-004"));
            wormsPlayers.addBuddy(new BuddyInfo("Billup Sprinter", "2-001"));
            wormsPlayers.addBuddy(new BuddyInfo("Yahya Jupiter", "2-002"));

            tacosPlayers.addBuddy(new BuddyInfo("Pat Manchego", "1-001"));
            tacosPlayers.addBuddy(new BuddyInfo("Gaal Pereira", "1-003"));
            tacosPlayers.addBuddy(new BuddyInfo("Hudson Hoarse", "1-006"));
            tacosPlayers.addBuddy(new BuddyInfo("Leather Gibson", "2-005"));

            badPlayers.addBuddy(new BuddyInfo("Gaal Pereira", "1-003"));
            badPlayers.addBuddy(new BuddyInfo("Hudson Hoarse", "1-006"));
            badPlayers.addBuddy(new BuddyInfo("Yahya Jupiter", "2-002"));
            badPlayers.addBuddy(new BuddyInfo("Leather Gibson", "2-005"));

            System.out.println("CP 3");

            // save a few address books
            repository.save(wormsPlayers);
            repository.save(tacosPlayers);
            repository.save(badPlayers);

            System.out.println("CP 4");

            // fetch all address books
            log.info("Address Books found with findAll():");
            log.info("-------------------------------");
            for (AddressBook playerContacts: repository.findAll()) {
                log.info(playerContacts.toString());
            }
            log.info("");

            // fetch an individual address book by ID
            AddressBook playerContacts = repository.findById(1L);
            log.info("Address Book found with findById(1L):");
            log.info("--------------------------------");
            log.info(playerContacts.toString());
            log.info("");
        };
    }
    */

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repository) {
        return (args) -> {
            // save a few buddies
            repository.save(new BuddyInfo("Wyatt Mason", "123", "townsville"));
            repository.save(new BuddyInfo("Jaylen Hotdogfingers", "14", "townsville"));
            repository.save(new BuddyInfo("Wyatt Mason", "456", "townsville"));
            repository.save(new BuddyInfo("Parker MacMillan", "1", "townsville"));
            repository.save(new BuddyInfo("Chorby Soul", "14", "townsville"));

            // fetch all buddies
            log.info("Buddies found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo buddy: repository.findAll()) {
                log.info(buddy.toString());
            }
            log.info("");

            // fetch an individual buddy by ID
            BuddyInfo buddy = repository.findById(1L);
            log.info("Buddy found with findById(1L):");
            log.info("--------------------------------");
            log.info(buddy.toString());
            log.info("");

            // fetch buddies by name
            log.info("Buddies found with findByName('Wyatt Mason'):");
            log.info("--------------------------------------------");
            repository.findByName("Wyatt Mason").forEach(wyatt -> {
                log.info(wyatt.toString());
            });
            log.info("");

            // fetch buddies by phone number
            log.info("Buddies found with findByPhoneNumber('14'):");
            log.info("--------------------------------------------");
            repository.findByPhoneNumber("14").forEach(fourteen -> {
                log.info(fourteen.toString());
            });
            log.info("");
        };
    }
}