package test;

import com.sun.deploy.net.HttpUtils;
import com.task.config.WebConfig;
import com.task.dao.PlayerDao;
import com.task.dao.UserDao;
import com.task.entity.Player;
import com.task.service.PlayerService;
import com.task.service.RoleService;
import com.task.service.UserService;
import com.task.util.HttpUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebConfig.class})
@WebAppConfiguration
public class MyTest {
    @Resource
    private UserDao userDao;

    @Resource
    private UserService userService;

    @Resource
    private PlayerService playerService;
    @Resource
    private PlayerDao playerDao;
    @Resource
    private RoleService roleService;
    @Test
    public void test() throws URISyntaxException, IOException {
        /*User user=new User();
        user.setUsername("dd");
        user.setPassword("1111");
        userDao.add(user);*/
       /*User user=userDao.findByNameAndPassword("aa","1111");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());*/
       //userService.AddInsert(user);
        //System.out.println(userService.validatePassword("125ojs@"));
         /*Player player=playerService.paly("魔法师");
        System.out.println(player.getPosition()+"aaaaaaaa");*/
         /*double aa=playerDao.fight(100,50,100,80,100);
         String a1=String.valueOf(aa);
         String value=roleService.getFloatValue(a1);
        System.out.println(value+"aaaaaaaaaa");*/

        /* String value="11.256";
        String[] value1=value.split("\\.");
        String v1=value1[1];
        if(v1.charAt(1)=='5') {
            System.out.println(v1.charAt(1) + "nnnnnnnnn");
        }*//*
        System.out.println(userDao.num());
        double v1=userDao.num();
        *//*for(int i=0;i<100;i++){
            userDao.insert(v1);
        }*//*
        while (true){
            userDao.insert(v1);
        }*/
        /*BigDecimal bigDecimal=BigDecimal.valueOf(0.45676);
        NumberFormat percent = NumberFormat.getPercentInstance();//建立百分比格式化
        percent.setMinimumFractionDigits(2);//百分比小数点最多两位
        percent.setMaximumFractionDigits(2);//百分比小数点最多两位
        System.out.println(percent.format(bigDecimal));*/
        /*DecimalFormat df =  new DecimalFormat("0%");
        String s = df.format(0.2);
        System.out.println(s);
*/
        //System.out.println(BigDecimal.valueOf(4.015).multiply(BigDecimal.valueOf(100)));
        /*URI uri = new URI("http",null,"127.0.0.1",8080,"/getProto","",null);
        HttpPost request = new HttpPost(uri);
        Player.Player1.Builder builder = Player.Player1.newBuilder();
        builder.setAttack(12);
        builder.setDesense(14);
        HttpResponse response = HttpUtil.doPost(request, builder.build());*/
        try {
            URI uri = new URI("http", null, "127.0.0.1", 8080, "/getProto", "", null);
            HttpPost request = new HttpPost(uri);
            Player.Player1.Builder builder = Player.Player1.newBuilder();
            builder.setAttack(12);
            builder.setDesense(15);
            HttpResponse response = HttpUtil.doPost(request, builder.build());
            Player.Player1 messageUserLoginResponse = Player.Player1.parseFrom(response.getEntity().getContent());
            System.err.println(messageUserLoginResponse.getBlood());
        } catch (Exception e) {

        }

    }
}
