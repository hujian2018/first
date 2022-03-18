/**
 * All rights Reserved, Designed By MiGu
 * Copyright(C)  2018
 * Company       MiGu  Co., Ltd.
 */
package com.blog.aop;

import java.lang.annotation.*;

@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RefreshRssAnnotation {

}
