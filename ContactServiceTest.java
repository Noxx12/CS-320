package org.junit.jupiter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1", "Kelly", "Perez", "1234567890", "10 Main St");
        contactService.addContact(contact);
        Contact addedContact = contactService.getContact("1");
        Assertions.assertEquals(contact, addedContact);
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1", "Kelly", "Perez", "1234567890", "10 Main St");
        contactService.addContact(contact);
        contactService.deleteContact("1");
        Contact deletedContact = contactService.getContact("1");
        Assertions.assertNull(deletedContact);
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1", "Kelly", "Perez", "1234567890", "10 Main St");
        contactService.addContact(contact);
        contactService.updateContact("1", "Kelly", "Perez", "9876543210", "456 Elm St");
        Contact updatedContact = contactService.getContact("1");
        Assertions.assertEquals("Kelly", updatedContact.getFirstName());
        Assertions.assertEquals("Perez", updatedContact.getLastName());
        Assertions.assertEquals("9876543210", updatedContact.getPhone());
        Assertions.assertEquals("456 Elm St", updatedContact.getAddress());
    }
}