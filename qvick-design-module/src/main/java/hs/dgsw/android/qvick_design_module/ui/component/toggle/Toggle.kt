package hs.dgsw.android.qvick_design_module.ui.component.toggle

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import hs.dgsw.android.qvick_design_module.ui.theme.opacity5
import hs.dgsw.android.qvick_design_module.ui.theme.statusInfo

@Composable
fun ToggleSet(
    setLength: Int = 3,
    selected: Int = 0,
    betweenPadding: Dp = 8.dp,
    item: @Composable (Boolean) -> Unit,
) {
    Row(horizontalArrangement = Arrangement.spacedBy(betweenPadding)) {
        repeat(setLength) { index ->
            item(selected == index)
        }
    }
}

@Composable
fun Toggle(
    modifier: Modifier = Modifier,
    selectTint: Color = statusInfo,
    unSelectTint: Color = opacity5,
    isSelect: Boolean = false,
) {
    var tint = unSelectTint
    if (isSelect) {
        tint = selectTint
    }

    Box(
        modifier = modifier
            .background(color = tint)
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun Thread() {
    Column {
        Toggle(
            modifier = Modifier
                .width(width = 12.dp)
                .height(height = 12.dp)
                .clip(CircleShape),
            selectTint = statusInfo,
            unSelectTint = opacity5,
            isSelect = true
        )
        ToggleSet(

        ) { isSelect ->
            Toggle(
                modifier = Modifier
                    .width(width = 12.dp)
                    .height(height = 12.dp)
                    .clip(CircleShape),
                selectTint = statusInfo,
                unSelectTint = opacity5,
                isSelect = isSelect
            )
        }
    }

}