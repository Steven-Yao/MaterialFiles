/*
 * Copyright (c) 2019 Hai Zhang <dreaming.in.code.zh@gmail.com>
 * All Rights Reserved.
 */

package me.zhanghai.android.files.compat

import android.graphics.PointF
import android.view.View
import android.view.ViewGroup
import me.zhanghai.java.reflected.ReflectedMethod

@RestrictedHiddenApi
private val isTransformedTouchPointInViewMethod = ReflectedMethod(
    ViewGroup::class.java, "isTransformedTouchPointInView", Float::class.javaPrimitiveType,
    Float::class.javaPrimitiveType, View::class.java, PointF::class.java
)

fun ViewGroup.isTransformedTouchPointInViewCompat(
    x: Float,
    y: Float,
    child: View,
    outLocalPoint: PointF?
): Boolean =
    isTransformedTouchPointInViewMethod.invoke(this, x, y, child, outLocalPoint)
