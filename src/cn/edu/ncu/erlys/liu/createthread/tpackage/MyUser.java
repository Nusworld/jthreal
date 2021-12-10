package cn.edu.ncu.erlys.liu.createthread.tpackage;

public class MyUser {
    private String name;
    private Integer age;

    public MyUser(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


//    @Override
//    public String toString() {
//        return "MyUser{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }

    public MyUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
