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

import org.springmodules.cache.FatalCacheException;

/**
 * <p>
 * Caching interceptor that internally uses a
 * <code>{@link NameMatchCachingModelSource}</code> to retrieve caching
 * models bound to intercepted methods.
 * </p>
 * 
 * @author Alex Ruiz
 * 
 * @see org.springmodules.cache.interceptor.caching.AbstractCachingInterceptor
 */
public final class NameMatchCachingInterceptor extends
    AbstractModelSourceCachingInterceptor {

  /**
   * @see AbstractCachingInterceptor#onAfterPropertiesSet()
   */
  protected void onAfterPropertiesSet() throws FatalCacheException {
    CachingModelSource cachingModelSource = getCachingModelSource();
    if (cachingModelSource == null) {
      NameMatchCachingModelSource newSource = new NameMatchCachingModelSource();
      newSource.setCachingModels(models());
      setCachingModelSource(newSource);
    }
  }

}
