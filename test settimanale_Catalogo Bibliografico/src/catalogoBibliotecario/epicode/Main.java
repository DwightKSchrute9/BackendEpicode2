package catalogoBibliotecario.epicode;



public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        
        Book book1 = new Book("123", "The Great Gatsby", 1925, 180, "F. Scott Fitzgerald", "Novel");
        Book book2 = new Book("456", "Moby-Dick", 1851, 500, "Herman Melville", "Novel");
        Magazine magazine1 = new Magazine("789", "National Geographic", 2022, 40, Magazine.Periodicity.MONTHLY);
        
        catalog.addItem(book1);
        catalog.addItem(book2);
        catalog.addItem(magazine1);
        
        System.out.println("Search results for year 2025: " + catalog.searchByYear(2025));
        System.out.println("Search results for author 'F. Scott Fitzgerald': " + catalog.searchByAuthor("F. Scott Fitzgerald"));
        
        catalog.saveToDisk("catalog.dat");
        
        catalog.removeItem("456");
        
        System.out.println("Search results after removing an item: " + catalog.searchByYear(1851));
        
        catalog.loadFromDisk("catalog.dat");
        
        System.out.println("Search results after loading from disk: " + catalog.searchByYear(1851));
    }
}
