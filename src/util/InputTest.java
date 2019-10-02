package util;

public class InputTest {
    public static void main(String[] args) {

        util.Input keyboard2 = new util.Input();

//
//        System.out.println(keyboard2.getString(""));
//        System.out.println(keyboard2.getString("Hello again"));
//
//        //System.out.println(keyboard2.yesNo());
//
//        System.out.println(keyboard2.yesNo("Hello again, hello"));
//
//        System.out.println(keyboard2.getInt("Please enter a number between 1 and 10", 1, 10));
//
      // System.out.println(keyboard2.getInt("Test integer"));

//        double dblNumber =  keyboard2.getDouble("", 1, 10);
//
//        System.out.println(dblNumber);

        System.out.println(keyboard2.binaryToInteger());
        System.out.println(keyboard2.hexadecimalToInteger());

        //System.out.println(keyboard2.getDouble());
    }
}
