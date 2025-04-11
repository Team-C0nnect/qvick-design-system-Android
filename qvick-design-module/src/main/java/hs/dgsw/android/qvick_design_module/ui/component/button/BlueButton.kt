package hs.dgsw.android.qvick_design_module.ui.component.button

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hs.dgsw.android.qvick_design_module.R
import hs.dgsw.android.qvick_design_module.ui.theme.common100
import hs.dgsw.android.qvick_design_module.ui.theme.opacity12
import hs.dgsw.android.qvick_design_module.ui.theme.pretendard
import hs.dgsw.android.qvick_design_module.ui.theme.primaryColorBlue500

private const val basicDebounceTime = 30000L

@Composable
fun Button24(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
    text: String,
    debounceTime: Long = basicDebounceTime,
    enabled: Boolean = true,
    action: () -> Unit,
) {
    var lastClickTime by remember { mutableLongStateOf(0L) }
    val buttonColors = ButtonDefaults.buttonColors(
        containerColor = tint,
        contentColor = common100,
        disabledContainerColor = opacity12,
        disabledContentColor = common100
    )
    Button(
        modifier = modifier,
        onClick = {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastClickTime >= debounceTime) {
                lastClickTime = currentTime
                action()
            }
        },
        colors = buttonColors,
        enabled = enabled,
        shape = RoundedCornerShape(24.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier,
            color = common100,
            fontSize = 18.sp,
            fontFamily = pretendard,
            fontWeight = FontWeight.Bold
        )

    }
}

@Composable
fun Button16(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
    text: String,
    debounceTime: Long = basicDebounceTime,
    enabled: Boolean = true,
    action: () -> Unit = {},
) {
    var lastClickTime by remember { mutableLongStateOf(0L) }
    val buttonColors = ButtonDefaults.buttonColors(
        containerColor = tint,
        contentColor = common100,
        disabledContainerColor = opacity12,
        disabledContentColor = common100
    )

    Button(
        modifier = modifier,
        colors = buttonColors,
        onClick = {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastClickTime >= debounceTime) {
                lastClickTime = currentTime
                action()
            }
        },
        enabled = enabled,
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier,
            color = common100,
            fontSize = 18.sp,
            fontFamily = pretendard,
            fontWeight = FontWeight.Bold
        )

    }
}

@Composable
fun Button12(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
    enabled: Boolean = true,
    text: String,
    debounceTime: Long = basicDebounceTime,
    action: () -> Unit = {},
) {
    var lastClickTime by remember { mutableLongStateOf(0L) }
    val buttonColors = ButtonDefaults.buttonColors(
        containerColor = tint,
        contentColor = tint,
        disabledContainerColor = tint,
        disabledContentColor = tint
    )
    Button(
        modifier = modifier,
        onClick = {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastClickTime >= debounceTime) {
                lastClickTime = currentTime
                action()
            }
        },
        colors = buttonColors,
        enabled = enabled,
        shape = RoundedCornerShape(12.dp),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 4.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(
            modifier = Modifier,
            text = text,
            color = common100,
            fontSize = 20.sp,
            fontFamily = pretendard,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun ProfileButton(
    text: String,
    textColor: Color = Color.Black,
    debounceTime: Long = 500L,
    backgroundColor: Color = Color(0xFFF5F5F5),
    iconRes: Int? = null,
    iconTint: Color = Color.Black,
    action: () -> Unit = {},
) {
    var lastClickTime by remember { mutableLongStateOf(0L) }
    Row(
        modifier = Modifier
            .width(320.dp)
            .height(52.dp)
            .shadow(16.dp, shape = RoundedCornerShape(16.dp))
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable(
                onClick = {
                    val currentTime = System.currentTimeMillis()
                    if (currentTime - lastClickTime >= debounceTime) {
                        lastClickTime = currentTime
                        action()
                    }
                },
            )
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            color = textColor,
            fontFamily = pretendard,
            fontWeight = FontWeight.Medium,
        )

        iconRes?.let {
            Icon(
                painter = painterResource(id = it),
                contentDescription = null,
                tint = iconTint
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Test() {
    Column {
        Button16(
            tint = primaryColorBlue500, text = "로그인",
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            debounceTime = 500L
        ) {
            Log.d("taet", "test1")
        }
        Box(modifier = Modifier.padding(5.dp))
        Button24(
            tint = primaryColorBlue500, text = "로그인",
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Log.d("taet", "test2")
        }
        Box(modifier = Modifier.padding(5.dp))
        Button12(
            tint = primaryColorBlue500, text = "로그인",
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            debounceTime = 600000L
        ) {
            Log.d("taet", "test3")
        }
        Box(modifier = Modifier.padding(5.dp))
        ProfileButton(
            text = "버튼 텍스트",
            textColor = Color.Black,
            iconRes = R.drawable.ic_edit,
            iconTint = Color.Black,
            debounceTime = 60000L
        ) {
            Log.d("taet", "test4")
        }
    }
}

