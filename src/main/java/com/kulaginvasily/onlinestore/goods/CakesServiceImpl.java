package com.kulaginvasily.onlinestore.goods;

import com.kulaginvasily.onlinestore.exception.CakeNotFoundException;
import com.kulaginvasily.onlinestore.rest.dto.Cake;
import com.kulaginvasily.onlinestore.rest.dto.CakeFullInfo;
import com.kulaginvasily.onlinestore.rest.dto.Cakes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class CakesServiceImpl implements CakesService{
    private final CakeRepository cakeRepository;
@Autowired
    public CakesServiceImpl(CakeRepository cakeRepository) {
        this.cakeRepository = cakeRepository;
    }
@Override
    public Cakes getCakes(){
    List<CakeEntity> cakeEntityList=cakeRepository.findAll();
    List<Cake>cakeList = cakeEntityList.stream().map(c->{
        Cake cake=new Cake();
        cake.setId(c.getId());
        cake.setCalories(c.getCalories());
        cake.setName(c.getName());
        cake.setImage(c.getImage());
        cake.setWeight(c.getWeight());
        cake.setPrice(c.getPrice());
        return cake;
    }).collect(Collectors.toList());
    Cakes cakes =new Cakes();
    cakes.setCakeList(cakeList);
    return cakes;
    }

    public CakeFullInfo getCake(Long id) {
        return  cakeRepository.findById(id)
                .map(cakeEntity -> {
                    CakeFullInfo cakeFullInfo = new CakeFullInfo();
                    cakeFullInfo.setId(cakeEntity.getId());
                    cakeFullInfo.setCalories(cakeEntity.getCalories());
                    cakeFullInfo.setName(cakeEntity.getName());
                    cakeFullInfo.setImage(cakeEntity.getImage());
                    cakeFullInfo.setPrice(cakeEntity.getPrice());
                    cakeFullInfo.setWeight(cakeEntity.getWeight());
                    cakeFullInfo.setComposition(cakeEntity.getComposition());
                    return cakeFullInfo;
                })
                .orElseThrow(() -> new CakeNotFoundException("Торт не найден"));
    }
    @Override
    public Long addCake(CakeFullInfo cake){
        CakeEntity cakeEntity = new CakeEntity();
        cakeEntity.setCalories(cake.getCalories());
        cakeEntity.setImage(cake.getImage());
        cakeEntity.setComposition(cake.getComposition());
        cakeEntity.setName(cake.getName());
        cakeEntity.setPrice(cake.getPrice());
        cakeEntity.setWeight(cake.getWeight());
        cakeRepository.save(cakeEntity);
        return cakeEntity.getId();
    }


}
