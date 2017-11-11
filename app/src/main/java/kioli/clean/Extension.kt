package kioli.clean

import android.view.View

internal fun View.show(isVisible: Boolean) {
    visibility = if (isVisible) {
        View.VISIBLE
    } else {
        View.GONE
    }
}