package com.jmstextbot.dreamteam.repositories.implementations;

import com.jmstextbot.dreamteam.entities.CustomerDriver;
import com.jmstextbot.dreamteam.repositories.CustomerDriverRepo;
import com.mongodb.MongoWriteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("customerDriverRepo")
public class CustomerDriverRepoImpl implements CustomerDriverRepo {
    private final Logger log = LoggerFactory.getLogger(CustomerDriverRepoImpl.class);

    @Autowired
    MongoTemplate mongoTemplate;


    public <S extends CustomerDriver> S insert(S s) {
        try {
            S outcome = this.mongoTemplate.insert(s);
            return outcome;
        } catch (MongoWriteException mwe) {
            log.info("Failed to write: {}", mwe);
            return null;
        }
    }
}
