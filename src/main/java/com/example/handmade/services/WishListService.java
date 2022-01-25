package com.example.handmade.services;

import com.example.handmade.dao.WishListDAO;
import com.example.handmade.models.WishList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WishListService {
    private WishListDAO wishListDAO;


    public WishList save(WishList wishList) {
        return wishListDAO.save(wishList);
    }

    public Optional<WishList> findById(int id) {
        Optional<WishList> wishList = wishListDAO.findById(id);
        if(!wishListDAO.findById(id).isPresent()){
            throw new NullPointerException("nothing here");
        }
        return wishList;
    }

    public List<WishList> findAll() {
        return wishListDAO.findAll();
    }

    public void deleteById(int id) {
        wishListDAO.deleteById(id);
    }
}
