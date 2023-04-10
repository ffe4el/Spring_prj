package hello.hellospring.domain;

public class Member {
    public Long getId() {
        return id;
    }

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