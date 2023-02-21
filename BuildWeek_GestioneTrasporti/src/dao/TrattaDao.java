

package dao;

import java.util.List;

import model.Tratta;

public interface TrattaDao {
    public void save(Tratta tratta);
    public void update(Tratta tratta);
    public void delete(Tratta tratta);
    public Tratta findById(Long id);
	List<Tratta> findAll();
	void save1(Tratta tratta);
	void update1(Tratta tratta);
	void delete1(Tratta tratta);
	void deleteById(Long id);
}
