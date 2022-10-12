package com.task.controller;

import com.task.config.EquipConfig;
import com.task.dao.PlayerDao;
import com.task.entity.Player;
import com.task.service.PlayerService;
import com.task.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PlayerController {
    @Autowired
    private PlayerDao playerDao;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private RoleService roleService;
    @RequestMapping(value = "game",method = RequestMethod.GET)
    public String game1(){
        return "game";
    }

    //穿戴装备
    @RequestMapping(value = "equip",method = RequestMethod.POST,produces = "application/x-protobuf")
    public void equip(String equip , float attack, float desense, float blood, float speed , float move, String position, HttpServletResponse response) throws IOException {
        Player.Player1.Builder play1=Player.Player1.newBuilder();
        if (equip==position){
            BigDecimal attack1=roleService.myDecimal(attack).multiply(BigDecimal.valueOf(1+0.2));
            BigDecimal desense1=roleService.myDecimal(desense).multiply(BigDecimal.valueOf(1+0.2));
            BigDecimal blood1=roleService.myDecimal(blood).multiply(BigDecimal.valueOf(1+0.2));
            BigDecimal speed1=roleService.myDecimal(attack).multiply(BigDecimal.valueOf(1+0.2));
            BigDecimal move1=roleService.myDecimal(attack).multiply(BigDecimal.valueOf(1+0.2));
            BigDecimal fight1=playerDao.fight(attack,desense,blood,speed,move);
            play1.setFight(fight1.doubleValue()).setAttack(attack1.floatValue()).setDesense(desense1.floatValue())
                    .setBlood(blood1.floatValue()).setSpeed(speed1.floatValue()).setMove(move1.floatValue());
            byte[] array=play1.build().toByteArray();
            try {
                response.getWriter().println(array);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            response.getWriter().println("穿戴失败".getBytes(StandardCharsets.UTF_8));
        }
    }
    //升级装备
    @RequestMapping(value = "upgrade",method = RequestMethod.POST,produces = "application/x-protobuf")
    public void upgrade(String equip,float attack,float desense,float blood,float speed ,float move,HttpServletResponse response){
        String e1=EquipConfig.map.get(equip);
        List<Object> list=playerService.equipUpGradee(e1,attack,desense,blood,speed,move);
        Player.Player1.Builder player=Player.Player1.newBuilder();
        player.setFight((Double) list.get(0)).setAttack((Float) list.get(1)).setDesense((Float) list.get(2))
                .setBlood((Float) list.get(3)).setSpeed((Float) list.get(4)).setMove((Float) list.get(5));

        byte[] array=player.build().toByteArray();
        try {
            response.getWriter().println(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
