import org.springframework.security.crypto.bcrypt.BCrypt;

import java.security.SecureRandom;

public class TestClass {
    public static void main(String[] args) {
        String salt = BCrypt.gensalt();
        System.out.println(salt.length());
        System.out.println(salt);

        SecureRandom random = new SecureRandom();
        salt = BCrypt.gensalt(12, random);
        System.out.println(salt.length());
        System.out.println(salt);
    }
}
