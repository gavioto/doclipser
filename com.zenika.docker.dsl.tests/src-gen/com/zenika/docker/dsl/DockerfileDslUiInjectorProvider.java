/*
* generated by Xtext
*/
package com.zenika.docker.dsl;

import org.eclipse.xtext.junit4.IInjectorProvider;

import com.google.inject.Injector;

public class DockerfileDslUiInjectorProvider implements IInjectorProvider {
	
	public Injector getInjector() {
		return com.zenika.docker.dsl.ui.internal.DockerfileDslActivator.getInstance().getInjector("com.zenika.docker.dsl.DockerfileDsl");
	}
	
}
