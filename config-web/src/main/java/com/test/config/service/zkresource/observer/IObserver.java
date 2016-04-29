package com.test.config.service.zkresource.observer;

/**
 * 观察者
 * 
 * @author sunday
 *
 */
public interface IObserver {

    /**
     * 通知
     * 
     * @param key
     */
    void notifiy(String key, String value);
}
