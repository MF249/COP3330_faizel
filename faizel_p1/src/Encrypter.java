import java.util.Arrays;

public class Encrypter {

    public int[] stringToCharArray(String initial) {
        // use toCharArray() to convert int array to chars
        int[] intInputArr = new int[] {0, 0, 0, 0};
        char[] charInputArr = initial.toCharArray();

        // use for loop to parseInt() each array element
        for (int i = 0; i < 4; i++) {
            String temp = Character.toString(charInputArr[i]);
            intInputArr[i] = Integer.parseInt(temp);
        }
        //System.out.println(intInputArr);
        return intInputArr;
    }


    public int[] add7Divide10Remainder(int[] intArr) {

        // use for loop to do calculations to each array element
        for (int i = 0; i < 4; i++) {
            intArr[i] = intArr[i] + 7;
            intArr[i] = intArr[i] % 10;
        }

        /*System.out.print(intArr[0]);
        System.out.print(intArr[1]);
        System.out.print(intArr[2]);
        System.out.print(intArr[3]);*/
        return intArr;
    }

    public int[] elementSwap(int[] intArr) {
        // use temp variables to store int values, then switch
        int temp1 = 0, temp2 = 0;
        temp1 = intArr[2];
        intArr[2] = intArr[0];
        intArr[0] = temp1;
        temp2 = intArr[1];
        intArr[1] = intArr[3];
        intArr[3] = temp2;

        /*System.out.print(intArr[0]);
        System.out.print(intArr[1]);
        System.out.print(intArr[2]);
        System.out.print(intArr[3]);*/
        return intArr;
    }


    public String intArrayToString(int[] intArr) {

        // use toString() to convert int array to string
        // use regex to eliminate brackets and replace with quotes
        String converted = Arrays.toString(intArr).replaceAll("\\[|\\]|,|\\s", "");
        return converted;
    }

    public String encrypt(String input) {
        int[] secondStep = stringToCharArray(input);
        //System.out.println(secondStep);
        int[] thirdStep = add7Divide10Remainder(secondStep);
        //System.out.println(thirdStep);
        int[] fourthStep = elementSwap(thirdStep);
        //System.out.println(fourthStep);
        String finish = intArrayToString(fourthStep);
        //System.out.println(finish);

        return finish;
    }

}
