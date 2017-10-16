package com.yichen.mmq.dagger2.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by crf on 2017/9/20.
 * company:逸辰
 * qq:952786280
 * feature:
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface ActivityScope {
}
