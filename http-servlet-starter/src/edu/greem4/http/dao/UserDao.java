package edu.greem4.http.dao;

import edu.greem4.http.entity.Gender;
import edu.greem4.http.entity.Role;
import edu.greem4.http.entity.User;
import edu.greem4.http.util.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<Integer, User>{

    private static final UserDao INSTANCE = new UserDao();

    private static final String SAVE_SQL =
            "INSERT INTO users (name, birthday, email, password, role, gender, image) VALUES " + "(?,?,?,?,?,?,?)";
    public static final String GET_BY_EMAIL_AND_PASSWORD_SQL =
            "SELECT * FROM users WHERE email = ? AND password = ?";

    @Override
    @SneakyThrows
    public User save(User entity) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getName());
            preparedStatement.setObject(2, entity.getBirthday());
            preparedStatement.setObject(3, entity.getEmail());
            preparedStatement.setObject(4, entity.getPassword());
            preparedStatement.setObject(5, entity.getRole().name());
            preparedStatement.setObject(6, entity.getGender().name());
            preparedStatement.setObject(7, entity.getImage());

            preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getObject("id", Integer.class));

            return entity;
        }
    }

    @SneakyThrows
    public Optional<User> findByEmailAndPassword(String email, String password) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(GET_BY_EMAIL_AND_PASSWORD_SQL)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            var resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = buildEntity(resultSet);
            }

            return Optional.ofNullable(user);
        }
    }


    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(User entity) {

    }

    public static UserDao getInstance() {
        return INSTANCE;
    }

    private static User buildEntity(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getObject("id", Integer.class))
                .name(resultSet.getObject("name", String.class))
                .birthday(resultSet.getObject("birthday", Date.class).toLocalDate())
                .email(resultSet.getObject("email", String.class))
                .password(resultSet.getObject("password", String.class))
                .role(Role.find(resultSet.getObject("role", String.class)).orElse(null))
                .gender(Gender.valueOf(resultSet.getObject("gender", String.class)))
                .build();
    }
}
