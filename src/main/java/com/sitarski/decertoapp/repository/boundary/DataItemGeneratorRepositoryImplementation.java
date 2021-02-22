package com.sitarski.decertoapp.repository.boundary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Repository
@RequestScope
@Qualifier("dataItemGeneratorRepositoryImplementation")
public class DataItemGeneratorRepositoryImplementation implements DataItemRepository<Integer> {

    private static final Logger logger = LoggerFactory.getLogger(DataItemDatabaseRepositoryImplementation.class);

    @Override
    public List<Integer> findRandomElements() {
        List<Integer> randomElements = new Random().ints(5)
                .boxed()
                .collect(Collectors.toList());

        logger.debug("findRandomElements() - randomElements = {}", randomElements);

        return randomElements;
    }
}
