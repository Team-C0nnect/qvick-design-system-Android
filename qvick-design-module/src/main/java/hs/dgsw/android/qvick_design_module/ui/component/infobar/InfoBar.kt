package hs.dgsw.android.qvick_design_module.ui.component.infobar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hs.dgsw.android.qvick_design_module.ui.foundation.IcNavigate_next
import hs.dgsw.android.qvick_design_module.ui.foundation.IcNotifications
import hs.dgsw.android.qvick_design_module.ui.theme.common0
import hs.dgsw.android.qvick_design_module.ui.theme.opacity0
import hs.dgsw.android.qvick_design_module.ui.theme.pretendard

@Composable
fun InfoBar(
    modifier: Modifier = Modifier,
    context: String,
    startIcon: @Composable () -> Unit,
    endIcon: @Composable () -> Unit,
) {
    Surface(
        modifier = Modifier
            .shadow(
                elevation = 4.dp,
                clip = true,
                shape = RoundedCornerShape(20.dp),
                ambientColor = common0
            )
    ) {
        Row(
            modifier = modifier
                .background(color = opacity0)
                .wrapContentHeight()
                .fillMaxWidth(1f)
                .clip(RoundedCornerShape(16.dp))
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = modifier,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                startIcon()
                Box(Modifier.padding(end = 8.dp))
                Text(
                    text = context,
                    fontSize = 16.sp,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Medium
                )
            }
            endIcon()
        }

    }
}

@Composable
fun ShadowModifier() {
    Row(
        modifier = Modifier
            .shadow(4.dp, CircleShape)
            .offset(x = 5.dp)
            .background(color = opacity0),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "Hello Jetpack Compose",
        )
    }
}

@Preview(showBackground = true, backgroundColor = 500)
@Composable
fun Test() {
    Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
        InfoBar(
            context = "test",
            startIcon = {
                IcNotifications(
                    modifier = Modifier.size(32.dp),
                    contentDescription = ""
                )
            },
            endIcon = { IcNavigate_next(modifier = Modifier.size(32.dp), contentDescription = "") })
        ShadowModifier()
    }
}

//here