package com.Redis;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
/**
 * @author whoami
 */
public class RoleTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
        Role role = new Role();
        role.setId(1L);
        role.setRoleName("role_Name_1");
        role.setNote("note_1");
        redisTemplate.opsForValue().set("role_1", role);
        Role role_R = (Role) redisTemplate.opsForValue().get("role_1");
        System.out.println(role_R.getRoleName()+" "+role_R.getNote()+" "+role_R.getId()+" "+role_R.getClass());

        /**
         * 使用连接池，但是一个服务器可以对应多个客户端的Redis连接。
         * 上面的方法中 set/get方法 可能是在不同的连接中获取的。
         * 可以通过SessionCallback接口，将命令在同一个Redis中执行。
         */
        Role role_2 = new Role();
        role_2.setRoleName("donglxa");
        role_2.setNote("donglxa");
        role_2.setId(2L);
        SessionCallback callback=new SessionCallback<Role>(){

            @Override
            public  Role execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.boundValueOps("role_2").set(role_2);
                return (Role) redisOperations.boundValueOps("role_2").get();

            }
        };
        Role saveRole = (Role) redisTemplate.execute(callback);
        System.out.println(saveRole.toString());
    }
}
