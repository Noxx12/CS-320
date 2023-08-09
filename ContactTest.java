package org.junit.jupiter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactCreation() {
        Contact contact = new Contact("1", "Kelly", "Perez", "1234567890", "10 Main St");

        Assertions.assertEquals("1", contact.getContactId());
        Assertions.assertEquals("Kelly", contact.getFirstName());
        Assertions.assertEquals("Perez", contact.getLastName());
        Assertions.assertEquals("1234567890", contact.getPhone());
        Assertions.assertEquals("10 Main St", contact.getAddress());
    }

    @Test
    public void testInvalidFirstName() {
        // Attempt to create a contact with a first name longer than 10 characters
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("2", "TestingANameLongerThanTenCharacters", "Perez", "1234567890", "10 Main St");
        });

        // Attempt to create a contact with a null first name
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("3", null, "Perez", "1234567890", "456 Elm St");
        });
    }

    @Test
    public void testInvalidLastName() {
        // Attempt to create a contact with a last name longer than 10 characters
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("4", "Kelly", "TestingANameLongerThanTenCharacters", "1234567890", "456 Elm St");
        });

        // Attempt to create a contact with a null last name
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("5", "Kelly", null, "1234567890", "789 Oak St");
        });
    }

    @Test
    public void testInvalidPhone() {
        // Attempt to create a contact with a phone number containing non-numeric characters
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("6", "Kelly", "Perez", "12a45b7890", "456 Elm St");
        });

        // Attempt to create a contact with a phone number shorter than 10 digits
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("7", "Kelly", "Perez", "123456789", "456 Elm St");
        });

        // Attempt to create a contact with a phone number longer than 10 digits
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("8", "Kelly", "Perez", "12345678901", "456 Elm St");
        });
    }

    @Test
    public void testInvalidAddress() {
        // Attempt to create a contact with an address longer than 30 characters
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("9", "Kelly", "Perez", "1234567890", "5142 TestingAddressThatsLongerThanThirtyCharacters");
        });

        // Attempt to create a contact with a null address
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("10", "Kelly", "Perez", "1234567890", null);
        });
    }
}
