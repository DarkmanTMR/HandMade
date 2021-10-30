package com.example.handmade.controllers;

import com.example.handmade.dao.WishListDAO;
import com.example.handmade.models.WishList;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/wishlists")
@CrossOrigin(origins = {"http://localhost:4200"})
public class WishListController {
    private WishListDAO wishListDAO;

    @PostMapping
    private WishList createWishList(@RequestBody WishList wishList){
        return wishListDAO.save(wishList);
    }

    @GetMapping("/{id}")
    public WishList getWishList(@PathVariable int id){
        return  wishListDAO.findById(id).orElse(new WishList(0));
    }

    @GetMapping
    public List<WishList> allWishLists(){
        return wishListDAO.findAll();
    }

   @PatchMapping
    public WishList editWishList(@RequestBody WishList wishListFromRequest){
        WishList wishListFromDB = wishListDAO.getById((wishListFromRequest.getId()));
        return wishListDAO.save(wishListFromDB);
   }

   @DeleteMapping("/{id}")
    public void deleteWishList(@PathVariable int id){
        wishListDAO.deleteById(id);
   }














}
