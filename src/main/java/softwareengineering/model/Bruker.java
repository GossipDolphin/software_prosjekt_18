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

    public Bruker(String email, String password, String navn){
        this.email = email;
        this.navn = navn;
        byte[] tempSalt = new byte[7];
        new Random().nextBytes(tempSalt);
        salt = tempSalt;
        this.password = hashPassword(password,salt);
        alleBrukere.add(this);
    }

    @Override
    public String toString(){
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

    public byte[] getSalt(){
        return salt;
    }

    public String getNavn(){
        return navn;
    }
    public void setNavn(String navn){
        this.navn = navn;
    }
    /* public String getNavn_f() {
        return navn_f;
    }

    public void setNavn_f(String navn_f) {
        this.navn_f = navn_f;
    }

    public String getNavn_e() {
        return navn_e;
    }

    public void setNavn_e(String navn_e) {
        this.navn_e = navn_e;
    } */

    public static String hashPassword(String inputPassword, byte salt[]){
        String hashedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(inputPassword.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return hashedPassword;
    }
    public static Bruker login(String email, String password){
        System.out.println("Test");
        Bruker temp = null;
        for(int i = 0; i<alleBrukere.size();i++)
        {
            if(email == alleBrukere.get(i).getEmail());
                temp=alleBrukere.get(i);
        }
        if(temp != null)
        {
            System.out.println(temp.getNavn());
        }
        String test1 = hashPassword(password, temp.getSalt());
        String test2 = temp.getPassword();
        System.out.println(test1);
        System.out.println(test2);
        if(test1.equals(test2))
        {
            System.out.println("KKK");
            return temp;

        }

        else
            return null;
    }
}
