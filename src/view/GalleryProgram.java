// Melissa Pettigrew
package view;

import java.util.List;
import java.util.Scanner;

import controller.ArtworkHelper;
import model.ArtworkItem;

public class GalleryProgram {

	static Scanner in = new Scanner(System.in);
	static ArtworkHelper ah = new ArtworkHelper();

	private static void addArtwork() {
		// TODO Auto-generated method stub
		System.out.print("Enter an art title: ");
		String title = in.nextLine();
		System.out.print("Enter an artist name: ");
		String artistName = in.nextLine();

		System.out.print("Enter the media type: ");
		String media = in.nextLine();

		System.out.print("Enter the year the artpiece was made: ");
		String year = in.nextLine();

		System.out.print("Enter the value amount of the art piece: ");
		double value = in.nextDouble();

		ArtworkItem toAdd = new ArtworkItem(title, artistName, media, year, value);

		ah.insertArtwork(toAdd);

	}
	private static void editArtworkItem() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Artist");
		System.out.println("2 : Search by Artwork Title");
		int searchBy = in.nextInt();
		in.nextLine();

		List<ArtworkItem> foundArtwork;
		if (searchBy == 1) {
			System.out.print("Enter the Artist's name: ");
			String artistName = in.nextLine();
			foundArtwork = ah.searchForArtworkByArtist(artistName);

		} else {
			System.out.print("Enter the Artwork Title: ");
			String title = in.nextLine();
			foundArtwork = ah.searchForItemsByArtworkTitle(title);
		}

		if (!foundArtwork.isEmpty()) {
			System.out.println("Found Results.");
			for (ArtworkItem a : foundArtwork) {
				System.out.println(a.getId() + " : " + a.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			ArtworkItem toEdit = ah.searchForArtworkById(idToEdit);
			System.out.println("Retrieved " + toEdit.getTitle() + " by " + toEdit.getArtistName());
			System.out.println("1 : Update Artist");
			System.out.println("2 : Update Artwork Title");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Artist Name: ");
				String newArtist = in.nextLine();
				toEdit.setArtistName(newArtist);;
			} else if (update == 2) {
				System.out.print("New Artwork Title: ");
				String newTitle = in.nextLine();
				toEdit.setTitle(newTitle);;
			}

			ah.updateArtwork(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	private static void deleteArtwork() {
		// TODO Auto-generated method stub
		viewGalleryItems();
/*		ArtworkHelper arthelp = new ArtworkHelper();
		arthelp.showAllArtwork();*/
		System.out.print("Enter an art ID to delete: ");
		int id = in.nextInt();
		in.nextLine();
		
		/*System.out.print("Enter an art title to delete: ");
		String title = in.nextLine();
		
		System.out.print("Enter an artist name to delete: ");
		String artistName = in.nextLine();

		System.out.print("Enter the media type to delete: ");
		String media = in.nextLine();

		System.out.print("Enter the art piece year to delete: ");
		String year = in.nextLine();

		System.out.print("Enter the value amount to delete: ");
		double value = in.nextDouble();*/

		ArtworkItem toDelete = new ArtworkItem(id);
		ah.deleteArtwork(toDelete);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		displayMenuOptions();

	}

	public static void displayMenuOptions() {
		boolean continueToView = true;
		System.out.println("--- Welcome to the Art Gallery.---");
		while (continueToView) {
			System.out.println("*  Select what you would like to do:");
			System.out.println("*  1 -- Add a gallery art piece");
			System.out.println("*  2 -- Delete a gallery art piece");
			System.out.println("*  3 -- View gallery pieces");
			System.out.println("*  5 -- Exit the gallery");
			System.out.print("*  Make your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addArtwork();
			} else if (selection == 2) {
				editArtworkItem();
			} else if (selection == 3) {
				deleteArtwork();
			} else if (selection == 4) {
				viewGalleryItems();
			} else {
				System.out.println("Thank you for visitng our gallery.");
				continueToView = false;
			}

		}

	}

	private static void viewGalleryItems() {
		// TODO Auto-generated method stub

		List<ArtworkItem> allArt = ah.showAllArtwork();
		for (ArtworkItem li : allArt) {
			System.out.println(li.returnArtworkDetails());
		}

	}

}