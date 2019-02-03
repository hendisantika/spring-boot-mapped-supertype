package com.hendisantika.springbootmappedsupertype.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mapped-supertype
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-02-03
 * Time: 09:44
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableJpaAuditing
public class DatabaseConfiguration {

    /**
     * @return a simple username as auditor
     */
    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> java.util.Optional.of("Administrator");
    }

}