#!/bin/bash
GWT_HOME=/opt/gwt-2.5.1
PACKAGE_NAME=myexam-0.1.0.BUILD-SNAPSHOT
java -cp $GWT_HOME/requestfactory-apt.jar:$GWT_HOME/requestfactory-server.jar:target/${PACKAGE_NAME}/WEB-INF/classes/ com.google.web.bindery.requestfactory.apt.ValidationTool .apt_generated cn.jhc.myexam.client.managed.request.ApplicationRequestFactory
