package ru.yandex.qatools.allure.annotations;

import ru.yandex.qatools.allure.model.DescriptionType;

import java.lang.annotation.*;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 10.24.13
 *         <p/>
 *         Using this annotaion you can add some text description
 *         to test suite or test case.
 * @see ru.yandex.qatools.allure.model.DescriptionType
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Description {

    String value();

    DescriptionType type() default DescriptionType.TEXT;

}
