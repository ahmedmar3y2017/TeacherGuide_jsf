package com.app.beans;

import com.app.Security.SessionUtil;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.IOException;

@ManagedBean
@RequestScoped
public class LoginBean {
    @Size(min = 4, max = 10)
    @NotEmpty
    private String username;

    @Size(min = 4, max = 10)
    @NotEmpty
    private String password;


    public void setUsername(String name) {
        this.username = name;
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void login() {
        if ("admin".equalsIgnoreCase(username) && "admin".equalsIgnoreCase(password)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Congratulations! You've successfully logged in.");
            FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);

        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "That's the wrong password. Hint: BootsFaces rocks!");
            FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
        }
    }

    public void grantPermission() {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        Object adminLoggedIn = session.getAttribute("admin");
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        if (adminLoggedIn == null) {
            try {
                context.redirect("login.xhtml?faces-redirect=true");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public String logout() {
        HttpSession session = SessionUtil.getSession();
        session.invalidate();
        return "index.xhtml?faces-redirected=true";
    }

    public void forgotPassword() {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Default user name: BootsFaces");
        FacesContext.getCurrentInstance().addMessage("loginForm:username", msg);
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Default password: rocks!");
        FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
    }
}
