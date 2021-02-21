package com.sitarski.decertoapp.service.control;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@RequestScope
@Service
public class DataOperationImplementation implements DataOperation<Integer> {

    @Override
    public Integer calculate(Collection<Integer> numbers) {

        return Optional.ofNullable(numbers)
                .orElse(Collections.emptyList())
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
