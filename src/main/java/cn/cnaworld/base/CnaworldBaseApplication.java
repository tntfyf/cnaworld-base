package cn.cnaworld.base;

import cn.cnaworld.base.infrastructure.utils.SpringBeanUtil;
import cn.cnaworld.framework.infrastructure.utils.resources.CnaSysConfigUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author Lucifer
 */
@SpringBootApplication
@MapperScan("cn.cnaworld.base.domain.**.mapper")
public class CnaworldBaseApplication {

    public static void main(String[] args) {
        System.setProperty("LOCAL_IP", CnaSysConfigUtil.getHostIp());
        System.setProperty("SERVER_NAME", CnaSysConfigUtil.getApplicationName());
        SpringBeanUtil.set(SpringApplication.run(CnaworldBaseApplication.class, args));
    }

}
