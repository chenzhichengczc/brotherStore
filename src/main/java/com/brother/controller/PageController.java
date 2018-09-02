package com.brother.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController{

    @RequestMapping(value = "/page/{url}",method = RequestMethod.GET)
    public String page(@PathVariable("url") String url){
        return url;
    }

}
