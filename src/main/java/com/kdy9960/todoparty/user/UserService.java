package com.kdy9960.todoparty.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service // 서비스로 운용할것이이기 @Service 어노테이션 주입
@RequiredArgsConstructor // 생성자가 없기때문에 주입해달라고 요청하는 어노테이션
public class UserService {
    private final PasswordEncoder passwordEncoder; // password 암호화를 위해서 Spring Security의 기능중 하나인 PasswordEncoder 사용
    private final UserRepository userRepository;


    public void signup(UserRequestDto userRequestDto) { // 회원가입 메서드로 signup 으로 이름 정한후 그에 관해 자료를 저장할 공간을 선정
        String username = userRequestDto.getUsername(); // Service로 userRequestDto안에 있는 Username 가져오기
        String password = passwordEncoder.encode(userRequestDto.getPassword());

        if (userRepository.findByUsername(username).isPresent()) { // DB에 유저가 있는지 확인하기 위한 메서드 (유저정보위치, 실행메서드)
            throw new IllegalArgumentException("이미 존재하는 유저 입니다.");
        }

        User user = new User(username, password);
        userRepository.save(user);
    }

    public void login(UserRequestDto userRequestDto) {
        String username = userRequestDto.getUsername();
        String password = userRequestDto.getPassword();

        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new IllegalArgumentException("등록된 유저가 없습니다."));
        System.out.println(password);
        System.out.println(user.getPassword());

        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }

}
