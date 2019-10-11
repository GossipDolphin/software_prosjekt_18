import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public abstract class Bruker {

    private String email;
    private String password;
    private String navn_f;
    private String navn_e;
    private final byte[] salt;

    public Bruker(String email, String password, String navn){
        this.email = email;

        this.navn_f = navn_f;
        this.navn_e = navn_e;
        byte[] tempSalt = new byte[7];
        new Random().nextBytes(tempSalt);
        salt = tempSalt;
        this.password = hashPassword(password,salt);
    }

    @Override
    public String toString(){
        return email + " " + password + " " + navn_f + " " + navn_e;
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

    public String getNavn_f() {
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
    }

    public String hashPassword(String inputPassword, byte salt[]){
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
    public boolean login(String password){
        if(hashPassword(password, getSalt()) == this.password)
            return true;
        else
            return false;
    }
}
