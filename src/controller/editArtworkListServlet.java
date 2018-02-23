package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ArtworkItem;

/**
 * Servlet implementation class editArtworkListServlet
 */
@WebServlet("/editArtworkListServlet")
public class editArtworkListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editArtworkListServlet() {
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
		String act = request.getParameter("doThisToItem");
		
		if (act == null) {
			//no button has been selected
			getServletContext().getRequestDispatcher("/viewAllArtworkServlet").forward(request, response);
			
		}else if (act.equals("Delete Selected Artwork Item")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ArtworkItem itemToDelete = dao.searchForArtworkById(tempId);
			dao.deleteArtwork(itemToDelete);
			getServletContext().getRequestDispatcher("/viewAllArtworkServlet").forward(request, response);

			
		}else if (act.equals("Edit Selected Artwork Item")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			System.out.println(tempId);
			ArtworkItem itemToEdit = dao.searchForArtworkById(tempId);
			request.setAttribute("itemToEdit", itemToEdit);
			System.out.println(itemToEdit.toString());
			getServletContext().getRequestDispatcher("/edit-artwork.jsp").forward(request, response);
			
		}else if (act.equals("Add New Artwork Item")) {
			getServletContext().getRequestDispatcher("/addArtwork.html").forward(request, response);
			
		}
	}

}
