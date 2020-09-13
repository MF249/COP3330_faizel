import java.util.Arrays;

public class Decrypter {

    public int[] stringToCharArray(String initial) {
        int[] intInputArr = new int[4];
        char[] charInputArr = initial.toCharArray();

        for (int i = 0; i < charInputArr.length; i++) {
            String temp = Character.toString(charInputArr[i]);
            intInputArr[i] = Integer.parseInt(temp);
        }
        return intInputArr;
    }

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

    public int[] add7Divide10Remainder(int[] intArr) {
        for (int i = 0; i < 4; i++) {
            intArr[i] = intArr[i] + 7;
            intArr[i] = intArr[i] % 10;
        }

        return intArr;
    }

}
