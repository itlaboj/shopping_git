package bean;

import javax.servlet.http.HttpServletRequest;

public class CustomerInputBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		String fruit = request.getParameter("FRUIT");
		
		//フォワード先のページを返す
		return "/jsp/customer_input.jsp#" + fruit;
	}

}
