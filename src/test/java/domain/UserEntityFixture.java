package domain;

import app.just.actionstorage.entity.UserEntity;

public class UserEntityFixture {
  public static UserEntity createUserEntity() {
    return UserEntity.builder()
        .username("username")
        .email("username@gmail.com")
        .description("description")
        .build();
  }
}
