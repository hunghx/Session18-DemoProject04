package ra.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.academy.service.MailService;

import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Controller
public class HomeController {
    @Autowired
    private MailService mailService;
    @RequestMapping({"/",""})
    public String home(Model model, @CookieValue(name = "count",required = false) Integer count, HttpServletResponse response) throws MessagingException {
        if(count == null){
            count = 1;
        }else {
            count++;
        }
        System.out.println("Bạn vừa truy cập "+count+" lần");
        Cookie cookie = new Cookie("count",count.toString());
        cookie.setMaxAge(60); // seconds
        model.addAttribute("count", count);
        response.addCookie(cookie);

        // đếm số lần gửi request lên "/"


//        mailService.sendMail("hunghx@rikkeisoft.com","nguyenha9889@gmail.com","hello world","Bạn đã bị hack , send money to skip message");

//        mailService.sendMail("hunghx@rikkeisoft.com","devst2025@gmail.com","test mail","có cái nịt");
        return "index";

    }
    @RequestMapping("/403")
    public  String _403(){
        return "403";
    }
}
