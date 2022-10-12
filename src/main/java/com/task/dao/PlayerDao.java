package com.task.dao;

import com.task.entity.Player;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class PlayerDao {

    public BigDecimal fight(float attack,float desense,float blood,float speed ,float move){
        BigDecimal battlePower= BigDecimal.valueOf(attack).multiply(BigDecimal.valueOf(0.12)).add(BigDecimal.valueOf(desense).multiply(BigDecimal.valueOf(0.21))).add(BigDecimal.valueOf(blood).multiply(BigDecimal.valueOf(0.11))).add(BigDecimal.valueOf(speed).multiply(BigDecimal.valueOf(0.13))).add(BigDecimal.valueOf(move).multiply(BigDecimal.valueOf(0.18)));
        return battlePower;
    }

    public BigDecimal camp(float attack){
        BigDecimal battlePower=BigDecimal.valueOf(attack).multiply(BigDecimal.valueOf(0.2)).multiply(BigDecimal.valueOf(0.21));
        return battlePower;
    }
    public Player.Player1 add(BigDecimal fight, float attack, float desense, float blood, float speed , float move, String position){
        Player.Player1.Builder player=Player.Player1.newBuilder();
        player.setFight(fight.doubleValue());
        player.setAttack(attack);
        player.setDesense(desense);
        player.setBlood(blood);
        player.setSpeed(speed);
        player.setMove(move);
        player.setPosition(position);
        Player.Player1 player1=player.build();
        return player1;
    }

    /*public float equipUpGradee(String equip,float attack,float desense,float blood,float speed ,float move){
        float upgrade=0;
        List list=new ArrayList();
        switch (equip){
            case "攻击":
                upgrade= (float) (attack*(1+0.1));
            case "防御":
                upgrade= (float) (desense*(1+0.1));
            case "血量":
                upgrade= (float) (blood*(1+0.1));
            case "攻速":
                upgrade= (float) (speed*(1+0.1));
            case "移动":
                upgrade= (float) (move*(1+0.1));
        }
        return upgrade;
    }*/


}
