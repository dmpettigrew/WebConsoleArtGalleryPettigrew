package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ArtworkItem;


/**
 * Servlet implementation class editArtworkItemServlet
 */
@WebServlet("/editArtworkItemServlet")
public class editArtworkItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editArtworkItemServlet() {
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
		ArtworkHelper dao = new ArtworkHelper();
		String artworkTitle = request.getParameter("title");
		String artistName = request.getParameter("artistName");
		String mediaType = request.getParameter("media");
		String year = request.getParameter("year");;
		Double valueAmt = Double.parseDouble(request.getParameter("value"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));

		
		ArtworkItem itemToUpdate = dao.searchForArtworkById(tempId);
		itemToUpdate.setTitle(artworkTitle);
		itemToUpdate.setArtistName(artistName);
		itemToUpdate.setMedia(mediaType);
		itemToUpdate.setYear(year);
		itemToUpdate.setValue(valueAmt);
		
		dao.updateArtwork(itemToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllArtworkServlet").forward(request, response);
	}

}
