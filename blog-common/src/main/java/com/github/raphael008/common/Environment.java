package com.github.raphael008.common;

import com.github.raphael008.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Environment {

    private static ThreadLocal<Environment> threadLocal = new ThreadLocal<>();

    public static Environment get() {
        Environment environment = threadLocal.get();
        if (Objects.isNull(environment)) {
            threadLocal.set(new Environment());
        }
        return threadLocal.get();
    }
    public static void set(Environment environment) {
        threadLocal.set(environment);
    }

    private User user;
}
