package com.hendisantika.springbootmappedsupertype;

import com.hendisantika.springbootmappedsupertype.domain.User;
import com.hendisantika.springbootmappedsupertype.domain.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mapped-supertype
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-02-03
 * Time: 09:49
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testDeletion() throws Exception {
        // Validates if there are no users in the repository.
        assertEquals(0, userRepository.count());
        assertEquals(0, userRepository.countDeletedEntries());

        // Creates a new user and saves it.
        User user = new User();
        user.setUsername("foo");
        user.setPassword("bar");
        User dbUser = userRepository.saveAndFlush(user);
        // Now there is one user in the Database.
        assertEquals(1, userRepository.count());
        assertEquals(0, userRepository.countDeletedEntries());

        Optional<User> temp = userRepository.findById(dbUser.getId());

        temp = userRepository.findById(dbUser.getId());
        // Deletes the user.
        userRepository.delete(temp.get());

        // Ensures that the repository-methods doesn't return the deleted user.
        assertEquals(0, userRepository.count());
        // But there should be one user which is still reachable by a native sql-query.
        assertEquals(1, userRepository.countDeletedEntries());
    }
}
