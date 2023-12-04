package com.kdy9960.todoparty.user;

import com.kdy9960.todoparty.todo.Todo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "users") // DB 에서 실제 사용 하는 경우가 있으니 Table 어노테이션 으로 적용
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 유저 ID값 적용

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Todo> todoList;

    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }
}
