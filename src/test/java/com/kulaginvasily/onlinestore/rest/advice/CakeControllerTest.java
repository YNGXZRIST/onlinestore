package com.kulaginvasily.onlinestore.rest.advice;

import com.kulaginvasily.onlinestore.goods.CakesService;
import com.kulaginvasily.onlinestore.rest.controller.CakeController;
import com.kulaginvasily.onlinestore.rest.dto.CakeFullInfo;
import com.kulaginvasily.onlinestore.rest.dto.Cakes;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.test.util.AssertionErrors;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;


//public class CakeControllerTest {
//
//    @Test
//    void testCakes() {
//        Cakes cakes = new Cakes();
//        cakes.setCakeList(Collections.emptyList());
//        CakesService cakesService = Mockito.mock(CakesService.class);
//        Mockito.doReturn(cakes).when(cakesService).getCakes();
//        CakeController cakeController = new CakeController(userService, cakesService);
//        Cakes cakesTest = cakeController.cakes();
//        AssertionErrors.assertEquals("", cakesTest, cakes);
//        Mockito.verify(cakesService, Mockito.times(1)).getCakes();
//    }
//    @Test
//    void testByIdCakes() {
//        CakeFullInfo cakeFullInfo= new CakeFullInfo();
//        CakesService cakesService = Mockito.mock(CakesService.class);
//        Mockito.doReturn(cakeFullInfo).when(cakesService).getCake(any());
//        CakeController cakeController = new CakeController(userService, cakesService);
//        CakeFullInfo cakesTest = cakeController.getCakeById(1L);
//        AssertionErrors.assertEquals("", cakesTest, cakeFullInfo);
//        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
//    Mockito.verify(cakesService,Mockito.times(1)).getCake(argumentCaptor.capture());
//    AssertionErrors.assertEquals("",argumentCaptor.getValue(),1L);
//    }
//}
