package cn.kartist.mydiary.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 留言板控制器
 *
 * @author Kartist 2018/2/27 21:25
 */
@Controller
@RequestMapping("/msgBord/")
public class MessageBordController {

    private static String message1 = "hello !";
    private static String message2;
    private static String user1 = "我";
    private static String user2;
    private static String date1;
    private static String date2;
    private static SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm:ss");

    @RequestMapping("index")
    public String content(String msg, HttpServletRequest request) {
        String str = (String) request.getSession().getAttribute("user");
        if (!(msg == null || "".equals(msg))) {
            date2 = date1;
            date1 = sdf.format(new Date());
            message2 = message1;
            user2 = user1;
            message1 = msg;
            if (str != null) {
                user1 = str;
            } else {
                user1 = "路人甲";
            }
        }
        request.setAttribute("user1", user1);
        request.setAttribute("msg1", message1);
        request.setAttribute("user2", user2);
        request.setAttribute("msg2", message2);
        request.setAttribute("date1", date1);
        request.setAttribute("date2", date2);
        return "messageBord/index";
    }

}
