package com.test.config.service.zkresource.observer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

public class AbstractSubject implements ISubject {

    private List<IObserver> obervers = new ArrayList<IObserver>();

    @Override
    public void register(IObserver observer) {
        Assert.notNull(observer);
        obervers.add(observer);
    }

    @Override
    public void notify(String key, String value) {
        for (IObserver observer : obervers) {
            observer.notifiy(key, value);
        }
    }

}
