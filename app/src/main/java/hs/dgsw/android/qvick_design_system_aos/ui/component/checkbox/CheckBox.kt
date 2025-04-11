package hs.dgsw.android.qvick_design_system_aos.ui.component.checkbox

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import hs.dgsw.android.qvick_design_system_aos.ui.component.text.LinkText
import hs.dgsw.android.qvick_design_system_aos.ui.component.text.RequiredText
import hs.dgsw.android.qvick_design_system_aos.ui.theme.common0
import hs.dgsw.android.qvick_design_system_aos.ui.theme.common100
import hs.dgsw.android.qvick_design_system_aos.ui.theme.primaryColorBlue500

@Composable
fun MiniTextCheckBox(
    modifier: Modifier = Modifier,
    isChecked: Boolean = false,
    isRequired: Boolean = false,
    content: @Composable () -> Unit,
    action: (Boolean) -> Unit = {},
    checkboxColor: CheckboxColors = CheckboxDefaults.colors(
        checkedColor = primaryColorBlue500,
        uncheckedColor = common0,
        checkmarkColor = common100
    ),
) {
    var checkedStatus by remember {
        mutableStateOf(isChecked)
    }
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkedStatus,
            colors = checkboxColor,
            onCheckedChange = {
                checkedStatus = it
                action(it)
            },
        )
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.Bottom
        ) {
            content()
            if (isRequired) {
                RequiredText()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExampleTestCheckBox() {
    Column {
        MiniTextCheckBox(isRequired = true, content = {
            LinkText(
                text = "개인정보 처리 약관",
                link = "https://github.com/Team-C0nnect/qvick-design-system-AOS",
                style = TextStyle(textDecoration = TextDecoration.Underline, fontSize = 20.sp)

            )
        })
    }

}