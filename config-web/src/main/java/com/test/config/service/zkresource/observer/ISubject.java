package com.test.config.service.zkresource.observer;

/**
 * 主題
 * 
 * @author sunday
 *
 */
public interface ISubject {

    /**
     * 注册观察者
     * 
     * @param watcher
     */
    void register(IObserver watcher);

    /**
     * 通知观察者
     * 
     * @param key
     * @param value
     */
    void notify(String key, String value);
}
