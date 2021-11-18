/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package org.springmodules.cache.interceptor;

import java.lang.reflect.Method;

import org.springframework.util.ObjectUtils;

class CacheKey {
    private final Method method;
    private final Class targetClass;

    public CacheKey(Method method, Class targetClass) {
        this.method = method;
        this.targetClass = targetClass;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CacheKey)) {
            return false;
        }
        return (method.equals(((CacheKey)other).method) 
        			&& ObjectUtils.nullSafeEquals(this.targetClass, ((CacheKey)other).targetClass));
    }

    @Override
    public int hashCode() {
        return method.hashCode() * 29 + ObjectUtils.nullSafeHashCode(this.targetClass);
    }
}