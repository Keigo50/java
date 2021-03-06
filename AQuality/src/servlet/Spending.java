package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AQualityDAO;
import dto.SpendingDto;

/**-
 * Servlet implementation class ShowServlet
 */
@WebServlet("/Spending")
public class Spending extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Spending() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字コードの設定
		request.setCharacterEncoding("UTF-8");

		//データベースから値を取得
		ArrayList<SpendingDto> spending = AQualityDAO.searchAllSpending();

		//取得した値をリクエストスコープへ
		for(int i = 0 ; i < spending.size() ; i++){

			//スコープ格納用のパラメータ名の作成
			String param = "Spending"+(i + 1);

			//リクエストスコープへ保存
			request.setAttribute(param,spending.get(i));

		}


		//結果表示用のJSPへフォワード
		String view = "/WEB-INF/view/Spending.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);}

	/**r
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
