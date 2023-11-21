package com.kdy9960.todoparty;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { // 인터페이스로 작성해서 JpaRepository(스프링프레임워크)를 상속받아서 만들도록 한다.

}
