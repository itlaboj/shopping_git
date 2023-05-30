package bean;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.ItemDAO;

public class ItemListBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		//ItemDAOのインスタンス生成
		ItemDAO dao = new ItemDAO();

		//全商品情報取得
		List<Item> list = dao.findAll();
		
		//リクエスト・オブジェクトに全商品情報を設定
		request.setAttribute("LIST", list);

		//フォワード先のページを返す
		return "/jsp/item_list.jsp";
	}

}
