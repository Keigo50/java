package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AQualityDAO;

/**-
 * Servlet implementation class ShowServlet
 */
@WebServlet("/ResultSpending")
public class ResultSpending extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultSpending() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字コードの設定
		request.setCharacterEncoding("UTF-8");

		String strdate = request.getParameter("date");
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String money = request.getParameter("money");
		String payment_source = request.getParameter("payment_source");
		String store_name = request.getParameter("store_name");
		String memo = request.getParameter("memo");

	AQualityDAO.InsertSpending(strdate,category,name, money, payment_source,store_name, memo);


		//結果表示用のJSPへフォワード
		String view = "/WEB-INF/view/SpendingInsert.jsp";
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
