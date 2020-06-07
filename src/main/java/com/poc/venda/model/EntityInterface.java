package com.poc.venda.model;

import java.io.Serializable;

public interface EntityInterface<T, ID extends Serializable> extends Serializable {

    public ID getId();
}
