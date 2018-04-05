package cn.kartist.mydiary.core.controller;

import cn.kartist.mydiary.common.entity.Result;
import cn.kartist.mydiary.common.entity.User;
import cn.kartist.mydiary.core.entity.DiaryPage;
import cn.kartist.mydiary.core.service.BookService;
import cn.kartist.mydiary.core.service.PageService;
import cn.kartist.mydiary.core.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class MyDiaryController {

    private final Logger logger = LoggerFactory.getLogger(MyDiaryController.class);


    @Autowired
    private PageService pageService;

    @Autowired
    private BookService bookService;

    @Autowired
    private WeatherService weatherService;
    @RequestMapping("")
    public String defalt(){
        return "index";
    }
    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("index")
    public String index() {
        return "index";
    }

    /**
     * 登录页
     * @return
     */
    @RequestMapping("login")
    public String login(String name ,String pwd,Integer tryTime,HttpSession session,Model model) {
        if(" ".equals(name) && "shally".equals(pwd)){
            session.setAttribute("user", "shally");
            return "redirect:edit";
        }
        if (" ".equals(name) && "kartist".equals(pwd)) {
            session.setAttribute("user","kartist");
            return "redirect:edit";
        }
        if(tryTime!=null){
            model.addAttribute("message","用户名密码有问题");
        }

        return "login";
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("exit")
    public String exit(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }

    /**
     * 编辑页
     *
     * @param m
     * @return
     */
    @RequestMapping("edit")
    public String edit(Model m) {
        List books = bookService.getAllBook();
        List weathers = weatherService.getAllWeather();
        m.addAttribute("books", books);
        m.addAttribute("weathers", weathers);
        return "edit";
    }

    /**
     * 编辑后保存
     *
     * @param m
     * @return
     */
    @RequestMapping("save")
    public String save(DiaryPage diaryPage, HttpSession session, Model m) {
        logger.info(diaryPage.toString());
        pageService.save(diaryPage, new User((String)session.getAttribute("user")));
        m.addAttribute("message", "保存成功");
        return "message";
    }

    @RequestMapping("update")
    public String update(DiaryPage diaryPage, User user, Model m) {
        logger.info(diaryPage.toString());
        pageService.update(diaryPage, user);
        m.addAttribute("message", "保存成功");
        return "message";
    }

    /**
     * 显示详情
     *
     * @param id
     * @param m
     * @return
     */
    @RequestMapping("detail")
    public String detail(Integer id, Model m) {
        m.addAttribute("page", pageService.getDiaryPageById(id));
        List books = bookService.getAllBook();
        List weathers = weatherService.getAllWeather();
        m.addAttribute("books", books);
        m.addAttribute("weathers", weathers);
        return "edit";
    }

    /**
     * 显示所有
     *
     * @param model
     * @return
     */
    @RequestMapping("all")
    public String getAll(Model model, Integer page) {
        Map map = pageService.getAllDiary(page);
        model.addAttribute("map", map);
        return "all";
    }
    @ResponseBody
    @RequestMapping("delete")
    public Result delete(Integer id) {
        pageService.deleteById(id);
        return new Result("删除成功,可在回收站中恢复删除的日记");
    }
    @ResponseBody
    @RequestMapping("relDelete")
    public Result relDelete(Integer id) {
        pageService.relDeleteById(id);
        return new Result("删除成功");
    }
    @ResponseBody
    @RequestMapping("recover")
    public Result recover(Integer id) {
        pageService.refreshById(id);
        return new Result("恢复成功");
    }

    @RequestMapping("history")
    public String history(Model m) {
        //TODO 回收站功能
        List l = pageService.delHistory();
        m.addAttribute("pages",l);

        return "history";
    }
}
