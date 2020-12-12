package filter;

import bean.EntityRole;
import bean.EntityUser;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Filter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String[] str = request.getRequestURI().split("/");
        switch (str[str.length - 1]) {
            case "list.html":
            case "details.html":{
                requireAuth(request, response, chain);
                break;
            }
            case "add-publ.html":
            case "save-publ.html":
            case "delete-publ.html":{
                requireRole(request, response, chain, EntityRole.admin);
                break;
            }
            case "order.html":
            case "payment.html":
            case "payment-submit":{
                requireRole(request, response, chain, EntityRole.reader);
                break;
            }
            default: {
                super.doFilter(request, response, chain);
                break;
            }
        }
    }

    private void requireAuth(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/client/auth.html");
        } else {
            super.doFilter(request, response, chain);
        }
    }

    private void requireRole(HttpServletRequest request, HttpServletResponse response, FilterChain chain, EntityRole role) throws IOException, ServletException {
        HttpSession session = request.getSession();
        EntityUser user = (EntityUser) session.getAttribute("user");
        if (user == null || user.getRole() != role) {
            response.sendRedirect(request.getContextPath() + "/client/auth.html" );
        } else {
            super.doFilter(request, response, chain);
        }
    }
}