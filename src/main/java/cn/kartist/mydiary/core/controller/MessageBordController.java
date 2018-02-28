package cn.kartist.mydiary.core.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 留言板控制器
 *
 * @author Kartist 2018/2/27 21:25
 */
@Controller
@RequestMapping("/msgBord/")
public class MessageBordController {

    private static String message = "hello !";

    private static String user = "我";

    @RequestMapping("index")
    public String content(String msg, HttpServletRequest request) {
        String str = (String) request.getSession().getAttribute("user");
        if (!(msg == null || "".equals(msg))) {
            message = msg;
            if (str != null) {
                user = str;
            } else {
                user = "路人甲";
            }
        }
        request.setAttribute("user", user);
        request.setAttribute("msg", message);
        return "messageBord/index";
    }

}
