package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

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
}
