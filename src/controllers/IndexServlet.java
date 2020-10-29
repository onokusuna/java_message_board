package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Message;
import utils.DBUtil;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/Index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
        EntityManager em = DBUtil.createEntityManager();

        List<Message> messages = em.createNamedQuery("getAllMessages", Message.class)
                                   .getResultList();
        /*
         * サーブレットの処理結果としてなんらかの文字を出力する
         * にはgetWriterという名称のメソッドを使用する必要がある。
         */
        //getWriterは、文字テキストをクライアントに送ることができるPrintWriterオブジェクトを戻す。
        //appendは、Char型の文字かCharSequence型の文字列の値を、現在の文字列の後に追加する。
        response.getWriter().append(Integer.valueOf(messages.size()).toString());

        em.close();
	}

}
