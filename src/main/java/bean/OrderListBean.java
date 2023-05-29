package bean;


import javax.servlet.http.HttpServletRequest;

public class OrderListBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws Exception {




		//フォワード先のページを返す
		return "/jsp/order_detail.jsp";
	}

}
