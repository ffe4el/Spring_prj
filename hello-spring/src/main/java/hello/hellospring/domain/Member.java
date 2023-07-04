package hello.hellospring.domain;

import jakarta.persistence.*;


@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)//고유Id, pk와 같이 자동적으로 올라가는것
    public Long getId() {
        return id;
    }

    @Column(name = "username")
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Long id; //시스템이 부여하는 아이디
    private String name;


}
