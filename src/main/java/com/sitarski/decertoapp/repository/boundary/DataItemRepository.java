package com.sitarski.decertoapp.repository.boundary;

import java.util.List;

public interface DataItemRepository<T> {

    List<T> findRandomElements();
}
