public class Application {
    public void main(String[] args) {
        Encrypter e = new Encrypter();
        String input = "1234";
        String temp = e.encrypt(input);
        System.out.println(temp);
    }
}
