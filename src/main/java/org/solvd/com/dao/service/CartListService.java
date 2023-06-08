package org.solvd.com.dao.service;

import org.solvd.com.dao.model.CartList;
import org.solvd.com.dao.utils.GenericDao;

import java.util.List;

public class CartListService implements Service<CartList> {

    private final GenericDao<CartList> cartListDao;

    public CartListService(GenericDao<CartList> cartListDao) {
        this.cartListDao = cartListDao;
    }

    @Override
    public CartList findById(int id) {
        return cartListDao.findById(id);
    }

    @Override
    public void insert(CartList entity) {
        cartListDao.insert(entity);
    }

    @Override
    public void update(CartList entity) {
        cartListDao.update(entity);
    }

    @Override
    public List<CartList> getAll() {
        return cartListDao.getAll();
    }

    @Override
    public void delete(CartList entity) {
        cartListDao.delete(entity);
    }
}
