package com.example.handlingformsubmission;

import com.example.accessingdatajpa.AddressBookRepository;
import com.example.addressBook.AddressBook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddressBookController {
    private AddressBookRepository addressBooks;

    @GetMapping("/addressBook")
    public String addressBookForm(Model model) {
        model.addAttribute("addressBook", new AddressBook());
        return "addressBook";
    }

    @PostMapping("/addressBook")
    public String addressBookSubmit(@ModelAttribute AddressBook addressBook, Model model) {
        model.addAttribute("addressBook", addressBook);
        return "resultAddressBook";
    }

}