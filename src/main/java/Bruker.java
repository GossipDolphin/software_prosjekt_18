public abstract class Bruker {

    private String email;
    private String password;
    private String navn_f;
    private String navn_e;

    public Bruker(String email, String password, String navn_f, String navn_e){
        this.email = email;
        this.password = password;
        this.navn_f = navn_f;
        this.navn_e = navn_e;
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
        this.password = password;
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

}
