package hs.dgsw.android.qvick_design_system_aos.ui.component.notification

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hs.dgsw.android.qvick_design_system_aos.data.colors.NotificationColors
import hs.dgsw.android.qvick_design_system_aos.ui.foundation.IcNotifications
import hs.dgsw.android.qvick_design_system_aos.ui.theme.common0
import hs.dgsw.android.qvick_design_system_aos.ui.theme.opacity0
import hs.dgsw.android.qvick_design_system_aos.ui.theme.opacity100
import hs.dgsw.android.qvick_design_system_aos.ui.theme.opacity74
import hs.dgsw.android.qvick_design_system_aos.ui.theme.pretendard
import hs.dgsw.android.qvick_design_system_aos.ui.theme.primaryColorBlue100
import hs.dgsw.android.qvick_design_system_aos.ui.theme.primaryColorBlue500
import hs.dgsw.android.qvick_design_system_aos.util.formattingToDate

@Composable
fun Notification(
    modifier: Modifier = Modifier,
    title: String? = null,
    date: String,
    writer: String,
    description: String,
    colors: NotificationColors = NotificationDefaults.colors(),
    descriptionVerticalPaddingValues: Arrangement.Vertical = Arrangement.spacedBy(4.dp),
    isShowTitleInDescription: Boolean = true,
    icon: @Composable () -> Unit,
) {
    var isVisibility by remember {
        mutableStateOf(false)
    }
    val iconColor = colors.iconColor(isVisibility).value

    Box(
        modifier = modifier
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(
                    if (isVisibility) {
                        colors.expandBackgroundColor
                    } else {
                        colors.unExpandBackgroundColor
                    }
                )
        ) {
            Box(
                modifier = Modifier
                    .clickable { isVisibility = !isVisibility }
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
                        CompositionLocalProvider(LocalContentColor provides iconColor) {
                            icon()
                        }

                        Column(
                            modifier = Modifier
                                .padding(start = 12.dp)
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = title ?: "제목없는 공지",
                                modifier = Modifier,
                                style = TextStyle.Default,
                                fontSize = 18.sp,
                                fontFamily = pretendard,
                                fontWeight = FontWeight.SemiBold,
                                color = if (isVisibility) {
                                    colors.expandTitleColor
                                } else {
                                    colors.unExpandTitleColor
                                }
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
                                    fontSize = 12.sp,
                                    fontFamily = pretendard,
                                    fontWeight = FontWeight.Medium,
                                    color = if (isVisibility) {
                                        colors.expandDateColor
                                    } else {
                                        colors.unExpandDateColor
                                    }
                                )
                                Text(
                                    text = "작성자 : $writer",
                                    modifier = Modifier
                                        .align(alignment = Alignment.Bottom),
                                    fontSize = 12.sp,
                                    fontFamily = pretendard,
                                    fontWeight = FontWeight.Medium,
                                    color = if (isVisibility) {
                                        colors.expandWriterColor
                                    } else {
                                        colors.unExpandWriterColor
                                    }
                                )
                            }
                        }
                    }
                }

            }
            if (isVisibility) {
                DrawLine()
                DescriptionText(
                    title = if (isShowTitleInDescription) {
                        title
                    } else {
                        null
                    },
                    description = description,
                    colors = colors,
                    verticalPaddingValues = descriptionVerticalPaddingValues,
                    isShowTitleInDescription = isShowTitleInDescription
                ) { isVisibility = !isVisibility }
            }
        }
    }
}


@Composable
fun DescriptionText(
    modifier: Modifier = Modifier,
    title: String? = null,
    description: String,
    colors: NotificationColors,
    verticalPaddingValues: Arrangement.Vertical = Arrangement.spacedBy(4.dp),
    isShowTitleInDescription: Boolean,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .clickable { onClick() }
            .background(colors.descriptionBackgroundColor)
            .padding(20.dp)
            .wrapContentWidth()
            .fillMaxWidth(1F),
        verticalArrangement = verticalPaddingValues
    ) {
        if (isShowTitleInDescription) {
            Text(
                text = title ?: "제목없는 공지",
                fontSize = 16.sp,
                fontFamily = pretendard,
                fontWeight = FontWeight.SemiBold,
                color = colors.descriptionColor
            )
        }

        Text(
            text = description,
            fontSize = 16.sp,
            fontFamily = pretendard,
            fontWeight = FontWeight.Medium,
            color = colors.descriptionColor
        )
    }
}

@Preview(showBackground = true, backgroundColor = 500)
@Composable
fun GreetingPreview() {
    val verticalScrollState = rememberScrollState()
    Column (modifier = Modifier.verticalScroll(verticalScrollState)){
        for (i in 0..100) {
            Notification(
                modifier = Modifier,
                "test",
                "2025-04-07T16:31:14.654098",
                "이진식",
                "대충 디스크립션입니다잉."
            ) { IcNotifications(contentDescription = "") }
        }
    }
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

object NotificationDefaults {
    fun colors(
        unExpandBackgroundColor: Color = opacity0,
        unExpandTitleColor: Color = opacity100,
        unExpandIconColor: Color = opacity100,
        unExpandWriterColor: Color = opacity74,
        unExpandDateColor: Color = opacity74,
        expandBackgroundColor: Color = opacity0,
        expandTitleColor: Color = primaryColorBlue500,
        expandIconColor: Color = primaryColorBlue500,
        expandWriterColor: Color = primaryColorBlue100,
        expandDateColor: Color = primaryColorBlue100,
        descriptionColor: Color = primaryColorBlue500,
        descriptionBackgroundColor: Color = primaryColorBlue100,
    ) = NotificationColors(
        unExpandBackgroundColor = unExpandBackgroundColor,
        unExpandTitleColor = unExpandTitleColor,
        unExpandIconColor = unExpandIconColor,
        unExpandWriterColor = unExpandWriterColor,
        unExpandDateColor = unExpandDateColor,
        expandBackgroundColor = expandBackgroundColor,
        expandTitleColor = expandTitleColor,
        expandIconColor = expandIconColor,
        expandWriterColor = expandWriterColor,
        expandDateColor = expandDateColor,
        descriptionColor = descriptionColor,
        descriptionBackgroundColor = descriptionBackgroundColor
    )
}