package com.ammar.nutritionanalysis.utils

import android.view.View
import androidx.annotation.LayoutRes
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import kotlinx.android.extensions.LayoutContainer

/**
 * implements [LayoutContainer] so it can cache the viewHolder see [https://github.com/Kotlin/KEEP/blob/master/proposals/android-extensions-entity-caching.md#view-holder-pattern]
 */
class KBaseViewHolder(view: View) : BaseViewHolder(view), LayoutContainer {
    override val containerView: View = view
}

/**
 * convenient class around BaseQuickAdapter
 * use it in case you need to reuse the adapter
 * Note: Need to add `androidExtensions { experimental = true }`
 */
abstract class BaseAdapter<T>(@LayoutRes layoutResId: Int, items: List<T>) :
        BaseQuickAdapter<T, KBaseViewHolder>(
                layoutResId,
                if (items is MutableList<T>) items else items.toMutableList()
        )
