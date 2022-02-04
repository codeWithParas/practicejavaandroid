package test.practice.android_recyclerview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import test.practice.R

private const val VIEW_TOP_MARGIN = 50
private const val DATE_FORMAT_EE_dd_MMM = "EE dd MMM"

class StickHeaderItemDecoration(
    private var context: Context?,
    headerHeight: Int,
    sticky: Boolean,
    @NonNull sectionCallback: SectionCallback
) : ItemDecoration() {
    private val headerOffset: Int = headerHeight
    private val sticky: Boolean = sticky
    private val sectionCallback: SectionCallback = sectionCallback
    private var headerView: View? = null
    private var header: TextView? = null

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val pos = parent.getChildAdapterPosition(view)
        when {
            //Provide margin wherever header comes
            sectionCallback.isSection(pos) && pos == 0 -> outRect.top = headerOffset
            sectionCallback.isSection(pos) && pos > 0 -> {
                outRect.top = VIEW_TOP_MARGIN
            }
        }
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        if (headerView == null) {
            headerView = inflateHeaderView(parent)
            header = (headerView as TextView).findViewById<View>(R.id.textSticky) as TextView
            fixLayoutSize(headerView, parent)
        }
        var previousHeader: CharSequence = ""
        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            val position = parent.getChildAdapterPosition(child)
            val title = sectionCallback.getSectionHeader(position)
            /*context?.let {
                if(title >= LocalDate.now()) {
                    val theme = R.style.ThemeOverlay_BrightSkyGradient
                    val themedContext = ContextThemeWrapper(it, theme)
                    val gradientDrawable = ContextCompat.getDrawable(themedContext, R.drawable.gradient_rectangle)
                    header?.background = gradientDrawable
                    header?.setTextColor(ContextCompat.getColor(it, R.color.white))
                } else {
                    val theme = R.style.ThemeOverlay_IceBlueGradient
                    val themedContext = ContextThemeWrapper(it, theme)
                    val gradientDrawable = ContextCompat.getDrawable(themedContext, R.drawable.gradient_rectangle)
                    header?.background = gradientDrawable
                    header?.setTextColor(ContextCompat.getColor(it, R.color.slate))
                }
            }*/

            val titleDate = title
            header?.text = titleDate
            if (previousHeader != titleDate || sectionCallback.isSection(position)) {
                drawHeader(c, child, headerView)
                previousHeader = titleDate
            } else {
                header?.visibility = View.GONE
            }
        }
    }

    private fun drawHeader(c: Canvas, child: View, headerView: View?) {
        c.save()
        if (sticky) {
            c.translate(0f, Math.max(0, child.top - headerView!!.height).toFloat())
        } else {
            c.translate(0f, (child.top - headerView!!.height).toFloat())
        }
        headerView.draw(c)
        c.restore()
    }

    private fun inflateHeaderView(parent: RecyclerView): View {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.cell_sticky_header, parent, false)
    }

    /**
     * Measures the header view to make sure its size is greater than 0 and will be drawn
     * https://yoda.entelect.co.za/view/9627/how-to-android-recyclerview-item-decorations
     */
    private fun fixLayoutSize(view: View?, parent: ViewGroup) {
        val widthSpec = View.MeasureSpec.makeMeasureSpec(
            parent.width,
            View.MeasureSpec.EXACTLY
        )
        val heightSpec = View.MeasureSpec.makeMeasureSpec(
            parent.height,
            View.MeasureSpec.UNSPECIFIED
        )
        val childWidth = ViewGroup.getChildMeasureSpec(
            widthSpec,
            0 + 0,
            view!!.layoutParams.width
        )
        val childHeight = ViewGroup.getChildMeasureSpec(
            heightSpec,
            0 + 0,
            view.layoutParams.height
        )
        view.measure(childWidth, childHeight)
        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
    }

    interface SectionCallback {
        fun isSection(position: Int): Boolean
        fun getSectionHeader(position: Int): String
    }

}