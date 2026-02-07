package controller;

import dao.ResumeDAO;
import model.Resume;
import jakarta.faces.view.ViewScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("resumeBean")
@ViewScoped
public class ResumeBean implements Serializable {

    private Resume resume = new Resume();
    private ResumeDAO dao = new ResumeDAO();

    public List<Resume> getList() {
        try {
            return dao.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    // ---------- CREATE ----------
    public String save() {
        try {
            dao.insert(resume);
            FacesContext.getCurrentInstance()
                .addMessage(null,
                    new FacesMessage("Saved successfully"));
            return "list.xhtml?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance()
                .addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Save failed", null));
            return null;
        }
    }

    // ---------- LOAD FOR EDIT ----------
    public void loadById() {
        try {
            String id = FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getRequestParameterMap().get("id");
            if (id != null) {
                resume = dao.findById(Integer.parseInt(id));
            }
        } catch (Exception e) {
        }
    }

    // ---------- UPDATE ----------
    public String update() {
        try {
            dao.update(resume);
            FacesContext.getCurrentInstance()
                .addMessage(null,
                    new FacesMessage("Updated successfully"));
            return "list.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    // ---------- DELETE ----------
    public void delete(int id) {
        try {
            dao.delete(id);
            FacesContext.getCurrentInstance()
                .addMessage(null,
                    new FacesMessage("Deleted"));
        } catch (Exception e) {
        }
    }

    public Resume getResume() {
        return resume;
    }
}
