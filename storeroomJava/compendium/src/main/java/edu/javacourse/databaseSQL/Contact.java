package edu.javacourse.databaseSQL;

public class Contact {
    private Long contactId;
    private String surName;
    private String giveName;
    private String email;
    private String phone;

    public Contact() {
    }

    public Contact(Long contactId, String surName, String giveName, String email, String phone) {
        this.contactId = contactId;
        this.surName = surName;
        this.giveName = giveName;
        this.email = email;
        this.phone = phone;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGiveName() {
        return giveName;
    }

    public void setGiveName(String giveName) {
        this.giveName = giveName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + contactId +
                ", surName='" + surName + '\'' +
                ", giveName='" + giveName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
