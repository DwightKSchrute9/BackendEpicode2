package catalogoBibliotecario.epicode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Item> items = new ArrayList<>();
    
    public void addItem(Item item) {
        items.add(item);
    }
    
    public void removeItem1(String ISBN) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getISBN().equals(ISBN)) {
                items.remove(i);
                break;
            }
        }
    }
    
    public List<Item> searchByYear(int year) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getYear() == year) {
            	result.add(item);
            }
            }
            return result;
            }


            public List<Item> searchByAuthor(String author) {
                List<Item> result = new ArrayList<>();
                for (Item item : items) {
                    if (item instanceof Book) {
                        Book book = (Book) item;
                        if (book.getAuthor().equals(author)) {
                            result.add(book);
                        }
                    }
                }
                return result;
            }

            public void removeItem(String ISBN) {
                for (Item item : items) {
                    if (item.getISBN().equals(ISBN)) {
                        items.remove(item);
                        break;
                    }
                }
            }

            public void saveToDisk(String fileName) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    oos.writeObject(items);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @SuppressWarnings("unchecked")
			public void loadFromDisk(String fileName) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                    items = (List<Item>) ois.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

            }

    
