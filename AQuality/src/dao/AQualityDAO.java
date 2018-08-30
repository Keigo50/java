package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import dto.AllDto;
import dto.IncomeDto;
import dto.SpendingDto;

public class AQualityDAO {


	//収入・支出テーブルの中身を全て表示する
		public static ArrayList<AllDto> searchAll(){
			ArrayList<AllDto> resultList = new ArrayList<AllDto>();

			//変数の初期化
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try{

				Class.forName("com.mysql.jdbc.Driver");

				con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/aquality?useSSL=false",
						"keigo",
						"2345");

				String sql = "SELECT * FROM 家計簿 order by 日付 asc";

				pstmt = con.prepareStatement(sql);

				rs = pstmt.executeQuery();

				while(rs.next() == true ){
					String type = rs.getString("種別");
					Date date = rs.getDate("日付");
					String name = rs.getString("品目名");
					String category = rs.getString("カテゴリ");
					String money = rs.getString("金額");
					String payment_destination = rs.getString("入金先");
					String payment_source = rs.getString("支払元");
					String store_name = rs.getString("お店の名前");
					String memo = rs.getString("メモ");
					resultList.add(new AllDto(type,date,category,name,money,payment_destination,payment_source, store_name,memo));
				}

			} catch (ClassNotFoundException e) {
				System.out.println("JDBCドライバが見つかりません。");
				e.printStackTrace();
			} catch (SQLException e){
				System.out.println("DBアクセスに失敗しました。");
				e.printStackTrace();
			} finally {
				try {
					if( rs != null){
						rs.close();
					}
				} catch(SQLException e){
					System.out.println("DB切断時にエラーが発生しました。");
					e.printStackTrace();
				}
				try {
					if( pstmt != null){
						pstmt.close();
					}
				} catch(SQLException e){
					System.out.println("DB切断時にエラーが発生しました。");
					e.printStackTrace();
				}

				try {
					if( con != null){
						con.close();
					}
				} catch (SQLException e){
					System.out.println("DB切断時にエラーが発生しました。");
					e.printStackTrace();
				}
			}

			return resultList;
		}


//収入テーブルの中身を全て表示する
	public static ArrayList<IncomeDto> searchAllIncome(){
		ArrayList<IncomeDto> resultList = new ArrayList<IncomeDto>();

		//変数の初期化
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/aquality?useSSL=false",
					"keigo",
					"2345");

			String sql = "SELECT * FROM 家計簿 where 種別 = '収入'  order by 日付 asc";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next() == true ){
				String type = rs.getString("種別");
				Date date = rs.getDate("日付");
				String category = rs.getString("カテゴリ");
				String money = rs.getString("金額");
				String payment_destination = rs.getString("入金先");
				String memo = rs.getString("メモ");
				resultList.add(new IncomeDto(type,date,category,money,payment_destination, memo));
			}

		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			try {
				if( rs != null){
					rs.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}

		return resultList;
	}


//支出テーブルの中身をすべて表示
	public static ArrayList<SpendingDto> searchAllSpending(){
		ArrayList<SpendingDto> resultList = new ArrayList<SpendingDto>();

		//変数の初期化
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;



		try{

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/aquality?useSSL=false",
					"keigo",
					"2345");

			String sql = "SELECT * FROM 家計簿 where 種別 = '支出'  order by 日付 asc";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next() == true ){
				String type = rs.getString("種別");
				Date date = rs.getDate("日付");
				String category = rs.getString("カテゴリ");
				String name = rs.getString("品目名");
				String money = rs.getString("金額");
				String payment_source = rs.getString("支払元");
				String store_name = rs.getString("お店の名前");
				String memo = rs.getString("メモ");
				resultList.add(new SpendingDto(type,date,category,name,money,payment_source,store_name, memo));
			}

		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			try {
				if( rs != null){
					rs.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}

		return resultList;
	}




	public static  void InsertIncome(String strdate,String category,String money,String payment_destination,String memo){

		Connection con = null;
		PreparedStatement pstmt = null;

		try{

			Class.forName("com.mysql.jdbc.Driver");

	con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/aquality?useSSL=false",
					"keigo",
					"2345");


			String sql = " INSERT INTO 家計簿(種別,日付,カテゴリ,品目名,金額,入金先,支払元,お店の名前,メモ) VALUES(?,?,?,?,?,?,?,?,?);";
			String type = "収入";
			String payment  = "";
			String store  = "";
			String name  = "";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1,type);
			pstmt.setString(2,strdate);
			pstmt.setString(3,category);
			pstmt.setString(4,name);
			pstmt.setString(5,money);
			pstmt.setString(6,payment_destination);
			pstmt.setString(7,payment);
			pstmt.setString(8,store);
			pstmt.setString(9,memo);

			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {

			try {


				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}

	public static  void InsertSpending(String strdate,String category,String name,String money,String payment_source,String store_name,String memo){

		Connection con = null;
		PreparedStatement pstmt = null;

		try{

			Class.forName("com.mysql.jdbc.Driver");

	con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/aquality?useSSL=false",
					"keigo",
					"2345");


			String sql = " INSERT INTO 家計簿(種別,日付,カテゴリ,品目名,金額,入金先,支払元,お店の名前,メモ) VALUES(?,?,?,?,?,?,?,?,?);";
			String type = "支出";
			String payment = "";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1,type);
			pstmt.setString(2,strdate);
			pstmt.setString(3,category);
			pstmt.setString(4,name);
			pstmt.setString(5, money);
			pstmt.setString(6, payment);
			pstmt.setString(7, payment_source);
			pstmt.setString(8, store_name);
			pstmt.setString(9,  memo);

			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {

			try {


				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}




//public static void deleteFate(String Key){
//
//	//変数の初期化
//	Connection con = null;
//	PreparedStatement pstmt = null;
//
//	try{
//		Class.forName("com.mysql.jdbc.Driver");
//
//		con = DriverManager.getConnection(
//				"jdbc:mysql://localhost:3306/TestDB?useSSL=false",
//				"user1",
//				"pass1");
//
//		String sql = "DELETE FROM fate WHERE id = ?;";
//
//		pstmt = con.prepareStatement(sql);
//
//         int key = Integer.parseInt(Key);
//
//		pstmt.setInt(1,key);
//
//		pstmt.executeUpdate();
//
//	} catch (ClassNotFoundException e) {
//		System.out.println("JDBCドライバが見つかりません。");
//		e.printStackTrace();
//	} catch (SQLException e){
//		System.out.println("DBアクセスに失敗しました。");
//		e.printStackTrace();
//	} catch (Exception e){
//		System.out.println("数字を指定してください。");
//	} finally {
//
//		try {
//			if( pstmt != null){
//				pstmt.close();
//			}
//		} catch(SQLException e){
//			System.out.println("DB切断時にエラーが発生しました。");
//			e.printStackTrace();
//		}
//
//		try {
//			if( con != null){
//				con.close();
//			}
//		} catch (SQLException e){
//			System.out.println("DB切断時にエラーが発生しました。");
//			e.printStackTrace();
//		}
//	}
//}
//
//
//public static ArrayList<Income> KeyWordsFate(String KeyWord){
//	ArrayList<Income> result = new ArrayList<Income>();
//
//	//変数の初期化
//	Connection con = null;
//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
//
//	try{
//		Class.forName("com.mysql.jdbc.Driver");
//
//		con = DriverManager.getConnection(
//				"jdbc:mysql://localhost:3306/TestDB?useSSL=false",
//				"user1",
//				"pass1");
//
//		String sql = "select name,race,hougu,cv from fate where name like ?";
//
//		pstmt = con.prepareStatement(sql);
//
//		pstmt.setString(1,KeyWord);
//
//		rs = pstmt.executeQuery();
//
//		while(rs.next() == true){
//			String race = rs.getString("race");
//			String name = rs.getString("name");
//			String hougu = rs.getString("hougu");
//			String cv = rs.getString("cv");
//			result.add(new Income(race,name,hougu,cv));
//		}
//
//	} catch (ClassNotFoundException e) {
//		System.out.println("JDBCドライバが見つかりません。");
//		e.printStackTrace();
//	} catch (SQLException e){
//		System.out.println("DBアクセスに失敗しました。");
//		e.printStackTrace();
//	} catch (Exception e){
//		System.out.println("数字を指定してください。");
//	} finally {
//
//		try {
//			if( pstmt != null){
//				pstmt.close();
//			}
//		} catch(SQLException e){
//			System.out.println("DB切断時にエラーが発生しました。");
//			e.printStackTrace();
//		}
//
//		try {
//			if( con != null){
//				con.close();
//			}
//		} catch (SQLException e){
//			System.out.println("DB切断時にエラーが発生しました。");
//			e.printStackTrace();
//		}
//	}
//	return result;
//}
//

}



