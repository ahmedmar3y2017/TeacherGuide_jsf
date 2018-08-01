import com.app.shared.HibernateUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class test {

    String name = "ahmed ya man ";


    @PostConstruct
    public void init() {
        System.out.println("Done ya man ");
//        HibernateUtil.getSessionFactory();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void actionClicl() {
        System.out.println("Done ya man Click it ");

    }
}
