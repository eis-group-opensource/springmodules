/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
/* 
 * Created on Mar 16, 2006
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
 * Copyright @2006 the original author or authors.
 */
package org.springmodules.cache.config.jboss;

import org.springmodules.cache.config.AbstractCacheManagerAndProviderFacadeParser;
import org.springmodules.cache.provider.jboss.JbossCacheFacade;
import org.springmodules.cache.provider.jboss.JbossCacheManagerFactoryBean;

/**
 * <p>
 * Parses the XML tag "config" when using the XML namespace "jboss". Creates
 * and registers and implementation of
 * <code>{@link org.springmodules.cache.provider.CacheProviderFacade}</code>
 * and a cache manager in the provided registry of bean definitions.
 * </p>
 * 
 * @author Alex Ruiz
 */
public final class JbossCacheFacadeParser extends
    AbstractCacheManagerAndProviderFacadeParser {

  /**
   * @see AbstractCacheManagerAndProviderFacadeParser#getCacheManagerClass()
   */
  protected Class getCacheManagerClass() {
    return JbossCacheManagerFactoryBean.class;
  }

  /**
   * @see org.springmodules.cache.config.AbstractCacheProviderFacadeParser#getCacheProviderFacadeClass()
   */
  protected Class getCacheProviderFacadeClass() {
    return JbossCacheFacade.class;
  }

}
