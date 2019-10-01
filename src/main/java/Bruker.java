public abstract class Bruker {

    public String email;
    public String password;
    public String navn_f;
    public String navn_e;

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


}
