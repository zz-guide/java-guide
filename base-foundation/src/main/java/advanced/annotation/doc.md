# 注解

# 标准注解

    @Override 标记重写父类方法，没有会编译报错
    @Deprecated 标记过时的方法
    @SuppressWarnings 标记编译器忽略警告
    @FunctionalInterface 标记匿名函数或者函数式接口
    @SafeVarargs 用来抑制可变参数类型不安全

# 元注解

    @Retention 用来定义该注解在哪一个级别可用，在源代码中(SOURCE)、类文件中(CLASS)或者运行时(RUNTIME)。
    @Documented 生成文档信息的时候保留注解，对类作辅助说明

    @Target 用于描述注解的使用范围（即：被描述的注解可以用在什么地方）
    作用：用于描述注解的使用范围（即：被描述的注解可以用在什么地方）
    取值(ElementType)有：
    1.CONSTRUCTOR:用于描述构造器
    2.FIELD:用于描述域
    3.LOCAL_VARIABLE:用于描述局部变量
    4.METHOD:用于描述方法
    5.PACKAGE:用于描述包
    6.PARAMETER:用于描述参数 
    7.TYPE:用于描述类、接口(包括注解类型) 或enum声明

    @Inherited 说明子类可以继承父类中的该注解，表示自动继承注解类型。 如果注解类型声明中存在 @Inherited 元注解，则注解所修饰类的所有子类都将会继承此注解。
    @Repeatable 表示注解可以重复使用

# 说明

    从 Java 7 开始，额外添加了 3 个注解:
    @SafeVarargs - Java 7 开始支持，忽略任何使用参数为泛型变量的方法或构造函数调用产生的警告。
    @FunctionalInterface - Java 8 开始支持，标识一个匿名函数或函数式接口。
    @Repeatable - Java 8 开始支持，标识某注解可以在同一个声明上使用多次。
    提供信息给编译器： 编译器可以利用注解来检测出错误或者警告信息，打印出日志。
    编译阶段时的处理： 软件工具可以用来利用注解信息来自动生成代码、文档或者做其它相应的自动处理。
    运行时处理： 某些注解可以在程序运行的时候接受代码的提取，自动做相应的操作。

# 自定义注解

    // 元注解
    public @interface 注解名称{
    // 属性列表
    }

# APT

    APT即为Annotation Processing Tool，它是javac的一个工具。APT可以用来在编译时扫描和处理注解。通过APT可以获取到注解和被注解对象的相关信息，在拿到这些信息后我们可以根据需求来自动的生成一些代码，省去了手动编写。注意，获取注解及生成代码都是在代码编译时候完成的，相比反射在运行时处理注解大大提高了程序性能。
    1 AbstractProcessor介绍
    Java/Android中，APT主要以继承AbstractProcessor在编译是处理注解的。


    