package yetkiFilter;

import entity.uyeler;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String url = req.getRequestURI();

        uyeler k = (uyeler) req.getSession().getAttribute("valid_user");

        if (k == null) {

            if (url.contains("XHTML") || url.contains("cikis")) {
                res.sendRedirect(req.getContextPath() + "/faces/panel/giris.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            if (url.contains("giris") || url.contains("kayit")) {
                res.sendRedirect(req.getContextPath() + "/faces/panel/film/filmler.xhtml");
            } else if (url.contains("cikis")) {
                req.getSession().invalidate();
                res.sendRedirect(req.getContextPath() + "/faces/index.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        }

    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

}
