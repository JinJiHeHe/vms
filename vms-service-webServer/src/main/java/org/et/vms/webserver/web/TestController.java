package org.et.vms.webserver.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: jakiro
 * Date: 2017/7/28
 * Time: 上午1:02
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String testGet(Model model){

        System.out.println("request come");
        return "index";
    }

}
