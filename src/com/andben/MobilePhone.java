package com.andben;

import java.util.ArrayList;

public class MobilePhone {
    private String myNum;
    private ArrayList<Contact> contactList;

    public MobilePhone(String myNum) {contact object or null
        this.myNum = myNum;
        this.contactList = new ArrayList<>();
    }

    /**
     * @param contact Contact
     * @return boolean
     */

    public boolean addContact(Contact contact) {
        if (findContact(contact) == -1) {
            this.contactList.add(contact);
            System.out.println("Addition successful");
            return true;
        }

        System.out.println("Name already exists in contacts, addition aborted");
        return false;
    }

    /**
     *
     * @param oldContact Contact
     * @param newContact Contact
     * @return boolean
     */

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);

        if (position >= 0) {
            this.contactList.set(position, newContact);
            System.out.println("Contact have been updated!");
            return true;
        } else {
            System.out.println("Sorry contact with name " + oldContact.getName() + " is not in phoneBook");
            return false;
        }
    }

    /**
     *
     * @param name String
     * @return Boolean
     */

    public boolean removeContact(String name) {
        int position = findContact(name);

        if (position >= 0) {
            this.contactList.remove(position);
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param name String
     * @return Contact or null if not found
     */


    public Contact searchContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.contactList.get(position);
        }

        return null;
    }


    /**
     * @param contact Contact
     * @return index or -1 if not found
     */

    private int findContact(Contact contact) {
        return this.contactList.indexOf(contact);
    }

    /**
     * Find contact return contact object or null
     * @param name String
     * @return contact object or null
     */

    private int findContact(String name) {
        for (int i = 0; i < this.contactList.size(); i++) {
            Contact contact = this.contactList.get(i);
            if (contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Prints all contact cards
     */

    public void printContacts() {
        for (int i = 0; i < this.contactList.size(); i++) {
            System.out.println("Name: " + this.contactList.get(i).getName());
            System.out.println("Phone: " + this.contactList.get(i).getPhone() + "\n");
        }
    }

    /**
     * Prints one contact card @Overloaded
     * @param contact
     */

    public void printContacts(Contact contact) {
            System.out.println("Name: " + contact.getName());
            System.out.println("Phone: " + contact.getPhone() + "\n");
    }
}

