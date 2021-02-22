package com.sitarski.decertoapp.service.control;

import java.util.Collection;

public interface DataOperation<T> {

    T calculate(Collection<T> dataCollection);

}
