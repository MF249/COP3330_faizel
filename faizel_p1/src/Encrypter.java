import java.util.Arrays;

public class Encrypter {

    // convert string to char array
    public int[] stringToCharArray(String initial) {
        int[] intInputArr = new int[3];
        char[] charInputArr = initial.toCharArray();

        for (int i = 0; i < charInputArr.length; i++) {
            String temp = Character.toString(charInputArr[i]);
            intInputArr[i] = Integer.parseInt(temp);
        }
        return intInputArr;
    }

    // add 7 to int, divide by 10, get remainder
    public int[] add7Divide10Remainder(int[] intArr) {
        for (int i = 0; i < 4; i++) {
            intArr[i] = intArr[i] + 7;
            intArr[i] = intArr[i] % 10;
        }

        return intArr;
    }

    // swap first and third int, then second and fourth
    public int[] elementSwap(int[] intArr) {
        int temp1 = 0, temp2 = 0;
        intArr[2] = temp1;
        intArr[2] = intArr[0];
        intArr[0] = temp1;
        intArr[1] = temp2;
        intArr[1] = intArr[3];
        intArr[3] = temp2;

        return intArr;
    }


    // return encrypted array as string
    public String intArrayToString(int[] intArr) {
        String converted = Arrays.toString(intArr).replaceAll("\\[|\\]|,|\\s", "");
        return converted;
    }

    public String encrypt(String input) {
        int[] secondStep = stringToCharArray(input);
        System.out.println(secondStep);
        int[] thirdStep = add7Divide10Remainder(secondStep);
        System.out.println(thirdStep);
        int[] fourthStep = elementSwap(thirdStep);
        System.out.println(fourthStep);
        String last = intArrayToString(fourthStep);
        System.out.println(last);

        return last;
    }



}
