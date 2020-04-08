package com.TimeTo.TimeTo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    @JsonIgnore
    @OneToOne
    private UserAccount userAccount;
    @OneToMany
    private Set<Event> events;
    @ManyToMany
    private Set<UserAccount> friends;

    @OneToOne
    private Calendar calendar;

    protected Account() {

    }

    public Account(UserAccount userAccount, Calendar calendar) {
        friends = new HashSet<>();
        this.userAccount = userAccount;
        events = new HashSet<>();
        this.calendar = calendar;
        this.username = userAccount.getUserName();
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return username;
    }

    public UserAccount getUserAccount(){
        return userAccount;
    }

    public Set<UserAccount> getFriends() {
        return friends;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void addFriend(UserAccount friend){
        friends.add(friend);
    }

    public void addEvent(Event event){
        events.add(event);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userAccount=" + userAccount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != null ? !id.equals(account.id) : account.id != null) return false;
        if (userAccount != null ? !userAccount.equals(account.userAccount) : account.userAccount != null) return false;
        return calendar != null ? calendar.equals(account.calendar) : account.calendar == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userAccount != null ? userAccount.hashCode() : 0);
        result = 31 * result + (calendar != null ? calendar.hashCode() : 0);
        return result;
    }
}