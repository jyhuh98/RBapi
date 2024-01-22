package org.example.rbapi.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/rbboard")
@Controller
public class RbBoardPageController {
    @GetMapping("/{page}")
    public String create(@PathVariable("page") String page){
        return "/rbboard/" + page;
    }
}
