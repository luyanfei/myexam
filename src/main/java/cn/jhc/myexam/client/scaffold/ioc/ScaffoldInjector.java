package cn.jhc.myexam.client.scaffold.ioc;

import cn.jhc.myexam.client.scaffold.ScaffoldApp;
import com.google.gwt.inject.client.Ginjector;

public interface ScaffoldInjector extends Ginjector {

	ScaffoldApp getScaffoldApp();
}
