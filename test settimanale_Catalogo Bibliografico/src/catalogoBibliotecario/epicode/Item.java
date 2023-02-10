


package catalogoBibliotecario.epicode;

import java.io.Serializable;

public class Item implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ISBN;
    private String title;
    private int year;
    private int pages;
    
    public Item() {}
    
    public Item(String ISBN, String title, int year, int pages) {
        this.ISBN = ISBN;
        this.title = title;
        this.year = year;
        this.pages = pages;
    }
    
    public String getISBN() {
        return ISBN;
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getYear() {
        return year;
    }
    
    public int getPages() {
        return pages;
    }
}
