/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
/* 
 * Created on Jan 21, 2006
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
package org.springmodules.cache.config;

import org.w3c.dom.Element;

import org.springmodules.cache.CachingModel;
import org.springmodules.cache.FlushingModel;

/**
 * <p>
 * Creates cache models by parsing an XML element.
 * </p>
 * 
 * @author Alex Ruiz
 */
public interface CacheModelParser {

  /**
   * Creates a new <code>{@link CachingModel}</code> by parsing the given XML
   * element.
   * 
   * @param element
   *          the XML element to parse
   * @return the created caching model
   */
  CachingModel parseCachingModel(Element element);

  /**
   * Creates a new <code>{@link FlushingModel}</code> by parsing the given XML
   * element.
   * 
   * @param element
   *          the XML element to parse
   * @return the created flushing model
   */
  FlushingModel parseFlushingModel(Element element);

}
