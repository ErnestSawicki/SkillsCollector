package pl.com.SkillsCollector.filters;

import pl.com.SkillsCollector.model.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class AuthorizationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String url = req.getServletPath();
        if (url.equals("/register") || url.equals("/login") || url.equals("/logout")){
            chain.doFilter(req, res);
        } else {
            if (req.getSession().getAttribute("user") != null){
                chain.doFilter(req, res);
            } {
                res.sendError(401);
            }
        }


    }
}
