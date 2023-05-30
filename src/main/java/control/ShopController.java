package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.IBean;
import bean.ItemListBean;
import bean.OrderDeleteBean;
import bean.OrderListBean;

/**
 * Servlet implementation class ShopController
 */
@WebServlet("/control")
public class ShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け対策
		request.setCharacterEncoding("UTF-8");

		//リクエスト取得
		String action = request.getParameter("ACTION");

		IBean bean = null;
		String page = "/jsp/error.jsp";

		try {
			if (action.equals("ITEM_LIST")) { //商品一覧表示処理
				bean = new ItemListBean();
			} else if (action.equals("ORDER_DETAIL")) { //商品選択時の処理
				bean = new OrderListBean();
			} else if (action.equals("ORDER_DELETE")) { //商品削除時の処理
				bean = new OrderDeleteBean();
			}

			page = bean.execute(request);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("ERROR_MESSAGE", e.getMessage());
		}

		//フォワード処理
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
