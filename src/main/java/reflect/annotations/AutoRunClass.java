package reflect.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解定义时可以使用java提供的一些元注解对当前注解加以说明限制
 * @Target 用于限定当前注解可以被应用的位置
 *         可被应用的位置都在ElementType(枚举)中定义了
 *         ElementType.TYPE 可以在类上使用当前注解
 *         ElementType.CONSTRUCTOR 可以在构造器上使用
 *         ElementType.METHOD 可以在方法上使用
 *         ElementType.FIELD 可以在字段上使用
 *         ElementType.PARAMETER 可以在参数上使用
 *         ElementType.LOCAL_VARIABLE 可以在局部变量上使用
 *         ElementType.ANNOTATION_TYPE 可以在注解上使用
 *         ElementType.PACKAGE 可以在包上使用
 *  例如:
 *  当前注解仅能应用在类上
 *  @Target(ElementType.TYPE)
 *
 *  当前注解可以应用在类上或属性上
 *  @Target({ElementType.TYPE, ElementType.FIELD})  多项时以数组形式传递
 *
 *
 * @Retention 用于说明当前注解的保留级别，有三个选项
 *            RetentionPolicy.SOURCE       当前注解保留在源代码中
 *            RetentionPolicy.CLASS(默认)   当前注解保留在字节码文件中，但不可被反射机制访问
 *            RetentionPolicy.RUNTIME      当前注解保留在字节码文件中，且可被反射机制访问
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoRunClass {
}
