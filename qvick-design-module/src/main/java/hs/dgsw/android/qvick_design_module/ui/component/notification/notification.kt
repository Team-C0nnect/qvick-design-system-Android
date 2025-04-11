package hs.dgsw.android.qvick_design_module.ui.component.notification

import android.util.Log
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import hs.dgsw.android.qvick_design_module.ui.foundation.IcNotifications
import hs.dgsw.android.qvick_design_module.ui.theme.common0
import hs.dgsw.android.qvick_design_module.ui.theme.opacity0
import hs.dgsw.android.qvick_design_module.ui.theme.opacity74
import hs.dgsw.android.qvick_design_module.ui.theme.pretendard


@Composable
fun Notification(
    modifier: Modifier = Modifier,
    title: String,
    date: String,
    writer: String,
    description: String,
    icon: @Composable () -> Unit,
) {
    val isVisibility = remember {
        mutableStateOf(false)
    }

    Box(
        modifier = modifier
            .padding(start = 30.dp, end = 30.dp)
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(opacity0)
        ) {
            Box(
                modifier = Modifier
                    .clickable {
                        isVisibility.value = !isVisibility.value
                        Log.d("TAG", "clicked Box | isVisibility : $isVisibility")
                    }
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
                            modifier = Modifier.padding(
                                start = 12.dp
                            )
                        ) {
                            Text(
                                text = title,
                                modifier = Modifier,
                                style = TextStyle.Default,
                                fontSize = 18.sp,
                                fontFamily = pretendard,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(modifier = Modifier.padding(top = 4.dp))
                            Text(
                                text = date,
                                modifier = Modifier,
                                style = TextStyle.Default,
                                color = opacity74,
                                fontSize = 12.sp,
                                fontFamily = pretendard,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
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
            if (isVisibility.value) {
                DrawLine()
                DescriptionText(description = description)
            }
        }
    }
}

@Composable
fun DescriptionText(description: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(20.dp)
            .wrapContentWidth()
            .fillMaxWidth(1F)
    ) {
        Text(
            text = description,
            color = common0,
            fontSize = 16.sp,
            fontFamily = pretendard,
            fontWeight = FontWeight.Medium
        )
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

@Preview(showBackground = true, backgroundColor = 500)
@Composable
fun TestNotification() {
    Notification(
        modifier = Modifier,
        "test",
        "0000-00-00",
        "이진식",
        "대충 디스크립션입니다잉."
    ) { IcNotifications(contentDescription = "") }
}