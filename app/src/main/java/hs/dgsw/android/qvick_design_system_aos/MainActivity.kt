package hs.dgsw.android.qvick_design_system_aos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import hs.dgsw.android.qvick_design_system_aos.ui.component.notification.Notification
import hs.dgsw.android.qvick_design_system_aos.ui.component.textfield.QvickCheckEmailTextField
import hs.dgsw.android.qvick_design_system_aos.ui.foundation.IcNotifications
import hs.dgsw.android.qvick_design_system_aos.ui.theme.QvickdesignsystemAOSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QvickdesignsystemAOSTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val test: MutableState<String> = rememberSaveable {
                        mutableStateOf("")
                    }

                    Column {
                        QvickCheckEmailTextField(
                            text = test.value,
                            onValueChange = { old, new, length ->
                                test.value =
                                    if (new.length > length || new.any { !it.isDigit() }) old else new
                                test.value
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QvickdesignsystemAOSTheme {
        val test = arrayOf<String>("", "", "")
        LazyColumn(
            modifier = Modifier.fillMaxSize(1f),
            content = {
                itemsIndexed(
                    items = test,
                    key = null
                ) { index, item ->
                    Notification(
                        title = "$index",
                        date = "",
                        writer = "이건의",
                        description = "ㄱㅓㄴㅣㄱㅏㅆㅡㄴ ㄱㅗㅇㅈㅣ"
                    ) {
                        IcNotifications(contentDescription = "")
                    }
                }
            }
        )

    }
}