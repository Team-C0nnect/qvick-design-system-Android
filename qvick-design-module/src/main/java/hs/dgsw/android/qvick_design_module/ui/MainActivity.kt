package hs.dgsw.android.qvick_design_module.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import hs.dgsw.android.qvick_design_module.ui.component.notification.Notification
import hs.dgsw.android.qvick_design_module.ui.component.textfield.A
import hs.dgsw.android.qvick_design_module.ui.component.textfield.QvickCheckEmailTextField
import hs.dgsw.android.qvick_design_module.ui.component.textfield.TextField
import hs.dgsw.android.qvick_design_module.ui.foundation.IcNotifications
import hs.dgsw.android.qvick_design_module.ui.theme.QvickdesignsystemAOSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QvickdesignsystemAOSTheme {
                // A surface container using the 'background' color from the theme
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
                        TextField(endIcon = { A() }, startIcon = { A() }, textStyle = TextStyle())
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QvickdesignsystemAOSTheme {
        Greeting("Android")
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
                        date = "2020-2-20",
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