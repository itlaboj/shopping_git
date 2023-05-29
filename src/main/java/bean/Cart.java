package bean;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	//フィールド
	private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>(); //注文詳細
	
	//カートに追加
	public void addCart(OrderDetail orderDetail) {
		orderDetails.add(orderDetail);
	}
	
	//カートから消去
	public void removeCart(int itemIndex) {
		orderDetails.remove(itemIndex);
	}
	
	//カート内の商品の合計
	public int getTotal() {
		int total = 0;

		for (OrderDetail orderDetail : orderDetails) {
			Item item = orderDetail.getItem();
			int price = item.getPrice();
			int quantity = orderDetail.getQuantity();

			total += price * quantity;
		}
		
		return total;
	}

	//アクセッサ・メソッド（セッタ＆ゲッタ）
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
}
