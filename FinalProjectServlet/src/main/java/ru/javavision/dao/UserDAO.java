package ru.javavision.dao;

import ru.javavision.entity.Role;
import ru.javavision.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * AbstractDAO.java
 * This DAO class provides CRUD database operations for the table book
 * in the database.
 * @author www.codejava.net
 *
 */
public class UserDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public UserDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean save(User user) throws SQLException {
        String sql = "INSERT INTO users (email, first_name, last_name, password, role) VALUES (?, ?, ?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, user.getEmail());
        statement.setString(2, user.getFirstName());
        statement.setString(3, user.getLastName());
        statement.setString(4, user.getPassword());
        statement.setString(5, user.getRole().toString());


        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();

        return rowInserted;
    }

//    public boolean update(User user) throws SQLException {
//        String sql = "UPDATE users SET p VALUES (?, ?, ?, ?, ?)";
//        connect();
//
//        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//        statement.setString(1, user.getEmail());
//        statement.setString(2, user.getFirstName());
//        statement.setString(3, user.getLastName());
//        statement.setString(4, user.getPassword());
//        statement.setString(5, user.getRole().toString());
//
//
//        boolean rowInserted = statement.executeUpdate() > 0;
//        statement.close();
//        disconnect();
//
//        return rowInserted;
//    }

    public Optional<User> findByEmail(String email) {
        User user = new User();
        String sql = "SELECT * FROM users WHERE email = ?";

        try {
            connect();

            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(Role.valueOf(resultSet.getString("role")));
            }

            resultSet.close();
            statement.close();
            disconnect();
        } catch (SQLException e) {
            return Optional.empty();
        }

        return Optional.of(user);
    }

//    public boolean insertBook(Book book) throws SQLException {
//        String sql = "INSERT INTO book (title, author, price) VALUES (?, ?, ?)";
//        connect();
//
//        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//        statement.setString(1, book.getTitle());
//        statement.setString(2, book.getAuthor());
//        statement.setFloat(3, book.getPrice());
//
//        boolean rowInserted = statement.executeUpdate() > 0;
//        statement.close();
//        disconnect();
//        return rowInserted;
//    }
//
//    public List<Book> listAllBooks() throws SQLException {
//        List<Book> listBook = new ArrayList<>();
//
//        String sql = "SELECT * FROM book";
//
//        connect();
//
//        Statement statement = jdbcConnection.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//
//        while (resultSet.next()) {
//            int id = resultSet.getInt("book_id");
//            String title = resultSet.getString("title");
//            String author = resultSet.getString("author");
//            float price = resultSet.getFloat("price");
//
//            Book book = new Book(id, title, author, price);
//            listBook.add(book);
//        }
//
//        resultSet.close();
//        statement.close();
//
//        disconnect();
//
//        return listBook;
//    }
//
//    public boolean deleteBook(Book book) throws SQLException {
//        String sql = "DELETE FROM book where book_id = ?";
//
//        connect();
//
//        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//        statement.setInt(1, book.getId());
//
//        boolean rowDeleted = statement.executeUpdate() > 0;
//        statement.close();
//        disconnect();
//        return rowDeleted;
//    }
//
//    public boolean updateBook(Book book) throws SQLException {
//        String sql = "UPDATE book SET title = ?, author = ?, price = ?";
//        sql += " WHERE book_id = ?";
//        connect();
//
//        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//        statement.setString(1, book.getTitle());
//        statement.setString(2, book.getAuthor());
//        statement.setFloat(3, book.getPrice());
//        statement.setInt(4, book.getId());
//
//        boolean rowUpdated = statement.executeUpdate() > 0;
//        statement.close();
//        disconnect();
//        return rowUpdated;
//    }
//
//    public Book getBook(int id) throws SQLException {
//        Book book = null;
//        String sql = "SELECT * FROM book WHERE book_id = ?";
//
//        connect();
//
//        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//        statement.setInt(1, id);
//
//        ResultSet resultSet = statement.executeQuery();
//
//        if (resultSet.next()) {
//            String title = resultSet.getString("title");
//            String author = resultSet.getString("author");
//            float price = resultSet.getFloat("price");
//
//            book = new Book(id, title, author, price);
//        }
//
//        resultSet.close();
//        statement.close();
//
//        return book;
//    }
}
