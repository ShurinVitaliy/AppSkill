package sample;

public class User {
    private String surname;
    private String lastname;
    private String login;
    private String password;

    public User(String surname, String lastname, String login, String password) {
        this.surname = surname;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
