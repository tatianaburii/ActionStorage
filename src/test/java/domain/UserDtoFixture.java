package domain;

import app.just.common.dto.UserDto;

public class UserDtoFixture {
  public static UserDto createUserDto() {
    return UserDto.builder()
        .username("username")
        .email("username@gmail.com")
        .description("description")
        .build();
  }
}
