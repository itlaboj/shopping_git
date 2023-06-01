package bean;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	//フィールド
	private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>(); //注文詳細
	
	//カートに追加
	public void addCart(OrderDetail orderDetail) {
		Item item1 = orderDetail.getItem();
		int quantity1 = orderDetail.getQuantity();
		
		OrderDetail o = null;
		
		for (OrderDetail order : orderDetails) {
			Item item2 = order.getItem();
			int quantity2 = order.getQuantity();
			
			if (item1.getCode() == item2.getCode()) {
				o = order;
				break;
			}
		}
		
		if (o == null) {
			orderDetails.add(orderDetail);
		} else {
			o.setQuantity(quantity1 + o.getQuantity());
		}
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
