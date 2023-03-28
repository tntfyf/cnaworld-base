package cn.cnaworld.base.api.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 接入层，负责domain领域间协调 ，只有Controller 和 service。不与实体直接交互。
 * @author Lucifer
 * @date 2023/2/1
 * @since 1.0
 */
@Controller
@RequestMapping("")
@Api(tags = "接入层负责domain领域间协调")
public class AccessLayerController {

    /**
     * index
     * @author Lucifer
     * @date 2023/3/27
     * @since 1.0.0
     */
    @RequestMapping("")
    public String index(Model model){
        System.out.println("arica");
        return "arica";
    }

}
