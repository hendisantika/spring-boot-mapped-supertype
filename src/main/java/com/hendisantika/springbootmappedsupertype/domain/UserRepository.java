package com.hendisantika.springbootmappedsupertype.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mapped-supertype
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-02-03
 * Time: 09:46
 * To change this template use File | Settings | File Templates.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT count(u.id) FROM t_user u WHERE u.deleted='true'", nativeQuery = true)
    long countDeletedEntries();
}