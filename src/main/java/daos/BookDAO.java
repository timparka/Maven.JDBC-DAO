package daos;

import models.BookDTO;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements IBookDAO {
    Connection connection = ConnectionFactory.getConnection();
    public BookDTO findById(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM book WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return extractBookFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<BookDTO> findAll() {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM book");
            ResultSet rs = ps.executeQuery();
            List<BookDTO> cars = new ArrayList<>();

            while (rs.next()) {
                BookDTO book = extractBookFromResultSet(rs);
                cars.add(book);
            }
            return cars;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public BookDTO update(BookDTO dto) {
        try {
            PreparedStatement ps = connection
                    .prepareStatement("UPDATE book SET title=?, author=?,genre=?,year_published=?,isbn=? WHERE id=?");
            ps.setString(1, dto.getTitle());
            ps.setString(2, dto.getAuthor());
            ps.setString(3, dto.getGenre());
            ps.setInt(4, dto.getYear_published());
            ps.setString(5, dto.getIsbn());
            ps.setInt(6, dto.getId());

            int i = ps.executeUpdate();
            if (i == 1) {
                return dto;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public BookDTO create(BookDTO dto) {
        try {
            PreparedStatement ps = connection
                    .prepareStatement("insert into book (id,title,author,genre,year_published,isbn) values(?,?,?,?,?,?)");
            ps.setInt(1, dto.getId());
            ps.setString(2, dto.getTitle());
            ps.setString(3, dto.getAuthor());
            ps.setString(4, dto.getGenre());
            ps.setInt(5, dto.getYear_published());
            ps.setString(6, dto.getIsbn());
            int i = ps.executeUpdate();
            if (i == 1) {
                return dto;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void delete(int id) {
        try {
            PreparedStatement ps = connection
                    .prepareStatement("DELETE FROM book WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private BookDTO extractBookFromResultSet(ResultSet rs) throws SQLException {
        BookDTO book = new BookDTO();

        book.setId(rs.getInt("id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setGenre(rs.getString("genre"));
        book.setYear_published(rs.getInt("year_published"));
        book.setIsbn(rs.getString("isbn"));

        return book;
    }
}
