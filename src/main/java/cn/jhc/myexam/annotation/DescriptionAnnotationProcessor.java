package cn.jhc.myexam.annotation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;

@SupportedAnnotationTypes("cn.jhc.myexam.annotation.Description")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class DescriptionAnnotationProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		for(TypeElement typeElement : annotations) {
			String beanClassName = null;
			List<String> propertyNameList = new ArrayList<String>();
			List<String> descriptionList = new ArrayList<String>();
			for(Element element : roundEnv.getElementsAnnotatedWith(typeElement)) {
				propertyNameList.add(element.getSimpleName().toString());
				descriptionList.add(element.getAnnotation(Description.class).value());
				if(beanClassName == null)
					beanClassName = ((TypeElement)element.getEnclosingElement())
						.getQualifiedName().toString();
			}
			try {
				if(beanClassName != null)
					writeDescriptionInfoFile(beanClassName, propertyNameList, descriptionList);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	private void writeDescriptionInfoFile(String beanClassName, List<String> propertyNameList,
			List<String> descriptionList) throws IOException {
		JavaFileObject sourceFile = processingEnv.getFiler()
				.createSourceFile(beanClassName + "DescriptionInfo");
		PrintWriter out = new PrintWriter(sourceFile.openWriter());
		int i = beanClassName.lastIndexOf(".");
		if(i>0) {
			out.println("package " + beanClassName.substring(0,i) + ";");
		}
		out.println("public class " + beanClassName.substring(i+1) + "DescriptionInfo" + " {");
		
	}

}
