package cn.luozc.domain.sys;

import javax.persistence.*;

/**
 * @Author: luozhicong
 * @Description:
 * @Date: Create in 16:59 2018/12/20/020
 */
@Entity
@Table
public class SysUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//主键

    private String username;

    private String password;

    private String sex;

    private String age;


    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSex() {
        return sex;
    }

    public String getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
