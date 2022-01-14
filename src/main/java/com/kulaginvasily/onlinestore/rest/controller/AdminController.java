package com.kulaginvasily.onlinestore.rest.controller;

import com.kulaginvasily.onlinestore.goods.CakesService;
import com.kulaginvasily.onlinestore.orders.OrderService;
import com.kulaginvasily.onlinestore.rest.dto.CakeFullInfo;
import com.kulaginvasily.onlinestore.rest.dto.order.InOrder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/admin")

public class AdminController {

    private final OrderService orderService;
    private final CakesService cakesService;

    public AdminController(OrderService orderService, CakesService cakesService) {
        this.orderService = orderService;
        this.cakesService = cakesService;
    }

    @GetMapping(value = "/menu")
    public ModelAndView goToMenu(){
        ModelAndView modelAndView = new ModelAndView("menu");
        return modelAndView;
    }



    @GetMapping(value = "/order/{id}")
    public ModelAndView getOrder(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("order");
        modelAndView.addObject("status", new InOrder() );
        modelAndView.addObject("order", orderService.getOrder(id));
        return modelAndView;
    }


    @GetMapping(value = "/order/delete/{id}")
    public RedirectView deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return new RedirectView("/admin/orders");
    }

    @GetMapping(value = "/cakes")
    public ModelAndView getCakes(){
        ModelAndView maw = new ModelAndView("cakes");
        maw.addObject("cakes", cakesService.getCakes().getCakeList());
        return maw;
    }

    @GetMapping(value = "/cake/edit")
    public ModelAndView getCakeForm(){
        ModelAndView maw = new ModelAndView("cakeEditForm");
        maw.addObject("cake", new CakeFullInfo());
        return maw;
    }

    @PostMapping(value = "/cake/edit")
    public RedirectView addCake(CakeFullInfo cake){
        Long id = cakesService.addCake(cake);
        return new RedirectView("/admin/cake/"+id);
    }

    @GetMapping(value = "cake/{id}")
    public ModelAndView getCakeById(@PathVariable Long id) {
        ModelAndView maw = new ModelAndView("cake");
        maw.addObject("cake",cakesService.getCake(id));
        return maw;
    }

    @GetMapping(value = "/cake/delete/{id}")
    public RedirectView deleteCake(@PathVariable Long id){
        cakesService.deleteCake(id);
        return new RedirectView("/admin/cakes");
    }

}