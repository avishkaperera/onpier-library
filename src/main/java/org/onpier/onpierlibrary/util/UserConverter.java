package org.onpier.onpierlibrary.util;

import lombok.experimental.UtilityClass;
import org.onpier.onpierlibrary.persistence.model.User;

@UtilityClass
public class UserConverter {

    public User toUserEntity(org.onpier.onpierlibrary.loader.model.User user) {
        return User.builder()
                .lastName(user.lastName())
                .firstName(user.firstName())
                .memberSince(user.memberSince())
                .memberTill(user.memberTill())
                .gender(user.gender())
                .build();
    }

    public org.onpier.onpierlibrary.api.model.User toUserResponse(User user) {
        return org.onpier.onpierlibrary.api.model.User.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .memberSince(user.getMemberSince())
                .memberTill(user.getMemberTill())
                .gender(user.getGender())
                .build();
    }
}
