package com.task.controller;

import com.google.protobuf.ByteString;
import com.google.protobuf.Internal;
import com.task.entity.Player;
import com.task.service.PlayerService;
import com.task.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class WelcomeController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PlayerService playerService;

    private static Player.Player1 player1;
    //主页
    @RequestMapping(value = "welcome",method = RequestMethod.GET)
    public String welcome(){
        return "welcome";
    }

    @RequestMapping(value = "welcomePage",method = RequestMethod.POST)
    @ResponseBody
    public String role(String userId,String role){
        log.info("用户Id{}",userId+role);
        int role1=roleService.AddRole(userId, role);
        player1=playerService.paly(role);
        if(role1==1){
            return "success";
        }
        return "error";
    }



    @RequestMapping(value = "gamePage",method = RequestMethod.POST,produces = "application/x-protobuf")
    @ResponseBody
    public Player.Player1 player(HttpServletResponse response){
        /*List list=new ArrayList();
        list.add("战斗力"+player1.getFight());
        list.add("攻击"+player1.getAttack());
        list.add("防御"+player1.getDesense());
        list.add("血量"+player1.getBlood());
        list.add("攻速"+player1.getSpeed());
        list.add("移动"+player1.getMove());
        list.add("阵营"+player1.getPosition());*/
        //ByteString array=player1.toByteString();
        //JSONArray jsonArray = JSONArray.fromObject(list);
        /*try {
            response.getWriter().write(String.valueOf(array));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return player1;
        /*Map<String,Object> map=new HashMap<>();
        map.put();
        map.put("攻击",player1.getAttack());
        map.put("防御",player1.getDesense());
        map.put("血量",player1.getBlood());
        map.put("攻速",player1.getSpeed());
        map.put("移动",player1.getMove());
        map.put("阵营",player1.getPosition());*/
    }
    @RequestMapping(value = "getProto",produces = "application/x-protobuf")
    @ResponseBody
    public Player.Player1 getProduct(@RequestBody Player.Player1 msg){
        Player.Player1.Builder player1= Player.Player1.newBuilder();
        player1.setAttack(msg.getAttack());
        player1.setDesense(msg.getDesense());
        player1.setBlood(16);
        byte[] p1=player1.build().toByteArray();

        System.out.println(player1.getAttack()+"aaaaaaaaaaa");
        return player1.build();
    }

}
