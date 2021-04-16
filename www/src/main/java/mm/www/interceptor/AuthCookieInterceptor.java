package mm.www.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthCookieInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        //判断session中的用户信息是否存在，不存在从cookie中获取然后装如session
        /*if(session.getAttribute("user") == null){
            Cookie[] cookies = request.getCookies();
            if(cookies != null && cookies.length > 0){
                for(int i = 0; i < cookies.length; i++){
                    if(cookies[i].getName().equals("sign")){
                        String sign = cookies[i].getValue();
                        User user = Cache.get(sign); //根据签名获取用户的完整信息装如session
                        session.setAttribute("user",user);
                        break;
                    }
                }
            }
        }*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
