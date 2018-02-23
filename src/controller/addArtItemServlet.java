package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ArtworkItem;

/**
 * Servlet implementation class addArtItemServlet
 */
@WebServlet("/addArtItemServlet")
public class addArtItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addArtItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String artworkTitle = request.getParameter("title");
		String artistName = request.getParameter("artistName");
		String mediaType = request.getParameter("media");
		String year = request.getParameter("year");
		String value = request.getParameter("value");
		Double valueAmt = Double.parseDouble(value);
		ArtworkItem ai = new ArtworkItem(artworkTitle, artistName, mediaType, year, valueAmt);
		ArtworkHelper dao = new ArtworkHelper();
		dao.insertArtwork(ai);
		
		getServletContext().getRequestDispatcher("/addArtwork.html").forward(request, response);
	}

}
