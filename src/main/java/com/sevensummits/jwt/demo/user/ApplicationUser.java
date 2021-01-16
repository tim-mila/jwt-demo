package com.sevensummits.jwt.demo.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.sevensummits.jwt.demo.global.json.Views;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    @JsonView(Views.Public.class)
    private UUID id;

    @JsonView(Views.Public.class)
    private String username;

    private String password;

    public static ApplicationUser from(final String username, final String password) {
        final ApplicationUser user = new ApplicationUser();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ApplicationUser{" + "id=" + id + ", username='" + username + '\'' + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ApplicationUser that = (ApplicationUser) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }
}
