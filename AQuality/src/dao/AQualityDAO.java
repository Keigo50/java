package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import dto.IncomeDto;

public class AQualityDAO {

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

			String sql = "SELECT * FROM 収入";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next() == true ){
				int id = rs.getInt("ID");
				Date date = rs.getDate("日付");
				String category = rs.getString("カテゴリ");
				String money = rs.getString("金額");
				String payment_destination = rs.getString("入金先");
				String memo = rs.getString("メモ");
				resultList.add(new IncomeDto(id,date,category,money,payment_destination, memo));
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

//	public static  void RegistrationFate(String strRace,String strName,String strHougu,String strCv){
//		//変数の初期化
//
//		//変数の初期化
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try{
//
//			Class.forName("com.mysql.jdbc.Driver");
//
//
//			//②データベースと接続する。
//			//第1引数→jdbc:mysql://[ホスト名orIPアドレス]:[ポート番号]/[データベース名]
//			//第2引数→ユーザ名
//			//第3引数→パスワード
//			con = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/TestDB?useSSL=false",
//					"user1",
//					"pass1");
//
//			//③SQL文を作成する(String型)
//			//?はプレースホルダと言います。
//			//後ほどこの?に値を設定します。
//			String sql = " INSERT INTO fate(race,name,hougu,cv) VALUES(?,?,?,?);";
//
//			//④SQL文を実行するための準備を行う。
//			//ConnectionからPreparedStatementインスタンスを取得する
//			//引数は③で作成したSQL文
//			pstmt = con.prepareStatement(sql);
//
//			//⑤プレースホルダに値を埋め込む
//			//setInt()やsetStringなどテーブルのカラムの型に応じて選ぶ。
//			//第1引数→何番目のプレースホルダか(何番目の?か)
//			//第2引数→埋め込む値
//			//ちなみにStringを渡す際に''で囲む必要はありません。
//			//(setStringメソッドの中で上手いことやってくれてます。)
//
//			pstmt.setString(1,strRace);
//			pstmt.setString(2,strName);
//			pstmt.setString(3, strHougu);
//			pstmt.setString(4, strCv);
//
//			//⑥SQL文を実行し、DBから結果を受領する。
//			//PreparedStatementクラスのexecuteUpdateメソッドを実行することにより、
//			//DBに結果が反映されます。
//			//ちなみに戻り値は更新件数です。
//			pstmt.executeUpdate();
//		} catch (ClassNotFoundException e) {
//			System.out.println("JDBCドライバが見つかりません。");
//			e.printStackTrace();
//		} catch (SQLException e){
//			System.out.println("DBアクセスに失敗しました。");
//			e.printStackTrace();
//		} finally {
//			//⑦DBから切断する
//			try {
//				//nullかチェックしないとNullPointerExceptionが
//				//発生してしまうためチェックしている。
//				if( pstmt != null){
//					pstmt.close();
//				}
//			} catch(SQLException e){
//				System.out.println("DB切断時にエラーが発生しました。");
//				e.printStackTrace();
//			}
//
//			try {
//				if( con != null){
//					con.close();
//				}
//			} catch (SQLException e){
//				System.out.println("DB切断時にエラーが発生しました。");
//				e.printStackTrace();
//			}
//		}
//	}
//
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



