public class StringPatternsDemo {

    public static void main(String[] args) {

        String name = "Zubair";
        String nameRegex = "[A-Z][a-z]{1,}";
        System.out.println(name.matches(nameRegex));

        String mobile = "9876543210";
        String mobileRegex = "[6-9][0-9]{9}";
        System.out.println(mobile.matches(mobileRegex));

        String email = "zubair@mail.com";

    }
}
