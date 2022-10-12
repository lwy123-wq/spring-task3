package com.task.config;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class EquipConfig {
     public static Map<String,String> map= new HashMap<>();

     @PostConstruct
     public static void equipMp(){
         map.put("装备1","");
         map.put("装备2","");
     }

}
