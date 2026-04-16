package controller;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;


@Named("navigationBean")
@SessionScoped // หรือ ViewScoped ตามความเหมาะสม
public class NavigationBean implements Serializable {
    
    // ค่าเริ่มต้นให้เป็นหน้าหลัก
    private String currentPage = "/partial/home.xhtml";

    // Getter
    public String getCurrentPage() {
        return currentPage;
    }
    
    public void navigate(String page) {
    // ถ้า page คือ 'login' มันจะกลายเป็น "/partial/login.xhtml"
    this.currentPage = "/partial/" + page + ".xhtml";
}
}