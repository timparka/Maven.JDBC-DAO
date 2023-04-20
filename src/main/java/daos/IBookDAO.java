package daos;

import models.BookDTO;

import java.util.List;

public interface IBookDAO {
    public BookDTO findById(int id);
    public List<BookDTO> findAll();
    public BookDTO update(BookDTO dto);
    public BookDTO create(BookDTO dto);
    public void delete(int id);
}
