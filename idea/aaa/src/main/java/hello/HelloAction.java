package hello;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: aaa
 * @description:
 * @author: PuTao
 * @create: 2018-08-22 14:46
 **/
public class HelloAction extends ActionSupport {
    HttpServletRequest request = ServletActionContext.getRequest();
    private String  name;


    public String getName() {
        return name;
    }

    private User user;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String execute() {
        request.setAttribute("hello", "hello world!");
        return SUCCESS;
    }

}
