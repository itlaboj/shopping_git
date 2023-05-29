package bean;

import javax.servlet.http.HttpServletRequest;

public class ItemListBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		//ItemDAOのインスタンス生成

		//全商品情報取得

		//リクエスト・オブジェクトに全商品情報を設定

		//フォワード先のページを返す
		return "/jsp/item_list.jsp";
	}

}
