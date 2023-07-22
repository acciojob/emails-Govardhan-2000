package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId) {
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Change the email password.
     *
     * @param oldPassword the current password
     * @param newPassword the new password
     * @return true if the password is changed successfully, false otherwise
     */
    public boolean changePassword(String oldPassword, String newPassword) {
        // Check if oldPassword matches the current password
        if (!this.password.equals(oldPassword)) {
            return false;
        }

        // Check if newPassword meets all the conditions
        if (isValidPassword(newPassword)) {
            this.password = newPassword;
            return true;
        }

        return false;
    }

    /**
     * Check if a password is valid.
     *
     * @param password the password to be validated
     * @return true if the password is valid, false otherwise
     */
    private boolean isValidPassword(String password) {
        // Password must contain at least 8 characters, one uppercase letter, one lowercase letter,
        // one digit, and one special character.
        return password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^A-Za-z\\d]).{8,}$");
    }
}

