package cn.kartist.mydiary.core.controller;

import cn.kartist.mydiary.common.entity.Result;
import cn.kartist.mydiary.core.dao.ColorRecordDao;
import cn.kartist.mydiary.core.entity.ColorRecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Kartist 2018/4/1 17:18
 */
@Controller
@RequestMapping("/games/")
public class GameController {
    /**
     *
     */
    @Resource
    private ColorRecordDao recordDao;

    @RequestMapping("color")
    public String colorGame(Model model) {
        List<ColorRecord> reccord = recordDao.selectTopRecord(1);
        Integer score = 20;
        String userName = "--";
        if (reccord.size() == 1) {
            score = reccord.get(0).getScore();
            userName = reccord.get(0).getUserName();
        }
        model.addAttribute("score", score.toString());
        model.addAttribute("userName", userName);
        return "games/color";
    }

    /**
     * 用于控制玩家的步数,防止作弊
     *
     * @param session
     * @return
     */
    @RequestMapping("step")
    @ResponseBody
    public Result addStep(HttpSession session) {
        Integer step = (Integer) session.getAttribute("step");
        if (step == null) {
            step = 0;
        }
        step += 1;
        session.setAttribute("step", step);
        return new Result();
    }

    /**
     * 玩家重新开始游戏
     *
     * @param session
     * @return
     */
    @RequestMapping("newGame")
    @ResponseBody
    public Result newGame(HttpSession session) {
        session.setAttribute("step", 0);
        return new Result();
    }

    /**
     * 获取记录
     *
     * @param top 前多少条记录
     * @return 记录
     */
    @RequestMapping(value = "record", method = RequestMethod.GET)
    @ResponseBody
    public Result getRecord(Integer top) {
        if (top == null) {
            top = 10;
        }
        List result = recordDao.selectTopRecord(top);
        return new Result(result);
    }

    /**
     * 保存记录
     * 先看有没有登录,
     * 如果登录,则使用session中的用户名
     * 如果没登录,看穿过来的用户名
     *
     * @param record   记录值
     * @param userName 用户名
     * @param session  session
     * @return 状态
     */
    @RequestMapping(value = "record", method = RequestMethod.POST)
    @ResponseBody
    public Result getRecord(Integer record, String userName, HttpSession session) {
        String sessionUser = (String) session.getAttribute("user");
        Integer step = (Integer) session.getAttribute("step");
        if (record != step) {
            return new Result(new RuntimeException("你作弊了???"));
        }
        if (sessionUser != null) {
            userName = sessionUser;
        }
        System.out.println(userName);
        if (userName == null || record == null) {
            return new Result(new RuntimeException("参数有误"));
        }
        Integer row = recordDao.saveRecord(record, userName);
        if (row == 1) {
            ColorRecord colorRecord = new ColorRecord();
            colorRecord.setScore(record);
            colorRecord.setUserName(userName);
            return new Result(colorRecord);
        }
        return new Result(new RuntimeException("保存失败"));
    }


}
