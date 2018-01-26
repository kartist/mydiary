package cn.kartist.mydiary.space;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 秘密空间
 *
 * @author Kartist 2018/1/26 20:50
 */
@Controller
@RequestMapping("/")
public class SpaceController {
    @RequestMapping("c.d")
    public String spaceIndex() {
        return "sc/spaceIndex";
    }


}
