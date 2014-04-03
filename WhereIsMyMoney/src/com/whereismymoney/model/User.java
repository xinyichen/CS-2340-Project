package com.whereismymoney.model;

/**
 * info holder for user.
 * 
 * @author xinyi
 * 
 */
public class User {

    /**
     * usrname.
     */
    private final String username;

    /**
     * first name.
     */
    private final String firstName;

    /**
     * last name.
     */
    private final String lastName;

    /**
     * password.
     */
    private final String password;

    /**
     * email.
     */
    private final String email;

    /**
     * initialize a user object.
     * 
     * @param username
     *            username
     * @param firstName
     *            first name
     * @param lastName
     *            last name
     * @param password
     *            password
     * @param email
     *            email
     */
    public User(String username, String firstName, String lastName,
            String password, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    /**
     * get usrname.
     * 
     * @return username
     */
    public final String getUsername() {
        return username;
    }

    /**
     * get first name.
     * 
     * @return first name
     */
    public final String getFirstName() {
        return firstName;
    }

    /**
     * get last name.
     * 
     * @return last name
     */
    public final String getLastName() {
        return lastName;
    }

    /**
     * get password.
     * 
     * @return password
     */
    public final String getPassword() {
        return password;
    }

    /**
     * get email.
     * 
     * @return email
     */
    public final String getEmail() {
        return email;
    }
}
