package lesson_1;

public class User {
    String firstname;
    String lastname;

    String phoneNumber;
    int age;

    public void userDetails(){
        System.out.println(firstname + " " + lastname + " " + phoneNumber + " " + age);
    }

    public String firstnameToUpper(){
        return firstname.toUpperCase();
    }

    public String firstnameToLower(){
        return firstname.toLowerCase();
    }

    public String toString(){
        return firstname + " " + lastname + " " + phoneNumber + " " + age;
    }
}
