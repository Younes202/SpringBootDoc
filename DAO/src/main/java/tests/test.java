package tests;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


import Beans.User;
import DAO.DaoFactory;
import DAO.DaoUser;

/**
 * Servlet implementation class test
 */
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private DaoUser userDao;
	  public void init() throws ServletException {
	        DaoFactory daoFactory = DaoFactory.getInstance();
	        this.userDao = daoFactory.getUserrDao();
	    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("users", userDao.show());
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		String name = request.getParameter("name");
		user.setName(name);
		String lastname = request.getParameter("lastname");
		user.setLastname(lastname);
		userDao.adding(user);
		request.setAttribute("users",userDao.show());
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

		
	}

}
