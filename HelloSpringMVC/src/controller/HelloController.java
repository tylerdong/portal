package controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

@Controller
//@RequestMapping("/mvc")
public class HelloController {
    //@Override
    //public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
    //    ModelAndView mav = new ModelAndView("index.jsp");
    //    mav.addObject("message", "Hello Spring MVC");
    //    return mav;
    //}

    @RequestMapping("hello")
    public ModelAndView helloRequest(HttpServletRequest request, HttpServletRequest response) {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "hello world mvc!");
        return mav;
    }

    @RequestMapping("test")
    public ModelAndView testRequest(HttpServletRequest request, HttpServletRequest response) {
        return new ModelAndView("test");
    }

    /**
     * 传递参数，从HttpServletRequest里获取
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "paramFromRequest", method = RequestMethod.POST)
    public ModelAndView paramFromRequest(HttpServletRequest request, HttpServletRequest response) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        System.out.println(userName);
        System.out.println(password);
        return null;
    }

    /**
     * 传递参数，直接使用参数名
     *
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value = "param", method = RequestMethod.POST)
    public ModelAndView paramFunction(String userName, String password) {
        System.out.println(userName);
        System.out.println(password);
        return null;
    }

    /**
     * 传递参数，使用html中name=“userName”
     *
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value = "requestParam", method = RequestMethod.POST)
    public ModelAndView namePrarm(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        System.out.println(userName);
        System.out.println(password);
        return null;
    }

    /**
     * 使用实体类传递参数
     * @param user
     * @return
     */
    @RequestMapping(value = "modelParam", method = RequestMethod.POST)
    public ModelAndView modelParam(User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return null;
    }

    /**
     * 使用Servlet原生API显示数据
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("value")
    public ModelAndView handValue(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("message", "成功");
        return new ModelAndView("test2");
    }

    /**
     * 使用ModelAndView显示数据
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("value1")
    public ModelAndView handValue1(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("test2");
        mav.addObject("message", "成功");
        return mav;
    }

    /**
     * 使用model对象
     * @param model
     * @return
     */
    @RequestMapping("value2")
    public String handValue2(Model model) {
        model.addAttribute("message", "成功value2");
        return "test2";
    }

    /**
     * 使用注解
     * @param model
     */
    @ModelAttribute
    public void model(Model model) {
        model.addAttribute("message", "注解成功");
    }
    @RequestMapping("value3")
    public String handValue3() {
        return "test2";
    }

    @RequestMapping("/jump")
    public String jump() {
        return "redirect: ./hello";
    }

}
