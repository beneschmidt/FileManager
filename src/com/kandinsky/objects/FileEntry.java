package com.kandinsky.objects;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

/**
 * Repraesentiert einen anzuzeigenden Eintrag und kapselt dabei die Funktionalit�t die sp�ter
 * auf der Oberfl�che angezeigt werden soll.
 * @author schmidtb
 */
public class FileEntry implements Comparable<FileEntry> {

	private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
	/** Wunderh�bsch */
	private static final ImageIcon FOLDER_ICON = new ImageIcon(new ImageIcon("resources\\folder-7-icon.png").getImage().getScaledInstance(16, 16,
			java.awt.Image.SCALE_SMOOTH));
	private static final ImageIcon TEXT_FILE_ICON = new ImageIcon(new ImageIcon("resources\\text-file-4-icon.png").getImage().getScaledInstance(16, 16,
			java.awt.Image.SCALE_SMOOTH));

	/** gekapselte Datei */
	private File file;

	/**
	 * @param files Dateiliste
	 * @return eine passende FileEntry-Liste, wobei dort in jedem Eintrag eine Datei gekapselt ist.
	 */
	public static List<FileEntry> getFileEntryList(File[] files) {
		List<FileEntry> entries = new LinkedList<FileEntry>();
		for (File currentFile : files) {
			entries.add(new FileEntry(currentFile));
		}
		return entries;
	}

	/**
	 * @param files Dateiliste
	 * @return eine passende FileEntry-Liste, wobei dort in jedem Eintrag eine Datei gekapselt ist.
	 */
	public static List<FileEntry> getFileEntryList(File folder) {
		if (folder.isDirectory())
			return getFileEntryList(folder.listFiles());
		else
			throw new RuntimeException("Geht nicht, kein Verzeichnis");
	}

	public FileEntry(File file) {
		this.file = file;
	}

	public String getName() {
		return file.getName();
	}

	public String getEnding() {
		if (getName().contains("."))
			return getName().substring(getName().lastIndexOf(".") + 1, getName().length());
		else
			return "";
	}

	public String getSize() {
		return ByteToStringHelper.convertToString(file.length());
	}

	public String getDate() {
		return FORMATTER.format(file.lastModified());
	}

	public Long getFullDateAsLong() {
		return file.lastModified();
	}

	public Long getFullSizeAsLong() {
		return file.length();
	}

	public String getType() {
		if (file.isDirectory())
			return "Ordner";
		else if (file.isFile())
			return "Datei";
		else
			return "Unbekannt";
	}

	public String getRights() {
		String rwx = "";
		rwx += file.canRead() ? "r" : "-";
		rwx += file.canWrite() ? "w" : "-";
		rwx += file.canExecute() ? "x" : "-";
		return rwx;
	}

	/**
	 * @return ein passendes Icon
	 */
	public ImageIcon getIcon() {
		if (file.isDirectory())
			return FOLDER_ICON;
		else
			return TEXT_FILE_ICON;
	}

	@Override
	public int compareTo(FileEntry o) {
		return getName().compareTo(o.getName());
	}
}