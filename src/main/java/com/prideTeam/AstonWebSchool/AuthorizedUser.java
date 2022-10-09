package com.prideTeam.AstonWebSchool;

import com.prideTeam.AstonWebSchool.entity.entityAbstracts.AbstractBaseUser;
import org.springframework.security.core.userdetails.User;

import java.io.Serial;
import java.util.List;

public class AuthorizedUser extends User {
    @Serial
    private static final long serialVersionUID = 1L;
    private final AbstractBaseUser user;

    public AuthorizedUser(AbstractBaseUser user) {
        super(user.getEmail(), user.getPassword(), List.of(user.getRole()));
        this.user = user;
    }

    public int getId() {
        return user.getId();
    }
}
