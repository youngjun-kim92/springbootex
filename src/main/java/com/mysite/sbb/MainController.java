package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

   @GetMapping("/sbb")
   @ResponseBody
   public String index() {
      return "index";
   }
   
   @GetMapping("/")
   public String root() {
	   // redirect : 클라이언트가 요청하면 새로운 url로 전송하는 것을 의미
	   return "redirect:/question/list";
   }
}