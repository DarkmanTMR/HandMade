package com.example.handmade.controllers;

import com.example.handmade.dao.WishListDAO;
import com.example.handmade.models.WishList;
import com.example.handmade.services.WishListService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/wishlists")
@CrossOrigin(origins = {"http://localhost:4200"})
public class WishListController {
    private WishListDAO wishListDAO;
    private WishListService wishListService;

    @PostMapping
    private WishList createWishList(@RequestBody WishList wishList){
        return wishListService.save(wishList);
    }

    @GetMapping("/{id}")
    public WishList getWishList(@PathVariable int id){
        return  wishListService.findById(id).orElse(new WishList(0,0));
    }

    @GetMapping
    public List<WishList> allWishLists(){
        return wishListService.findAll();
    }

   @PatchMapping
    public WishList editWishList(@RequestBody WishList wishListFromRequest){
        Optional<WishList> wishListFromDB = wishListService.findById((wishListFromRequest.getId()));
        return wishListService.save(wishListFromRequest);
   }

   @DeleteMapping("/{id}")
    public void deleteWishList(@PathVariable int id){
        wishListService.deleteById(id);
   }



}
