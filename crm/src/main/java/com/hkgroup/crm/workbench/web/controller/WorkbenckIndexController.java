package com.hkgroup.crm.workbench.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WorkbenckIndexController {

    @RequestMapping("/workbench/index.do")
    public String index() {
        return "workbench/index";
    }
}
