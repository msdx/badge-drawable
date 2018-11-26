BadgeDrawable
====

[ ![Download](https://api.bintray.com/packages/msdx/maven/badge-drawable/images/download.svg) ](https://bintray.com/msdx/maven/badge-drawable/_latestVersion)

对布局零入侵的高效小红点实现方案。

![截图](./images/screenshot.png)

# 使用说明

## 添加依赖

```groovy
    implementation 'com.githang:badge-drawable:0.2'
```

## 代码调用 

```kotlin
    // 使用原图标 icon 和小红点 badge 创建BadgeDrawable。 badge 可以从xml中定义，也可以是其他自定义的 Drawable 对象。
    val badgeDrawable = BadgeDrawable(icon, badge)
    // 设置 badgeDrawable
    toggle_badge.setCompoundDrawablesWithIntrinsicBounds(badgeDrawable, null, null, null)
    toggle_badge.setOnClickListener {
        // 显示或隐藏小红点
        badgeDrawable.showBadge = !badgeDrawable.showBadge
    }
```