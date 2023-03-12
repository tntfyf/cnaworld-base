package cn.cnaworld.base;

import cn.cnaworld.framework.infrastructure.utils.redis.CnaRedisUtil;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class CnaworldBaseApplicationTests {

    @Test
    void getSetAndType() {
        //int long string map list set object
        Map<String,String> map1 = new HashMap<>();
        map1.put("map1","map1");
        map1.put("map2","map2");

        Map<Object,Object> map2 = new HashMap<>();
        JavaTestBean javaTestBean = new JavaTestBean();
        map2.put(javaTestBean,javaTestBean);
        List<List<JavaTestBean>> list =  new ArrayList<>();
        List<JavaTestBean> javaTestBeanlist =  new ArrayList<>();
        javaTestBeanlist.add(javaTestBean);
        list.add(javaTestBeanlist);
        Map<String,List<List<JavaTestBean>>> map3 = new HashMap<>();
        map3.put("map3",list);

        //int
        CnaRedisUtil.set("k1",1);
        //long
        CnaRedisUtil.set("k2",1L);
        //string
        CnaRedisUtil.set("k3","test");
        //map
        CnaRedisUtil.set("k4",map1);
        //map
        CnaRedisUtil.set("k5",map2);
        //map
        CnaRedisUtil.set("k6",map3);
        //list
        CnaRedisUtil.set("k7",list);
        //list
        CnaRedisUtil.set("k8",javaTestBean);
        //超时
        CnaRedisUtil.set("k9",1,100L, TimeUnit.MILLISECONDS);
        //设置新值并且返回旧值
        int k1 =CnaRedisUtil.getAndSet("k1", 2);
        //设置新值并且返回旧值
        CnaRedisUtil.getAndSet("k1", 2, 10, TimeUnit.SECONDS);
        //CAS
        CnaRedisUtil.compareAndSet("k1",1L,2L);
        //当且仅当 key 不存在，将 key 的值设为 value , 并设置有效期
        CnaRedisUtil.setIfAbsent("k12","k12", Duration.ofSeconds(60));
        //当且仅当 key 不存在，将 key 的值设为 value
        CnaRedisUtil.setIfAbsent("k13","k13");


        System.out.println(CnaRedisUtil.get("k1").toString());
        System.out.println(CnaRedisUtil.get("k2").toString());
        System.out.println(CnaRedisUtil.get("k3").toString());
        System.out.println(CnaRedisUtil.get("k4").toString());
        System.out.println(CnaRedisUtil.get("k5").toString());
        System.out.println(CnaRedisUtil.get("k6").toString());
        System.out.println(CnaRedisUtil.get("k7").toString());
        System.out.println(CnaRedisUtil.get("k8").toString());
        System.out.println(CnaRedisUtil.get("k9").toString());
        System.out.println(k1);

    }

    @Test
    void getsSetsAndType() {
        //批量存取
        Map<String, JavaTestBean> kvMap = new HashMap<>();
        kvMap.put("k1",new JavaTestBean());
        kvMap.put("k2",new JavaTestBean());
        CnaRedisUtil.sets(kvMap);
        Map<String, String> gets = CnaRedisUtil.gets("k1", "k2");
        System.out.println(gets);
    }

    @Test
    void lock(){
        //加锁解锁
        RLock lock = CnaRedisUtil.getLock("lock");
        lock.lock();
        try{
            System.out.println("业务！");
        }catch (Exception e){
            System.out.println("异常!");
        }finally {
            lock.unlock();
        }
    }

    public static class JavaTestBean{

        public String name="张三";

    }

}
