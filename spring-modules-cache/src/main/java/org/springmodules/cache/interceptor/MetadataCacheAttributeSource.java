/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
/*
 * Created on Apr 21, 2006
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 * Copyright @2007 the original author or authors.
 */
package org.springmodules.cache.interceptor;

import org.springframework.aop.support.AopUtils;
import org.springframework.util.Assert;
import org.springmodules.cache.CacheAttribute;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class that finds and holds {@link CacheAttribute} metadata.
 * <p/>
 * Discovered {@link CacheAttribute} are saved in a synchronized hashmap to
 * enhance performances of the framework.
 * <p/>
 * <Strong>Note</Strong> This class does not implement any support for flushing
 * the discovered CacheAttibutes since this is very unlikely to be required.
 *
 * @author Omar Irbouh
 * @author Alex Ruiz
 */
public class MetadataCacheAttributeSource {

	/**
	 * Interface to be implemented by Classes that, given a
	 * {@link java.lang.reflect.Method}, return a
	 * {@link org.springmodules.cache.CacheAttribute} metadata.
	 */
	public interface MetadataFinder {
		CacheAttribute find(Method m);
	}

	public static final Object NULL_ATTRIBUTE = new Object();

	private final Map attributeMap;

	private final MetadataFinder finder;

	public MetadataCacheAttributeSource(MetadataFinder f) {
		Assert.notNull(f, "property 'finder' is required");
		attributeMap = new ConcurrentHashMap(49152); //required capacity retrieved from Hollard project perforamnce testing
		finder = f;
	}

	public CacheAttribute attribute(Method m, Class t) {
		CacheKey key = new CacheKey(m, t);
		Object cached = attributeMap.get(key);
		if (cached != null) return unmaskNull(cached);
		CacheAttribute attribute = retrieve(m, t);
		attributeMap.put(key, maskNull(attribute));
		return attribute;
	}

	private CacheAttribute retrieve(Method m, Class t) {
		Method specificMethod = AopUtils.getMostSpecificMethod(m, t);
		CacheAttribute attribute = finder.find(specificMethod);
		if (attribute != null) return attribute;
		if (specificMethod != m) return finder.find(m);
		return null;
	}

	private Object maskNull(CacheAttribute c) {
		return c == null ? NULL_ATTRIBUTE : c;
	}

	private CacheAttribute unmaskNull(Object o) {
		return o == NULL_ATTRIBUTE ? null : (CacheAttribute) o;
	}

}