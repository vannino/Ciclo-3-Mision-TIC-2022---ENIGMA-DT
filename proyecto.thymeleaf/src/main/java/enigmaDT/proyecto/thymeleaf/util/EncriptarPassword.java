package enigmaDT.proyecto.thymeleaf.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {
    public static void main(String[] args) {
        var password = "Pipe242002*";
        System.out.println("Password: " + password);
        System.out.println("Password encriptado: " + encriptarPassword(password));
    }

    private static String encriptarPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
