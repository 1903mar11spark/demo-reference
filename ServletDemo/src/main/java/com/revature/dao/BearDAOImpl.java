package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Bear;
import com.revature.beans.BearType;
import com.revature.beans.Cave;
import com.revature.util.ConnectionUtil;

public class BearDAOImpl implements BearDAO {

	@Override
	public List<Bear> getBears() {
		List<Bear> bl = new ArrayList<>();
		// try-with-resources... resources will be closed at the end of the block
		// works for all AutoCloseable resources
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			// map the ResultSet onto a list of Bear objects
			String sql = "SELECT B.BEAR_ID, B.BEAR_NAME, B.BIRTHDATE, B.WEIGHT, C.CAVE_ID, C.CAVE_NAME, C.MAX_BEARS, BT.BEAR_TYPE_ID, BT.BEAR_TYPE_NAME "
					+ "FROM BEAR B INNER JOIN BEAR_TYPE BT ON B.BEAR_TYPE_ID = BT.BEAR_TYPE_ID "
					+ "LEFT JOIN CAVE C ON B.CAVE_ID = C.CAVE_ID ORDER BY B.BEAR_ID";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int bearId = rs.getInt("BEAR_ID");
				String bearName = rs.getString("BEAR_NAME");
				double weight = rs.getDouble("WEIGHT");
				LocalDate birthdate = rs.getDate("BIRTHDATE").toLocalDate();
				int caveId = rs.getInt("CAVE_ID");
				String caveName = rs.getString("CAVE_NAME");
				int maxBears = rs.getInt("MAX_BEARS");
				int bearTypeId = rs.getInt("BEAR_TYPE_ID");
				String bearTypeName = rs.getString("BEAR_TYPE_NAME");
				bl.add(new Bear(bearId, bearName, new Cave(caveId, caveName, maxBears),
						new BearType(bearTypeId, bearTypeName), weight, birthdate));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return bl;
	}

	@Override
	public Bear getBearById(int id) {
		Bear b = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			String sql = "SELECT B.BEAR_ID, B.BEAR_NAME, B.BIRTHDATE, B.WEIGHT, C.CAVE_ID, C.CAVE_NAME, C.MAX_BEARS, BT.BEAR_TYPE_ID, BT.BEAR_TYPE_NAME "
					+ "FROM BEAR B INNER JOIN BEAR_TYPE BT ON B.BEAR_TYPE_ID = BT.BEAR_TYPE_ID "
					+ "LEFT JOIN CAVE C ON B.CAVE_ID = C.CAVE_ID " + "WHERE B.BEAR_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id); // we index from 1 in prepared statement placeholders
			ResultSet rs = pstmt.executeQuery(); // if we wanted to change anything, use executeUpdate()
			// map the ResultSet onto a Bear object
			if (rs.next()) {
				int bearId = rs.getInt("BEAR_ID");
				String bearName = rs.getString("BEAR_NAME");
				double weight = rs.getDouble("WEIGHT");
				LocalDate birthdate = rs.getDate("BIRTHDATE").toLocalDate();
				int caveId = rs.getInt("CAVE_ID");
				String caveName = rs.getString("CAVE_NAME");
				int maxBears = rs.getInt("MAX_BEARS");
				int bearTypeId = rs.getInt("BEAR_TYPE_ID");
				String bearTypeName = rs.getString("BEAR_TYPE_NAME");
				b = new Bear(bearId, bearName, new Cave(caveId, caveName, maxBears),
						new BearType(bearTypeId, bearTypeName), weight, birthdate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean createBear(Bear bear) {
		boolean success = false;

		if (bear != null) {

			try (Connection con = ConnectionUtil.getConnectionFromFile()) {

				String sql = "INSERT INTO BEAR (BEAR_NAME, BIRTHDATE, WEIGHT, BEAR_TYPE_ID, CAVE_ID) VALUES (?, ?, ?, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bear.getName());
				pstmt.setDate(2, Date.valueOf(bear.getBirthdate()));
				pstmt.setDouble(3, bear.getWeight());
				pstmt.setInt(4, bear.getBearType().getId());
				pstmt.setInt(5, bear.getCave().getId());
				if (pstmt.executeUpdate() > 0) {
					success = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return success;
	}

	@Override
	public void updateBear(Bear bear) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBear(Bear bear) {
		// TODO Auto-generated method stub

	}

	@Override
	public double feedBear(int bearId, int hiveId, double amt) {
		double amtFed = 0;
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "{call SP_FEED_BEAR(?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, bearId);
			cs.setInt(2, hiveId);
			cs.setDouble(3, amt);
			cs.registerOutParameter(4, java.sql.Types.DECIMAL);
			cs.execute();
			amtFed = cs.getDouble(4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return amtFed;
	}

}
