/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
/* 
 * Created on Oct 3, 2005
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
 * Copyright @2005 the original author or authors.
 */
package org.springmodules.cache.interceptor.caching;

import java.lang.reflect.Method;
import java.util.Map;

import org.springmodules.cache.CachingModel;
import org.springmodules.cache.interceptor.NameMatchCacheModelSource;

/**
 * <p>
 * Simple implementation of <code>{@link CachingModelSource}</code> that
 * allows caching models to be matched by registered name.
 * </p>
 * 
 * @author Alex Ruiz
 */
public class NameMatchCachingModelSource implements CachingModelSource {

  private final NameMatchCacheModelSource source;

  public NameMatchCachingModelSource() {
    source = new NameMatchCacheModelSource();
  }

  /**
   * @see CachingModelSource#model(Method, Class)
   */
  public CachingModel model(Method m, Class t) {
    return (CachingModel)source.model(m);
  }

  public void setCachingModels(Map models) {
    source.setModels(models);
  }
}
