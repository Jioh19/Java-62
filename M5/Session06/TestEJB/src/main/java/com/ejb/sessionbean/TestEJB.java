package com.ejb.sessionbean;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class TestEJB
 */
@WebServlet("/TestEJB")
public class TestEJB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	public CalculadoraBean ejb; // public CalculadoraBean ejb = new CalculadoraBean();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestEJB() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		double result = 0;
		ejb = new CalculadoraBean();
		try {
			String s1 = request.getParameter("num1");
			String s2 = request.getParameter("num2");
			String s3 = request.getParameter("group1");
			if (s1 != null && s2 != null) {
				double num1 = Double.parseDouble(s1); // new Double(s1);
				double num2 = Double.parseDouble(s2);
				if (s3.equals("add")) {
					result = ejb.add(num1, num2);
				} else if (s3.equals("sub")) {
					result = ejb.substract(num1, num2);

				} else if (s3.equals("multi")) {

					result = ejb.multiply(num1, num2);

				} else {

					result = ejb.division(num1, num2);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		request.setAttribute("result", result);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
