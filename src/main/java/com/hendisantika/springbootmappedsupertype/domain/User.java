package com.hendisantika.springbootmappedsupertype.domain;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mapped-supertype
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-02-03
 * Time: 09:45
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "t_user")
@Where(clause = "deleted='false'")
@SQLDelete(sql = "UPDATE t_user SET deleted = true WHERE id = ? and version = ?")
public class User extends BaseEntity {

    @Column(length = 100)
    private String username;

    @Column(length = 100)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}