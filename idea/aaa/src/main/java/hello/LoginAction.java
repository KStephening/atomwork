package hello;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @program: aaa
 * @description:
 * @author: PuTao
 * @create: 2018-08-22 16:14
 **/
public class LoginAction extends ActionSupport{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
