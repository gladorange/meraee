package evilorange.jee;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import evilorange.jee.model.User;

@Entity

public class UserSettings {

    @Id
    @GeneratedValue
    Long id;

    @OneToOne
    User user;

    @Column(columnDefinition = "TEXT")
    String settings;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof UserSettings))
            return false;
        UserSettings that = (UserSettings) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects
                .equals(settings, that.settings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, settings);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSettings() {
        return settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }
}
