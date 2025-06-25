package com.hs.dgsw.qvick_design_module.ui.component.notification

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hs.dgsw.qvick_design_module.ui.util.Pattern.urlRegex
import com.hs.dgsw.qvick_design_module.ui.util.formattingToDate
import hs.dgsw.android.qvick_design_module.ui.foundation.IcNotifications
import hs.dgsw.android.qvick_design_module.ui.theme.common0
import hs.dgsw.android.qvick_design_module.ui.theme.opacity0
import hs.dgsw.android.qvick_design_module.ui.theme.opacity74
import hs.dgsw.android.qvick_design_module.ui.theme.pretendard


@Composable
fun Notification(
    title: String,
    date: String,
    writer: String,
    description: String,
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit,
) {
    val isVisibility = remember {
        mutableStateOf(false)
    }

    Box(
        modifier = modifier
            .animateContentSize()
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(opacity0)
        ) {
            Box(
                modifier = Modifier
                    .clickable { isVisibility.value = !isVisibility.value }
                    .wrapContentWidth()
                    .fillMaxWidth(1F),
            ) {
                Row(
                    modifier = Modifier
                        .wrapContentWidth()
                        .fillMaxWidth(1f)
                        .padding(
                            top = 12.dp,
                            bottom = 12.dp,
                            start = 16.dp,
                            end = 16.dp
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        icon()
                        Column(
                            modifier = Modifier
                                .padding(start = 12.dp)
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = title,
                                modifier = Modifier,
                                style = TextStyle.Default,
                                fontSize = 18.sp,
                                fontFamily = pretendard,
                                fontWeight = FontWeight.SemiBold,
                                color = common0
                            )
                            Spacer(modifier = Modifier.padding(top = 4.dp))
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = formattingToDate(date),
                                    modifier = Modifier,
                                    style = TextStyle.Default,
                                    color = opacity74,
                                    fontSize = 12.sp,
                                    fontFamily = pretendard,
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    text = "작성자 : $writer",
                                    modifier = Modifier
                                        .align(alignment = Alignment.Bottom),
                                    color = opacity74,
                                    fontSize = 12.sp,
                                    fontFamily = pretendard,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                    }
                }
            }

            if (isVisibility.value) {
                DrawLine()
                DescriptionText(
                    description = description
                )
            }
        }
    }
}

@Composable
fun DescriptionText(
    modifier: Modifier = Modifier,
    description: String,
) {
    val uriHandler = LocalUriHandler.current

    val annotationString = reformAnnotatedString(description)

    Column(
        modifier = modifier
            .padding(20.dp)
            .wrapContentWidth()
            .fillMaxWidth(1F)
    ) {
        ClickableText(
            text = annotationString,
            style = TextStyle(fontSize = 16.sp),
            onClick = { link ->
                annotationString.getStringAnnotations("URL", link, link)
                    .firstOrNull()?.let {
                        uriHandler.openUri(it.item)
                    }
            }
        )
    }
}

fun reformAnnotatedString(description: String): AnnotatedString {
    description.replace("\\n", "\n")
    return buildAnnotatedString {
        val urlList = urlRegex.findAll(description).toList()
        var lastIndex = 0
        urlList.forEachIndexed { index, match ->
            val range = match.range
            var url = match.value
            append(description.substring(lastIndex, range.first))
            pushStringAnnotation(tag = "URL", annotation = url)
            withStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    textDecoration = TextDecoration.Underline,
                    fontSize = 16.sp
                )
            ) {
                append(url)
            }
            pop()
            lastIndex = range.last + 1
        }
        append(description.substring(lastIndex, description.length))
    }
}

@Preview(showBackground = true, backgroundColor = 500)
@Composable
fun GreetingPreview() {
    Notification(
        "ㅅㄷㄴㅅ",
        "2025-04-07T16:31:14.654098",
        "이진식",
        "https://kotlinlang.org/docs/sequences.html- '심자1' 도 도담도담에서 신청한 학생만 가능\n- 실습동-기숙사https://kotlinlang.org/docs/sequences.html 간 다리문 개방시간 확인 필수!\n(지정된 시간 외에는 다리문을 개방하지 않습니다.https://kotlinlang.org/docs/sequences.html)"
    ) { IcNotifications(contentDescription = "") }
}

@Composable
fun DrawLine(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .wrapContentWidth()
            .fillMaxWidth(1f)
            .background(Color.White),
    ) {
        drawLine(
            color = common0,
            start = Offset(0f, 0f),
            end = Offset(size.maxDimension, 0f),
            strokeWidth = 0.8.dp.toPx(),
        )
    }
}