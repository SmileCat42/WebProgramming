package controller;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Named("themeBean")
@SessionScoped
public class ThemeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String theme = "saga";

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
        
        FacesContext context = FacesContext.getCurrentInstance();
    HttpServletResponse response = 
        (HttpServletResponse) context.getExternalContext().getResponse();

    Cookie cookie = new Cookie("theme", theme);
    cookie.setMaxAge(60 * 60 * 24 * 30); // 30 วัน
    cookie.setPath("/");

    response.addCookie(cookie);
    }
    
    @PostConstruct
public void init() {
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request =
        (HttpServletRequest) context.getExternalContext().getRequest();

    if (request.getCookies() != null) {
        for (Cookie c : request.getCookies()) {
            if ("theme".equals(c.getName())) {
                this.theme = c.getValue();
                break;
            }
        }
    }
}
}