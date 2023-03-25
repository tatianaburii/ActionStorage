package service;

import app.just.actionstorage.entity.UserEntity;
import app.just.actionstorage.mapper.UserEntityMapper;
import app.just.actionstorage.repository.UserRepository;
import app.just.actionstorage.serivce.UserService;
import app.just.common.dto.UserDto;
import domain.UserDtoFixture;
import domain.UserEntityFixture;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@FieldDefaults(level = AccessLevel.PACKAGE)
public class UserServiceTest {

  @Mock
  UserRepository userRepository;
  @Mock
  UserEntityMapper userEntityMapper;
  @InjectMocks
  UserService userService;

  @Test
  void findAll() {
    UserEntity userEntity = UserEntityFixture.createUserEntity();
    List<UserEntity> userEntities = List.of(userEntity);

    UserDto userDto = UserDtoFixture.createUserDto();
    List<UserDto> userDtoList = List.of(userDto);

    when(userRepository.findAll()).thenReturn(userEntities);
    when(userEntityMapper.toDto(userEntity)).thenReturn(userDto);

    List<UserDto> actualUsers = userService.findAll();

    assertThat(userDtoList).isEqualTo(actualUsers);
  }

}
