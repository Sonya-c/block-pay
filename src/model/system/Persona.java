package model.system;

public class Persona {
    private String userName;
    private String names;
    private String lastNames;
    private String password;
    
    private final int id;
    private float dinero;
    
//    public Persona(String userName, String names, String lastNames, int id, float dinero) {
//        this.userName = userName;
//        this.names = names;
//        this.lastNames = lastNames;
//        this.id = id;
//        this.dinero = dinero;
//        this.password = "";
//    }

    public Persona(String userName, String names, String lastNames, int id, float dinero, String password) {
        this.userName = userName;
        this.names = names;
        this.lastNames = lastNames;
        this.id = id;
        this.dinero = dinero;
        this.password = password;
    }
    
    // === GETTER AND SETTERS
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNames() {
        return this.names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return this.lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public int getId() {
        return this.id;
    }


    public float getDinero() {
        return this.dinero;
    }

    public void setDinero(float dinero) {
        this.dinero = dinero;
    }
    
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}