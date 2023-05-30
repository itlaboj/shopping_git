package bean;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.ItemDAO;

public class OrderListBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		//商品コードを取得
		int code = Integer.parseInt(request.getParameter("CODE"));

		//数量を取得
		int quantity = Integer.parseInt(request.getParameter("QUANTITY"));
		
		//ItemDAOのインスタンスを生成
		ItemDAO dao = new ItemDAO();
		
		//商品コードから商品情報を取得
		Item item = dao.findByCode(code);
		
		//商品情報と数量をカートに入れる準備をする
		OrderDetail orderDetail = new OrderDetail(item, quantity);
		
		HttpSession session = request.getSession(true);
		
		Cart cart = (Cart)session.getAttribute("CART");
		
		if (cart == null) {
			cart = new Cart();
		}
		
		cart.addCart(orderDetail);
		
		session.setAttribute("CART", cart);

		//リクエスト・オブジェクトにカートの注文情報を取得
		List<OrderDetail> details = cart.getOrderDetails();
		
		request.setAttribute("details", details);

		//フォワード先のページを返す
		return "/jsp/order_detail.jsp";
	}

}
