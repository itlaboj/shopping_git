package bean;


import javax.servlet.http.HttpServletRequest;

public class OrderListBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		//商品コードを取得
		int code = Integer.parseInt(request.getParameter("CODE"));

		//数量を取得
		int quantity = Integer.parseInt(request.getParameter("QUANTITY"));

		//リクエスト・オブジェクトに商品コードと数量情報を設定
		request.setAttribute("code", code);
		request.setAttribute("quantity", quantity);

		//フォワード先のページを返す
		return "/jsp/order_detail.jsp";
	}

}
