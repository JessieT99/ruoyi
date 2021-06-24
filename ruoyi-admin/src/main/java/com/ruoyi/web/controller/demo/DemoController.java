package com.ruoyi.web.controller.demo;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ruoyi
 * @description:
 * @author: junjie.tan
 * @create: 2021-06-24 16:46
 **/
@RestController
@RequestMapping("/project/demo")
public class DemoController extends BaseController {

    @GetMapping("/test")
    public AjaxResult test(@RequestParam Long id){
        return AjaxResult.success("收到参数"+id);
    }
}
