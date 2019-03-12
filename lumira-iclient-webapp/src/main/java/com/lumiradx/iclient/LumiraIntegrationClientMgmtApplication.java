package com.lumiradx.iclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * Main class that execute the Application
 *
 * @Smitha.Rao
 */
@SpringBootApplication
@EntityScan({"com.lumiradx", "com.wellogic"})
@ComponentScan(basePackages = { "com.lumiradx", "com.wellogic" })
@PropertySources({ @PropertySource("classpath:application.properties") })
public class LumiraIntegrationClientMgmtApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(LumiraIntegrationClientMgmtApplication.class, args);
    }

}
