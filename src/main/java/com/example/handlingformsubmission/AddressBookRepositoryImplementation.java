package com.example.handlingformsubmission;

import com.example.addressBook.AddressBook;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class AddressBookRepositoryImplementation {
    @PersistenceContext
    private EntityManager entityManager;

    public AddressBook getAddressBookFromId(long id) {
        Query query = entityManager.createQuery("SELECT * FROM AddressBook a WHERE id="+id);
        AddressBook addressBook = (AddressBook) query.getSingleResult();

        return addressBook;
    }
}
