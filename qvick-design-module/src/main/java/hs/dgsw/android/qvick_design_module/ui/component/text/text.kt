package hs.dgsw.android.qvick_design_module.ui.component.text

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import hs.dgsw.android.qvick_design_module.ui.theme.primaryColorBlue500
import hs.dgsw.android.qvick_design_module.ui.theme.statusDestructive

@Composable
fun RequiredText(modifier: Modifier = Modifier, textSize: TextUnit = 16.sp) {
    Text(
        modifier = modifier,
        text = "(필수)",
        fontSize = textSize,
        color = statusDestructive
    )
}

@Composable
fun LinkText(
    modifier: Modifier = Modifier,
    text: String,
    link: String,
    style: TextStyle = TextStyle(
        color = primaryColorBlue500,
        textDecoration = TextDecoration.Underline,
        fontSize = 20.sp
    ),
    tag: String = "URL",
) {
    val annotatedString = buildAnnotatedString {
        pushStringAnnotation(tag = tag, annotation = link)
        withStyle(style = style.toSpanStyle()) {
            append(text)
        }
        pop()
    }
    val uriHandler = LocalUriHandler.current
    ClickableText(
        modifier = modifier,
        text = annotatedString,
        onTextLayout = {}
    ) { offset ->
        annotatedString.getStringAnnotations(tag = tag, start = offset, end = offset)
            .firstOrNull()?.let { stringAnnotation ->
                uriHandler.openUri(stringAnnotation.item)
            }
    }
}
