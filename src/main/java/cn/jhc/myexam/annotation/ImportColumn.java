package cn.jhc.myexam.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Field annotated with this annotation means this field can be import from outside datasource, like excel files.
 * The column name is as same as {@link Description} value.  
 * @author luyanfei
 * @see cn.jhc.myexam.annotation.Description
 */
@Target(ElementType.FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ImportColumn {

}
