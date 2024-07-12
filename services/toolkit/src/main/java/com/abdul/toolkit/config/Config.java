package com.abdul.toolkit.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"com.abdul.toolkit.client"})
public class Config {

}
