package org.example;

public class User extends Person implements Comparable<User> {
    private String login;
    private String password;

    public User() {
        super();
    }

    public User(String firstName, String lastName, Gender gender, String login, String password) {
        super(firstName, lastName, gender);
        this.login = login;
        this.password = password;
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

    @Override
    public int compareTo(User o) {
        return this.login.compareTo(o.getLogin());
    }

    @Override
    public String toString() {
        return "Login: " + login + ", " + super.toString();
    }
}
