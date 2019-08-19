package controller;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

@org.springframework.stereotype.Controller
// @RequestMapping("/wmyskxz")
public class HelloController {

    @RequestMapping("/hello")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "Hello Spring MVC");
        return mav;
    }

    @RequestMapping("/test")
    public ModelAndView testPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("test");
    }

    @RequestMapping("/param")
    public ModelAndView getParam(User user) {
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
        return null;
    }

    @ModelAttribute
    public void Model(Model model) {
        model.addAttribute("message", "成功");
    }

    @RequestMapping("/value")
    public String showValue() {
        return "test2";
    }

    @RequestMapping("/jump")
    public ModelAndView jump() {
        ModelAndView mav = new ModelAndView("redirect:/hello");
        return mav;
    }
}
