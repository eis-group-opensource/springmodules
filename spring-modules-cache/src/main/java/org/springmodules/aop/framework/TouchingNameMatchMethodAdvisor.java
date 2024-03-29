/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package org.springmodules.aop.framework;

import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.beans.factory.InitializingBean;

/**
 * <p>Convenience class based on NameMatchMethodPointcutAdvisor that
 * has a TouchingAfterReturningAdvice advice.
 * 
 * @author Steven Devijver
 * @since 21-06-2005
 * @see org.springframework.aop.support.NameMatchMethodPointcutAdvisor
 * @see org.springmodules.aop.framework.TouchingAfterReturningAdvice
 */
public class TouchingNameMatchMethodAdvisor extends
		NameMatchMethodPointcutAdvisor {

	private TouchingAfterReturningAdvice advice = null;
	
	public TouchingNameMatchMethodAdvisor() {
		super();
		this.advice = new TouchingAfterReturningAdvice();
		setAdvice(advice);
	}
	
	/**
	 * <p>Property to access the TouchingAfterReturningAdvice
	 * configured with this advisor.
	 * 
	 * <p>To access the [properties] and [ognl] properties of
	 * TouchingAfterReturningAdvice use <code>touchingAdvice.properties</code>
	 * and <code>touchingAdvice.ognl</code>.
	 * 
	 * @return the TouchingAfterReturningAdvice instance
	 */
	public TouchingAfterReturningAdvice getTouchingAdvice() {
		return this.advice;
	}
}
