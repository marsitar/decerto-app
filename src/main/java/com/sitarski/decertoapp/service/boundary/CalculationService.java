package com.sitarski.decertoapp.service.boundary;


import com.sitarski.decertoapp.repository.boundary.DataItemRepository;
import com.sitarski.decertoapp.service.control.DataOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequestScope
public class CalculationService {

    @Qualifier("dataItemGeneratorRepositoryImplementation")
    private final DataItemRepository<Integer> dataItemGeneratorRepository;

    @Qualifier("dataItemDatabaseRepositoryImplementation")
    private final DataItemRepository<Integer> dataItemDatabaseRepository;

    private final DataOperation<Integer> dataOperation;

    private static final Logger logger = LoggerFactory.getLogger(CalculationService.class);


    public CalculationService(@Qualifier("dataItemGeneratorRepositoryImplementation") DataItemRepository<Integer> dataItemGeneratorRepository, @Qualifier("dataItemDatabaseRepositoryImplementation") DataItemRepository<Integer> dataItemDatabaseRepository, DataOperation<Integer> dataOperation) {
        this.dataItemGeneratorRepository = dataItemGeneratorRepository;
        this.dataItemDatabaseRepository = dataItemDatabaseRepository;
        this.dataOperation = dataOperation;
    }


    public Integer doCalculation() {
        List<Integer> dataFromItemGenerator = dataItemGeneratorRepository.findRandomElements();
        List<Integer> dataFromItemDatabase = dataItemDatabaseRepository.findRandomElements();

        List<Integer> dataConcatenation = Stream.concat(dataFromItemGenerator.stream(), dataFromItemDatabase.stream())
                .collect(Collectors.toList());

        Integer calculationResult = dataOperation.calculate(dataConcatenation);

        logger.debug("doCalculation() - calculationResult = {}", calculationResult);

        return calculationResult;
    }
}
