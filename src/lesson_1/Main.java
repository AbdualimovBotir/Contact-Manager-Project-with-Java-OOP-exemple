package lesson_1;

public class Main {
    public static void main(String[] args) {

//        lesson_1.User foydalanuvchi = new lesson_1.User();
//        foydalanuvchi.firstname = "Javohir";
//        foydalanuvchi.lastname = "Davurov";
//        foydalanuvchi.age = 22;
//        foydalanuvchi.phoneNumber = "+998945283534";
//
//        System.out.println(foydalanuvchi.firstname + " " + foydalanuvchi.lastname + " " + foydalanuvchi.age + " " + foydalanuvchi.phoneNumber);
//
//        foydalanuvchi.lastname = "Davurov1";
//        foydalanuvchi.age = 30;
//        System.out.println(foydalanuvchi.firstname + " " + foydalanuvchi.lastname + " " + foydalanuvchi.age + " " + foydalanuvchi.phoneNumber);


        /**lesson_1.User user = new lesson_1.User();
        user.firstname = "test";//GC
        user.lastname = "testov";
        user.age = 4;
        user.phoneNumber = "9898988898";

        lesson_1.User user1 = new lesson_1.User();
        user1.firstname = "test1";
        user1.lastname = "testov1";
        user1.age = 5;
        user1.phoneNumber = "989898889887887";

        lesson_1.User user3 = new lesson_1.User();
        user3.firstname = "test3";
        user3.lastname = "testov3";
//        user3.age = 5;
        user3.phoneNumber = "9898988898";

        user.firstname = "test2";
        user1.lastname = "testov2";
        System.out.println(user.firstname + " " + user.lastname + " " + user.age + " " + user.phoneNumber);
        System.out.println(user1.firstname + " " + user1.lastname + " " + user1.age + " " + user1.phoneNumber);
        System.out.println(user3.firstname + " " + user3.lastname + " " + user3.age + " " + user3.phoneNumber);**/

        //class methodlari

//        test();
        User user = new User();
        user.firstname = "TEST";//GC
        user.lastname = "testov";
        user.age = 4;
        user.phoneNumber = "9898988898";

        User user1 = new User();
        user1.firstname = "test1";//GC
        user1.lastname = "testov1";
        user1.age = 9;
        user1.phoneNumber = "909099898988898";

        user.userDetails();
        user1.userDetails();

        System.out.println(user.firstnameToUpper());
        System.out.println(user.firstnameToLower());

        System.out.println(user.toString());
    }

//    public static void test(){

//    }
}