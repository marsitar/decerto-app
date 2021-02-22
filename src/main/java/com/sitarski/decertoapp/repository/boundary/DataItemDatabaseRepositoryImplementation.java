package com.sitarski.decertoapp.repository.boundary;

import com.sitarski.decertoapp.repository.entity.NumRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequestScope
@Qualifier("dataItemDatabaseRepositoryImplementation")
public class DataItemDatabaseRepositoryImplementation implements DataItemRepository<Integer> {

    private final NumberRecordRepository numberRecordRepository;

    private static final Logger logger = LoggerFactory.getLogger(DataItemDatabaseRepositoryImplementation.class);

    public DataItemDatabaseRepositoryImplementation(NumberRecordRepository numberRecordRepository) {
        this.numberRecordRepository = numberRecordRepository;
    }

    @Override
    public List<Integer> findRandomElements() {
        List<Integer> allNumRecords = numberRecordRepository.findAll().stream()
                .map(NumRecord::getNumber)
                .collect(Collectors.toList());

        Collections.shuffle(allNumRecords);

        List<Integer> randomElements = allNumRecords.subList(0, 5);

        logger.debug("findRandomElements() - randomElements = {}", randomElements);

        return randomElements;
    }
}
