
package catalogoBibliotecario.epicode;

public class Magazine extends Item {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Periodicity periodicity;
	private String editor;
    
    public Magazine(String id, String title, int year, int numberOfPages, Periodicity periodicity) {
        super(id, title, year, numberOfPages);
        this.setPeriodicity(periodicity);
    }
    public enum Periodicity {
        MONTHLY, QUARTERLY, YEARLY
    }
    
    public Magazine(String ISBN, String title, int year, int pages, String editor) {
        super(ISBN, title, year, pages);
        this.editor = editor;
    }
    
    public String getEditor() {
        return editor;
    }

	public Periodicity getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(Periodicity periodicity) {
		this.periodicity = periodicity;
	}
}

  
    
  
