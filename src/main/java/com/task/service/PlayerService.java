package com.task.service;

import com.task.dao.PlayerDao;
import com.task.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PlayerService {

    @Autowired
    private PlayerDao playerDao;
    @Autowired
    private RoleService roleService;
    private static String[] thisArr=new String[]{"红方","蓝方"};
    private Random random=new Random();
    int thisIndex =random.nextInt(thisArr.length);
    Player.Player1 player1=null;
    public Player.Player1 paly(String name){
        switch (name){
            case "魔法师":
                BigDecimal fight=playerDao.fight(100,50,100,80,100);
                player1=playerDao.add(fight,100,50,100,80,100,thisArr[thisIndex]);
            case "治疗师":
                BigDecimal fight1=playerDao.fight(20,100,200,20,150);
                player1=playerDao.add(fight1,20,100,200,20,150,thisArr[thisIndex]);
            case "射手":
                BigDecimal fight2=playerDao.fight(200,50,80,40,50);
                player1=playerDao.add(fight2,200,50,80,40,50,thisArr[thisIndex]);
        }
        return player1;
    }

    public List<Object> equipUpGradee(String equip,float attack,float desense,float blood,float speed ,float move){
        float upgrade=0;
        List list=new ArrayList();
        BigDecimal fight1=null;
        switch (equip){
            case "攻击":
                upgrade= (float) (attack*(1+0.1));
                fight1=playerDao.fight(upgrade,desense,blood,speed,move);
                list.add(fight1);
                list.add(upgrade);
                list.add(desense);
                list.add(blood);
                list.add(speed);
                list.add(move);
            case "防御":
                upgrade= (float) (desense*(1+0.1));
                fight1=playerDao.fight(attack,upgrade,blood,speed,move);
                list.add(fight1);
                list.add(attack);
                list.add(upgrade);
                list.add(blood);
                list.add(speed);
                list.add(move);
            case "血量":
                upgrade= (float) (blood*(1+0.1));
                fight1=playerDao.fight(attack,desense,upgrade,speed,move);
                list.add(fight1);
                list.add(attack);
                list.add(desense);
                list.add(upgrade);
                list.add(speed);
                list.add(move);
            case "攻速":
                upgrade= (float) (speed*(1+0.1));
                fight1=playerDao.fight(attack,desense,blood,upgrade,move);
                list.add(fight1);
                list.add(attack);
                list.add(desense);
                list.add(blood);
                list.add(upgrade);
                list.add(move);
            case "移动":
                upgrade= (float) (move*(1+0.1));
                fight1=playerDao.fight(attack,desense,blood,speed,upgrade);
                list.add(fight1);
                list.add(attack);
                list.add(desense);
                list.add(blood);
                list.add(speed);
                list.add(upgrade);
        }

        return list;
    }
}
