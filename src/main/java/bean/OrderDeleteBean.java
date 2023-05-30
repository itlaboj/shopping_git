package bean;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class OrderDeleteBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		//削除する番号を取得
		int number = Integer.parseInt(request.getParameter("NUMBER"));

		HttpSession session = request.getSession(false);
		
		if (session == null) {
			throw new Exception("エラー");
		}
		
		Cart cart = (Cart)session.getAttribute("CART");
		
		if (cart == null) {
			throw new Exception("エラー");
		}
		
		cart.removeCart(number);
		
//		List<OrderDetail> orderDetails = cart.getOrderDetails();
//		
//		orderDetails.remove(number);
		
		session.setAttribute("CART", cart);

		//リクエスト・オブジェクトにカートの注文情報を取得
		List<OrderDetail> details = cart.getOrderDetails();
		
		//注文情報の合計の値段を取得
		int total = cart.getTotal();
		
		//リクエスト・オブジェクトに表示情報を設定
		request.setAttribute("details", details);
		request.setAttribute("total", total);

		//フォワード先のページを返す
		return "/jsp/order_detail.jsp";
	}

}
