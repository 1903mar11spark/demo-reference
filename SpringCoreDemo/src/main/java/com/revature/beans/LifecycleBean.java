package com.revature.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Scope(value="prototype") a singleton scoped bean will have its ENTIRE
// lifecycle managed (so destroy and custom destroy will be called)
// prototype scoped beans are released from mgmt as soon as they are ready for use
public class LifecycleBean implements DisposableBean, InitializingBean {

	public LifecycleBean() {
	}

	// rest of my code does not ever call these methods,
	// that's up to the ApplicationContext.

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("after properties set");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy");
	}

	public void defaultInit() {
		System.out.println("custom init method");
	}

	public void defaultDestroy() {
		System.out.println("custom destroy");
	}

}
