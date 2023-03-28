package cn.cnaworld.base.domain.login.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 接入层，负责domain领域间协调 ，只有Controller 和 service。不与实体直接交互。
 * @author Lucifer
 * @date 2023/2/1
 * @since 1.0
 */
@Controller
@Api(tags = "登录")
public class IndexController {

    /**
     * index
     * @author Lucifer
     * @date 2023/3/27
     * @since 1.0.0
     */
    @GetMapping()
    public String index(){
        return "index";
    }

}
