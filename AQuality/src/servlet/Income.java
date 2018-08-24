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
import dto.IncomeDto;
/**-
 * Servlet implementation class ShowServlet
 */
@WebServlet("/Income")
public class Income extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Income() {
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
			ArrayList<IncomeDto> character = AQualityDAO.searchAllIncome();

			//取得した値をリクエストスコープへ
			for(int i = 0 ; i < character.size() ; i++){

				//スコープ格納用のパラメータ名の作成
				String param = "Chara"+(i + 1);

				//リクエストスコープへ保存
				request.setAttribute(param,character.get(i));

			}


		//結果表示用のJSPへフォワード
		String view = "/WEB-INF/view/Income.jsp";
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
