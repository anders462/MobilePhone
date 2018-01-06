package com.andben;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone phoneContacts = new MobilePhone("415-810-1249");


    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;

        printInstructions();

        while (!quit) {
            System.out.println("Enter your choice:\r");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    printPhoneContactList();
                    break;
                case 2:
                    addToPhoneContact();
                    break;
                case 3:
                    modifyPhoneContact();
                    break;
                case 4:
                    removePhoneContact();
                    break;
                case 5:
                    searchPhoneContacts();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
            }
        }
        System.out.println("Good bye!");
    }

    private static void printInstructions() {
        System.out.println("\nEnter ");
        System.out.println("\t 0 - Print instructions.");
        System.out.println("\t 1 - Print Contacts.");
        System.out.println("\t 2 - Add contact.");
        System.out.println("\t 3 - Modify contact info.");
        System.out.println("\t 4 - Remove contact.");
        System.out.println("\t 5 - Find contact.");
        System.out.println("\t 6 - Exit.");
    }


    private static void printPhoneContactList() {
        phoneContacts.printContacts();
    }

    private static void addToPhoneContact() {
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter phone number");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if (phoneContacts.addContact(newContact)) {
            System.out.println("Contact added");
        } else {
            System.out.println("Contact exists");
        }
    }

    private static void modifyPhoneContact() {
        System.out.println("Which contact do you want to change?");
        String name = scanner.nextLine();
        Contact oldContact = phoneContacts.searchContact(name);

        if (oldContact == null) {
            System.out.println("No such contact");
            return;
        }

        phoneContacts.printContacts(oldContact);
        System.out.println("Enter new name");
        String newName = scanner.nextLine();
        System.out.println("Enter new phone number");
        String newPhone = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newPhone);
        phoneContacts.updateContact(oldContact, newContact);
        System.out.println("Contact modified");
    }

    private static void removePhoneContact() {
        System.out.println("Enter name to remove");
        String name = scanner.nextLine();
        if (phoneContacts.removeContact(name)) {
            System.out.println("Deletion successful");
        } else {
            System.out.println("Name not found, deletion aborted");
        }
    }

    private static void searchPhoneContacts() {
        System.out.println("Enter name to find");
        String name = scanner.nextLine();
        Contact contact = phoneContacts.searchContact(name);
        if (contact == null) {
            System.out.println("No such contact exist");
            return;
        }
        phoneContacts.printContacts(contact);
    }

}
