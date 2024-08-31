package lesson_2;

public class Contact {
    String firstName;
    String lastName;
    String phoneNumber;
    boolean isActive;

    public int testTrim(){
        return phoneNumber.trim().length();
    }

    public static void main(String[] args) {
        Contact contact = new Contact();
        System.out.println(contact.testTrim());
    }
}
