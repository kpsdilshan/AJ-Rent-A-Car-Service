package com.practical.project.oauth2_server.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Data
@Table(name = "user")
public class User {
    public User(){}

    public User(User user){
        this.username =  user.username;
        this.password =  user.password;
        this.email = user.email;
        this.enabled =  user.enabled;
        this.accountNonExpired =  user.accountNonExpired;
        this.accountNonLocked =  user.accountNonLocked;
        this.credentialsNonExpired = user.credentialsNonExpired;
        this.roles = user.roles;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "accountNonExpired")
    private boolean accountNonExpired;
    @Column(name = "credentialsNonExpired")
    private boolean credentialsNonExpired;
    @Column(name = "accountNonLocked")
    private boolean accountNonLocked;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_user", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
        inverseJoinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

}
