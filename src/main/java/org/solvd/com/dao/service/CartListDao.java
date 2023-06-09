package org.solvd.com.dao.service;

import org.solvd.com.dao.exception.DaoException;
import org.solvd.com.dao.model.CartList;
import org.solvd.com.dao.utils.AbstractDao;
import org.solvd.com.dao.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CartListDao extends AbstractDao<CartList> {

    private final String SELECT_BY_ID = "SELECT * FROM CartList WHERE cartId = ? ;";

    private final String DELETE_QUERY = " DELETE FROM CartList WHERE cartId = ? ;";

    public CartList findById(int cartId) {
        CartList cartList = new CartList();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, cartId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                cartList = getCartListFromResultSet(resultSet);
            } else {
                throw new DaoException("No cart list entry was found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cartList;
    }

    public void delete(CartList cartList) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, cartList.getCartId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private CartList getCartListFromResultSet(ResultSet resultSet) throws SQLException {
        CartList cartList = new CartList();
        cartList.setCartId(resultSet.getInt("cartId"));
        cartList.setQuantity(resultSet.getInt("quantity"));
        return cartList;
    }

    @Override
    public List<CartList> getAll() {
        return null;
    }

    @Override
    public CartList insert(CartList entity) {
        return entity;
    }

    @Override
    public CartList update(CartList entity) {
        return entity;
    }

}
