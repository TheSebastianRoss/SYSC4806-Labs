package com.example.handlingformsubmission;

import com.example.addressBook.AddressBook;
import com.example.addressBook.BuddyInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BuddyInfoController {

    @GetMapping("/buddyInfo/{id}")
    public String buddyInfoForm(Model model, @PathVariable long id) {
        AddressBook addressBook;
        AddressBookRepositoryImplementation repo = new AddressBookRepositoryImplementation();
        try{
            addressBook = repo.getAddressBookFromId(id);
        } catch(Exception e) {
            System.out.println(e);
            addressBook = new AddressBook();
            addressBook.setId(id);
        }
        BuddyInfo buddy = new BuddyInfo();
        addressBook.addBuddy(buddy);
        model.addAttribute("buddyInfo", buddy);
        return "buddyInfo";
    }

    @GetMapping("/buddyInfo/{id}")
    public String buddyInfoForm(Model model) {
        BuddyInfo buddy = new BuddyInfo();
        model.addAttribute("buddyInfo", buddy);
        return "buddyInfo";
    }

    @PostMapping("/buddyInfo")
    public String buddyInfoSubmit(@ModelAttribute BuddyInfo buddyInfo, Model model) {
        AddressBook addressBook;
        AddressBookRepositoryImplementation repo = new AddressBookRepositoryImplementation();
        model.addAttribute("buddyInfo", buddyInfo);
        return "resultBuddyInfo";
    }

}