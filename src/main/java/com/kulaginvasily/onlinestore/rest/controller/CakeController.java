package com.kulaginvasily.onlinestore.rest.controller;

import com.kulaginvasily.onlinestore.exception.UserExistException;
import com.kulaginvasily.onlinestore.goods.CakesService;
import com.kulaginvasily.onlinestore.orders.OrderService;
import com.kulaginvasily.onlinestore.rest.dto.Cake;
import com.kulaginvasily.onlinestore.rest.dto.CakeFullInfo;
import com.kulaginvasily.onlinestore.rest.dto.Cakes;
import com.kulaginvasily.onlinestore.rest.dto.order.Order;
import com.kulaginvasily.onlinestore.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
//@RequestMapping("v1/cakes")

public class CakeController {
    private final UserService userService;
    private final Cakes cakeList = new Cakes();
    private static long idCounter = 0;
    private final CakesService cakesService;
    private final OrderService orderService;


    @Autowired
    public CakeController(CakesService cakesService) {
        List<Cake> tmp = new ArrayList<Cake>();
        cakeList.setCakeList(tmp);
        this.cakesService = cakesService;
    }

    @GetMapping(value = "cakes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cakes cakes() {
        return cakesService.getCakes();
    }

    @GetMapping(value = "cake/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CakeFullInfo getCakeById(@PathVariable Long id) {
        return cakesService.getCake(id);
    }

    @PostMapping(path = "cakes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cake> addCake(@RequestBody Cake addCake) {
        addCake.setId(idCounter);
        idCounter++;
        cakeList.getCakeList().add(addCake);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addOrder", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody @Valid Order newOrder) {
        try {
            userService.addUser(newOrder.getUser());
        }
        catch (UserExistException ignored){
        }
        orderService.addOrder(newOrder);
    }

}