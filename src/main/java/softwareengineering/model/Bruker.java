package softwareengineering.model;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Bruker implements Serializable {

    private String email;
    private String password;
    private String navn;
    private final byte[] salt;
    public static List<Bruker> alleBrukere = new ArrayList<>();

    public Bruker(String email, String password, String navn) {
        this.email = email;
        this.navn = navn;
        byte[] tempSalt = new byte[7];
        new Random().nextBytes(tempSalt);
        salt = tempSalt;
        this.password = hashPassword(password, salt);
        alleBrukere.add(this);
    }

    @Override
    public String toString() {
        return email + " " + navn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = hashPassword(password, getSalt());
    }

    public byte[] getSalt() throws NullPointerException {
        return salt;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public static String hashPassword(String inputPassword, byte salt[]) {
        String hashedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(inputPassword.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashedPassword;
    }

    public static Bruker login(String email, String password) {
        Bruker temp = null;
        for (int i = 0; i < alleBrukere.size(); i++) {
            if (email.equals(alleBrukere.get(i).getEmail())) {
                temp = alleBrukere.get(i);
            }
        }
        try {
            String test1 = hashPassword(password, temp.getSalt());
            String test2 = temp.getPassword();

            if (test1.equals(test2)) {
                return temp;
            } else {
                return null;
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        return null;
    }

    public static Bruker registrerBruker(String bruker, String password, String fornavn, String etternavn, String navn){
        Bruker temp = null;

        if(navn != null) {
            temp = new Organiser(bruker, password, navn);
        }
        if(fornavn != null && etternavn!=null) {
            temp = new Deltager(bruker, password, fornavn, etternavn);
        }
        return temp;
    }
}
