package com.kandinsky.gui.favorites;

import javax.swing.JButton;

import com.kandinsky.objects.FileEntry;

/**
 * Repr�sentiert genau einen Favorite-Eintrag und stellt ihn als einen Button mit passendem Icon dar.
 * @author Benne
 */
public class FavoriteElement extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7975201576957189105L;
	
	/** der FileEntry auf den der Button referenziert */
	private FileEntry fileEntry;
	
	/**
	 * Erstellt den Button und setzt sowohl Text als auch Item daf�r
	 * @param fileEntry
	 */
	public FavoriteElement(FileEntry fileEntry){
		super(fileEntry.getName());
		this.fileEntry = fileEntry;
		this.setIcon(fileEntry.getIcon());
	}
	
	/**
	 * @return den passenden FileEntry
	 */
	public FileEntry getFileEntry(){
		return fileEntry;
	}
	
	@Override
	public String toString() {
		return fileEntry.getName();
	}
}
