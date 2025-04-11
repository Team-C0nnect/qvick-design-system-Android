package hs.dgsw.android.qvick_design_system_aos.ui.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import hs.dgsw.android.qvick_design_system_aos.R
import hs.dgsw.android.qvick_design_system_aos.ui.theme.colorNull
import hs.dgsw.android.qvick_design_system_aos.ui.theme.opacity74
import hs.dgsw.android.qvick_design_system_aos.ui.theme.primaryColorBlue600
import kotlin.math.abs

@Composable
fun QvickCheckEmailTextField(
    modifier: Modifier = Modifier,
    text: String,
    length: Int = 6,
    charTextField: @Composable (Char, Boolean) -> Unit = { char, isFocused ->
        QvickCharContainer(
            Modifier,
            char,
            isFocused
        )
    },
    onValueChange: (String, String, Int) -> String = { _, new, _ -> new },
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
) {
    BasicTextField(
        modifier = modifier,
        value = text,
        onValueChange = { onValueChange(text, it, length) },
        decorationBox = {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                text.forEachIndexed { index, char ->
                    charTextField(
                        char,
                        index == text.lastIndex,
                    )
                }
                repeat(abs(length - text.length)) {
                    charTextField(
                        ' ',
                        false
                    )
                }
            }
        },
        keyboardOptions = keyboardOptions,
    )
}

@Composable
private fun QvickCharContainer(
    modifier: Modifier = Modifier,
    text: Char,
    isFocused: Boolean,
    width: Dp = 44.dp,
    height: Dp = 56.dp,
) {
    val shape = remember { RoundedCornerShape(4.dp) }

    Box(
        modifier = modifier
            .size(
                width = width,
                height = height,
            )
            .background(
                color = colorNull,
                shape = shape,
            )
            .run {
                if (isFocused) {
                    border(
                        width = 1.dp,
                        color = primaryColorBlue600,
                        shape = shape,
                    )
                } else {
                    border(
                        width = 1.dp,
                        color = opacity74,
                        shape = shape,
                    )
                }
            },
        contentAlignment = Alignment.Center,
    ) {
        Text(text = text.toString())
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldTest() {

    val test: MutableState<String> = rememberSaveable {
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = test.value)
        QvickCheckEmailTextField(
            text = test.value,

            onValueChange = { old, new, length ->
                if (new.length > length || new.any { !it.isDigit() }) old else new
            }
        )
    }
}

@Composable
fun A() {
    Icon(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = ""
    )
}