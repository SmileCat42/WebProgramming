package controller;

import dao.LoginDAO;
import model.Student;
import jakarta.faces.view.ViewScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("loginBean")
@ViewScoped
public class LoginBean implements Serializable { // @ViewScoped ต้อง implements Serializable ด้วยเสมอ

    private String username;
    private String password;

    // Getter & Setter (สำคัญมาก เพื่อให้หน้า xhtml ดึงค่าไปใช้ได้)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // ย้าย Logic จาก doPost มาไว้ที่นี่
    public String login() {
        try {
            LoginDAO dao = new LoginDAO();
            Student st = dao.login(username, password);

            if (st != null) {
                // เช็คว่า Role เป็น admin หรือไม่
                if ("admin".equalsIgnoreCase(st.getRole())) {
                    FacesContext.getCurrentInstance().getExternalContext()
                            .getSessionMap().put("user", st);
                    return "FrontPage?faces-redirect=true";
                } else {
                    // ถ้าเป็น student แต่พยายามเข้าหน้า admin
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_WARN, "Access Denied", "คุณไม่มีสิทธิ์เข้าใช้งาน (เฉพาะ Admin เท่านั้น)"));
                    return null;
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Username หรือ Password ไม่ถูกต้อง"));
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
