package ra.academy.config;

import org.springframework.web.servlet.HandlerInterceptor;
import ra.academy.model.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Account account = (Account) request.getSession().getAttribute("user_login");
        if (account == null){
            response.sendRedirect("/form-signin");
            return false;
        }
        if(account!=null && account.isRole()){
            return true;
        }
        response.sendRedirect("/403");
        return false;
    }


}
