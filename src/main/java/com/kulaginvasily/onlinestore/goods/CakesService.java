package com.kulaginvasily.onlinestore.goods;

import com.kulaginvasily.onlinestore.rest.dto.Cake;
import com.kulaginvasily.onlinestore.rest.dto.CakeFullInfo;
import com.kulaginvasily.onlinestore.rest.dto.Cakes;

import java.util.List;
import java.util.stream.Collectors;

public interface CakesService {
     Cakes getCakes();
     CakeFullInfo getCake(Long id);
     Long addCake(CakeFullInfo cakeFullInfo);

    void deleteCake(Long id);
}
