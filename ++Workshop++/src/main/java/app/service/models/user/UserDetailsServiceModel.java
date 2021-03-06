package app.service.models.user;

import app.service.models.hero.HeroServiceModel;

public class UserDetailsServiceModel {
    private String username;

    private String email;

    private HeroServiceModel hero;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HeroServiceModel getHero() {
        return this.hero;
    }

    public void setHero(HeroServiceModel hero) {
        this.hero = hero;
    }
}
