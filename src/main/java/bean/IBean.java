package bean;

import javax.servlet.http.HttpServletRequest;

public interface IBean {
	public abstract String execute(HttpServletRequest request) throws Exception;
}
