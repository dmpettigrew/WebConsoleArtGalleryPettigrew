// Melissa Pettigrew
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ArtworkItem;

public class ArtworkHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebConsoleArtGallery");

	public void insertArtwork(ArtworkItem toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();

	}

	public void deleteArtwork(ArtworkItem toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		// The : identifies what follows as a parameter
		ArtworkItem foundArtpiece = em.find(ArtworkItem.class, toDelete.getId());	
		em.remove(foundArtpiece);
		em.getTransaction().commit();
		em.close();

	}

	public List<ArtworkItem> showAllArtwork() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<ArtworkItem> allResults = em.createQuery("select ai from ArtworkItem ai", ArtworkItem.class);
		List<ArtworkItem> allArt = allResults.getResultList();
		em.close();
		return allArt;
	}
	
	public ArtworkItem searchForArtworkById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ArtworkItem foundArtwork = em.find(ArtworkItem.class, idToEdit);
		em.close();
		return foundArtwork;
	}

	public void updateArtwork(ArtworkItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<ArtworkItem> searchForArtworkByArtist(String artistName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		// The : identifies what follows as a parameter
		TypedQuery <ArtworkItem> typedQuery = em.createQuery("select ai from ArtworkItem ai where ai.artistName = :selectedArtist", ArtworkItem.class);
		typedQuery.setParameter("selectedArtist", artistName);
		List<ArtworkItem> result = typedQuery.getResultList();
		em.close();
		
		return result;
	}

	public List<ArtworkItem> searchForItemsByArtworkTitle(String title) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		// The : identifies what follows as a parameter
		TypedQuery <ArtworkItem> typedQuery = em.createQuery("select ai from ArtworkItem ai where ai.title = :selectedTitle", ArtworkItem.class);
		typedQuery.setParameter("selectedTitle", title);
		List<ArtworkItem> result = typedQuery.getResultList();
		em.close();
		return result;
	}

}
