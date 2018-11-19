package com.configuration;

import com.controller.ItemController;
import com.dao.ItemDAO;
import com.service.ItemService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com")
public class AppConfig {

    @Bean
    public ItemDAO itemDAO(){
        return new ItemDAO();
    }

    @Bean
    public ItemService itemService(ItemDAO itemDAO){
        return new ItemService(itemDAO);
    }

    @Bean
    public ItemController itemController(ItemService itemService){
        return new ItemController(itemService);
    }

}
