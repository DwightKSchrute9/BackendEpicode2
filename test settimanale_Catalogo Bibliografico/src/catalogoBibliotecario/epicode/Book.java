

package catalogoBibliotecario.epicode;

public class Book extends Item {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String author;
    private String genre;
    
    public Book() {}
    
    public Book(String ISBN, String title, int year, int pages, String author, String genre) {
        super(ISBN, title, year, pages);
        this.author = author;
        this.genre = genre;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getGenre() {
        return genre;
    }
}
