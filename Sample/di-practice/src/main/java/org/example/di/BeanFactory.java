package org.example.di;

import org.example.annotation.Inject;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class BeanFactory {
    private final Set<Class<?>> clazzs;

    private Map<Class<?>, Object> beans = new HashMap<>();

    public BeanFactory(Set<Class<?>> clazzs) {
        this.clazzs = clazzs;
        init();
    }

    private void init() {
        for (Class<?> clazz : clazzs) {
            Object instance = createInstance(clazz);
            beans.put(clazz, instance);
        }
    }

    private Object createInstance(Class<?> clazz) {
        Constructor<?> constructor = findConstructor(clazz);

        List<Object> parameters = new ArrayList<>();
        for (Class<?> typeClass : constructor.getParameterTypes()) {
            parameters.add(getParameterByClass(typeClass));
        }

        try {
            return constructor.newInstance(parameters.toArray());
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    private Constructor<?> findConstructor(Class<?> clazz) {
        Constructor<?> constructor = BeanFactoryUtils.getInjectedConstructor(clazz);
        if (Objects.nonNull(constructor))
            return constructor;

        return clazz.getConstructors()[0];
    }

    private Object getParameterByClass(Class<?> typeClass) {
        Object instanceBean = getBean(typeClass);
        if (Objects.nonNull((instanceBean))) {
            return instanceBean;
        }
        return createInstance(typeClass);
    }

    public <T> T getBean(Class<T> requireType) {
        return (T) beans.get(requireType);
    }
}
