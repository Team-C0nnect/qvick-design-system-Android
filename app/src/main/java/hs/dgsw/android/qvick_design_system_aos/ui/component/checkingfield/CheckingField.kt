package hs.dgsw.android.qvick_design_system_aos.ui.component.checkingfield

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hs.dgsw.android.qvick_design_system_aos.ui.component.button.Button12
import hs.dgsw.android.qvick_design_system_aos.ui.foundation.IcNavigate_next
import hs.dgsw.android.qvick_design_system_aos.ui.theme.common100
import hs.dgsw.android.qvick_design_system_aos.ui.theme.opacity0
import hs.dgsw.android.qvick_design_system_aos.ui.theme.pretendard
import hs.dgsw.android.qvick_design_system_aos.ui.theme.statusDestructive
import hs.dgsw.android.qvick_design_system_aos.ui.theme.statusPositive
import hs.dgsw.android.qvick_design_system_aos.util.Pattern
import hs.dgsw.android.qvick_design_system_aos.util.formattingToDate

@Composable
fun CheckingField(
    modifier: Modifier = Modifier,
    isChecked: Boolean = false,
    date: String? = "2025-04-01T17:22:56.640718",
    checking: () -> Unit = {},
) {
    val buttonText: MutableState<String> = remember { mutableStateOf<String>("출석체크 미완료") }
    Surface(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .shadow(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = opacity0)
                .padding(vertical = 20.dp, horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (isChecked) {
                    Button12(
                        modifier = Modifier
                            .height(height = 48.dp)
                            .fillMaxWidth(),
                        text = "출석체크 완료",
                        enabled = false,
                        tint = statusPositive
                    ) {}
                } else {
                    Button12(
                        modifier = Modifier
                            .height(height = 48.dp)
                            .width(207.dp),
                        text = buttonText.value,
                        enabled = true,
                        tint = statusDestructive
                    ) {
                        checking()
                    }
                }

                IcNavigate_next(
                    contentDescription = "", modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(color = common100)
                        .clickable {
                            checking()
                        }
                )
            }
            Spacer(modifier = Modifier.padding(top = 16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = formattingToDate(date),
                    fontSize = 16.sp,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Medium
                )
                if (isChecked) {
                    Text(
                        text = formattingToTime(date),
                        color = statusPositive,
                        fontSize = 24.sp,
                        fontFamily = pretendard,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

private fun formattingToTime(date: String?): String {
    return if (date == null) {
        ""
    } else if (date.contains(Pattern.dateRegex)) {
        val time = date.substringAfter("T").substringBefore(".").split(":")
        "${time[0]}시 ${time[1]}분"
    } else {
        date
    }
}

@Preview(showBackground = true)
@Composable
fun Test() {
    CheckingField()
}