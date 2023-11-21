package com.kdy9960.todoparty;

import org.springframework.stereotype.Service;

@Service // 서비스로 운용할것이이기 @Service 어노테이션 주입
public class UserService {
    public void signup(UserRequestDto userRequestDto) { // 회원가입 메서드로 signup 으로 이름 정한후 그에 관해 자료를 저장할 공간을 선정
        String username = userRequestDto.getUsername(); // Service로 userRequestDto안에 있는 Username 가져오기
        String password = userRequestDto.getPassword();
    }
}
