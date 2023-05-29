package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Item;

public class ItemDAO extends DAO {
	//全件検索
	public List<Item> findAll() throws Exception {
		List<Item> list = new ArrayList<Item>();

		String sql = "SELECT code, name, price FROM Items ORDER BY code";

		try (
			Connection con = connect();
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");

				list.add(new Item(code, name, price));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("DBエラー");
		}

		return list;
	}

	//コード検索
	public Item findByCode(int _code) throws Exception {
		Item item = null;

		String sql = "SELECT code, name, price FROM Items WHERE code = ?";

		try (
			Connection con = connect();
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setInt(1, _code);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");

				item = new Item(code, name, price);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("DBエラー");
		}

		return item;
	}

}
