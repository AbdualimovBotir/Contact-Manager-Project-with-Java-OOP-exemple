package lesson_2;

import java.util.Scanner;
public class Main {
    int contactCount = 0;
    Contact[] contacts = new Contact[20];
    public static void main(String[] args) {
        Main main = new Main();
        while (true){
            menu();
            int menuNumber = getMenuNumber();

            switch (menuNumber){
                case 1:
                    Contact contact = addContact();
                    boolean isValidContact = isValidContact(contact);
                    if (isValidContact) {
                        main.addContactToList(contact);
                        System.out.println(contact.firstName + " " + contact.lastName + " "
                                + contact.phoneNumber + " " + contact.isActive);
                    }
                    break;
                case 2:
                    main.updateContact();
                    break;
                case 3:
                    main.showContacts();
                    break;
                case 4:
                    main.searchContacts();
                    break;
                case 5:
                    main.deleteContact();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }

    public static void menu(){
        System.out.println("** MENU **");
        System.out.println();
        System.out.println("1. Add Contact");
        System.out.println("2. Update Contact");
        System.out.println("3. Contact list");
        System.out.println("4. Search ");
        System.out.println("5. Delete Contact (by phone)");
        System.out.println("6. Exit");
    }

    public static int getMenuNumber(){
        System.out.print("Choose one of the fallowing menu: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static Contact addContact(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter firstname: ");
        String firstname = scanner.next();

        System.out.print("Enter lastname: ");
        String lastname = scanner.next();

        //+99895283534
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.next();

        System.out.print("Enter phone active: ");
        boolean isActive = scanner.nextBoolean();

        Contact contact = new Contact();
        contact.firstName = firstname;
        contact.lastName = lastname;
        contact.phoneNumber = phoneNumber;
        contact.isActive = isActive;

        return contact;
    }

    public static boolean isValidContact(Contact contact){
        if (contact.firstName == null || contact.firstName.length() <= 3){
            System.out.println("Contact firstname is wrong!");
            return false;
        }

        if (contact.lastName == null || contact.lastName.length() <= 3){
            System.out.println("Contact lastname is wrong!");
            return false;
        }

        //+99895283534 //12 ta digit

        if (contact.phoneNumber == null || contact.phoneNumber.trim().length() != 12
            || !contact.phoneNumber.startsWith("998")){
            System.out.println("Contact phone number is wrong!");
            return false;
        }

        if (!contact.isActive){
            System.out.println("Contact active is black list");
            return false;
        }

        //+99894528353a
        char[] phoneNumberArray = contact.phoneNumber.toCharArray();//[+,9,9,8,9,4,5,2,8,3,5,3,a]
        for (char a : phoneNumberArray){
            if (!Character.isDigit(a)){
                System.out.println("Contact phone is wrong");
                return false;
            }
        }
        return true;
    }
    private void addContactToList(Contact contact) {
        if (contactCount < contacts.length) {
            contacts[contactCount++] = contact;
        } else {
            System.out.println("Contact list is full.");
        }
    }

    private void updateContact() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter phone number of contact to update: ");
        String phoneNumber = scanner.nextLine();

        Contact contact = findContactByPhoneNumber(phoneNumber);
        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.print("Enter new firstname: ");
        String firstname = scanner.nextLine();

        System.out.print("Enter new lastname: ");
        String lastname = scanner.nextLine();

        System.out.print("Enter new phone number: ");
        String newPhoneNumber = scanner.nextLine();

        System.out.print("Enter new active status (true/false): ");
        boolean isActive = scanner.nextBoolean();

        // Update contact details
        contact.firstName = firstname;
        contact.lastName = lastname;
        contact.phoneNumber = newPhoneNumber;
        contact.isActive = isActive;

        System.out.println("Contact updated successfully.");
    }

    private Contact findContactByPhoneNumber(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact != null && contact.phoneNumber.equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    private void showContacts() {
        for (Contact contact : contacts) {
            if (contact != null) {
                System.out.println(contact.firstName + " " + contact.lastName + " "
                        + contact.phoneNumber + " " + contact.isActive);
            }
        }
    }

    private void searchContacts() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter search term (firstname, lastname, phone number, active): ");
        String term = scanner.nextLine();

        for (Contact contact : contacts) {
            if (contact != null && (contact.firstName.contains(term) ||
                    contact.lastName.contains(term) ||
                    contact.phoneNumber.contains(term) ||
                    Boolean.toString(contact.isActive).contains(term))) {
                System.out.println(contact.firstName + " " + contact.lastName + " "
                        + contact.phoneNumber + " " + contact.isActive);
            }
        }
    }

    private void deleteContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter phone number of contact to delete: ");
        String phoneNumber = scanner.nextLine();

        Contact contact = findContactByPhoneNumber(phoneNumber);
        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        for (int i = 0; i < contactCount; i++) {
            if (contacts[i].phoneNumber.equals(phoneNumber)) {
                contacts[i] = contacts[contactCount - 1];
                contacts[contactCount - 1] = null;
                contactCount--;
                break;
            }
        }
        System.out.println("Contact deleted successfully.");
    }

}
