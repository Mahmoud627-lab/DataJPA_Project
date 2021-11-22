package com.example.dataJPA.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({
        @AttributeOverride(
                name="name",
                column = @Column(name = "guardian_name")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardian_email")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardian_mobile")
        )
})
public class Guardian {
    private String name;
    private String email;
    private String mobile;

    public Guardian() {
    }

    public Guardian(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public String getGuardianName() {
        return name;
    }

    public void setGuardianName(String name) {
        this.name = name;
    }

    public String getGuardianEmail() {
        return email;
    }

    public void setGuardianEmail(String email) {
        this.email = email;
    }

    public String getGuardianMobile() {
        return mobile;
    }

    public void setGuardianMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Guardian{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
