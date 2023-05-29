package bean;

import java.io.Serializable;

public class OrderDetail implements Serializable {
	//フィールド
	private int orderCode; //注文コード
	private Item item; //商品
	private int quantity; //数量

	//コンストラクタ
	public OrderDetail() {

	}

	public OrderDetail(Item item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	public OrderDetail(int orderCode, Item item, int quantity) {
		this.orderCode = orderCode;
		this.item = item;
		this.quantity = quantity;
	}

	//アクセッサ・メソッド（セッタ＆ゲッタ）
	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
