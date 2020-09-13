public class Application {
    public static void main(String[] args) {
        Encrypter myEncrypter = new Encrypter();
        Decrypter myDecrypter = new Decrypter();
        String input1 = "1234";
        String input2 = "0189";
        String temp = myEncrypter.encrypt(input1);
        System.out.println(temp);
        temp = myDecrypter.decrypt(input2);
        System.out.println(temp);
    }
}
