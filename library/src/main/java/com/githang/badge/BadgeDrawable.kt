package com.githang.badge

import android.annotation.TargetApi
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.v4.graphics.drawable.DrawableCompat
import android.view.Gravity

/**
 * @author Geek_Soledad (msdx.android@qq.com)
 * @since 0.1
 */
class BadgeDrawable(private val mOrigin: Drawable, val badge: Drawable) : Drawable() {
    var showBadge: Boolean = false
        set(show) {
            field = show
            invalidateSelf()
        }

    var gravity = Gravity.CENTER

    init {
        badge.setBounds(0, 0, badge.intrinsicWidth, badge.intrinsicHeight)
    }

    override fun draw(canvas: Canvas) {
        mOrigin.draw(canvas)
        if (showBadge) {
            val layoutDirection = DrawableCompat.getLayoutDirection(this)
            val absGravity = Gravity.getAbsoluteGravity(gravity, layoutDirection)
            val radiusX = badge.intrinsicWidth / 2.0f
            val radiusY = badge.intrinsicHeight / 2.0f
            var x = bounds.right - radiusX
            var y = bounds.top - radiusY
            if (Gravity.LEFT.and(absGravity) == Gravity.LEFT) {
                x -= radiusX
            }
            if (Gravity.RIGHT.and(absGravity) == Gravity.RIGHT) {
                x += radiusX
            }
            if (Gravity.TOP.and(absGravity) == Gravity.TOP) {
                y -= radiusY
            }
            if (Gravity.BOTTOM.and(absGravity) == Gravity.BOTTOM) {
                y += radiusY
            }
            canvas.save()
            canvas.translate(x, y)
            badge.draw(canvas)
            canvas.restore()
        }
    }

    override fun getState(): IntArray {
        return mOrigin.state
    }

    override fun setState(stateSet: IntArray?): Boolean {
        return mOrigin.setState(stateSet)
    }

    override fun getConstantState(): ConstantState {
        return mOrigin.constantState
    }

    override fun isStateful(): Boolean {
        return mOrigin.isStateful
    }

    override fun jumpToCurrentState() {
        mOrigin.jumpToCurrentState()
    }

    override fun setAlpha(alpha: Int) {
        mOrigin.alpha = alpha
    }

    override fun getOpacity(): Int {
        return mOrigin.opacity
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        mOrigin.colorFilter = colorFilter
    }

    override fun getIntrinsicHeight(): Int {
        return mOrigin.intrinsicHeight
    }

    override fun getIntrinsicWidth(): Int {
        return mOrigin.intrinsicWidth
    }

    override fun setBounds(bounds: Rect?) {
        super.setBounds(bounds)
        mOrigin.bounds = bounds
    }

    override fun setBounds(left: Int, top: Int, right: Int, bottom: Int) {
        super.setBounds(left, top, right, bottom)
        mOrigin.setBounds(left, top, right, bottom)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun setTint(tintColor: Int) {
        super.setTint(tintColor)
        mOrigin.setTint(tintColor)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun setTintList(tint: ColorStateList?) {
        super.setTintList(tint)
        mOrigin.setTintList(tint)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun setTintMode(tintMode: PorterDuff.Mode?) {
        super.setTintMode(tintMode)
        mOrigin.setTintMode(tintMode)
    }
}