package com.jmstextbot.dreamteam.repositories;

import com.jmstextbot.dreamteam.entities.CustomerDriver;
import org.springframework.stereotype.Repository;



@Repository
public interface CustomerDriverRepo {

    <S extends CustomerDriver> S insert(S s);

}
