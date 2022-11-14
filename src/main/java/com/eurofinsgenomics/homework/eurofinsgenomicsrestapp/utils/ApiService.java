package com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.utils;

import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.util.List;

@Component
public abstract class  ApiService<T> {

    public abstract List<T> getObjectListFromUrl(String var) throws MalformedURLException;

    public abstract T getObjectFromUrl(String var) throws MalformedURLException;

}
