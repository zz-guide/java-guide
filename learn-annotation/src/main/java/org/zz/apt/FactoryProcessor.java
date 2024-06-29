package org.zz.apt;//package advanced.annotation.apt;
//
//import advanced.annotation.apt.ann.Factory;
//import com.google.auto.service.AutoService;
//
//import javax.annotation.processing.*;
//import javax.lang.model.SourceVersion;
//import javax.lang.model.element.TypeElement;
//import java.util.LinkedHashMap;
//import java.util.LinkedHashSet;
//import java.util.Set;
//
//@AutoService(Processor.class)
//public class FactoryProcessor extends AbstractProcessor {
//    private Types mTypeUtils;
//    private Messager mMessager;
//    private Filer mFiler;
//    private Elements mElementUtils;
//    private Map<String, FactoryGroupedClasses> factoryClasses = new LinkedHashMap<>();
//
//    @Override
//    public Set<String> getSupportedAnnotationTypes() {
//        Set<String> annotations = new LinkedHashSet<>();
//        annotations.add(Factory.class.getCanonicalName());
//        return annotations;
//    }
//
//    @Override
//    public SourceVersion getSupportedSourceVersion() {
//        return super.getSupportedSourceVersion();
//    }
//
//    @Override
//    public synchronized void init(ProcessingEnvironment processingEnv) {
//        super.init(processingEnv);
//        mTypeUtils = processingEnvironment.getTypeUtils();
//        mMessager = processingEnvironment.getMessager();
//        mFiler = processingEnvironment.getFiler();
//        mElementUtils = processingEnvironment.getElementUtils();
//    }
//
//    @Override
//    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
//        return false;
//    }
//}