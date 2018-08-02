package cn.kartist.mydiary.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Kartist 2018/6/14 21:12
 */
@Controller
public class LiaoController {

    @RequestMapping("/like")
    public String ui(){
        return "games/likeyou";
    }



}
