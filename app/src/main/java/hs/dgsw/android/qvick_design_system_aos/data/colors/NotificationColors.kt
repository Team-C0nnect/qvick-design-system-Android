package hs.dgsw.android.qvick_design_system_aos.data.colors

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color

class NotificationColors(
    val unExpandBackgroundColor : Color,
    val unExpandTitleColor : Color,
    val unExpandIconColor : Color,
    val unExpandWriterColor : Color,
    val unExpandDateColor : Color,
    val expandBackgroundColor : Color,
    val expandTitleColor : Color,
    val expandIconColor : Color,
    val expandWriterColor : Color,
    val expandDateColor : Color,
    val descriptionColor : Color,
    val descriptionBackgroundColor : Color
) {
    @Composable
    internal fun iconColor(expanded: Boolean): State<Color> {
        return rememberUpdatedState(if (expanded) expandIconColor else unExpandIconColor)
    }
}
