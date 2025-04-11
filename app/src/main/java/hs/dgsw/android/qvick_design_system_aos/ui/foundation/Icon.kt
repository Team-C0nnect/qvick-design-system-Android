package hs.dgsw.android.qvick_design_system_aos.ui.foundation

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import hs.dgsw.android.qvick_design_system_aos.R
import hs.dgsw.android.qvick_design_system_aos.ui.theme.common0

@Composable
fun IcAccount(
    modifier: Modifier = Modifier,
    contentDescription: String?,
    tint: Color = LocalContentColor.current,
) {
    Icon(
        modifier = modifier.size(32.dp),
        painter = painterResource(id = R.drawable.ic_account),
        contentDescription = contentDescription,
        tint = tint
    )
}

@Composable
fun IcEdit(
    modifier: Modifier = Modifier,
    contentDescription: String?,
    tint: Color = LocalContentColor.current,
) {
    Icon(
        modifier = modifier.size(32.dp),
        painter = painterResource(id = R.drawable.ic_edit),
        contentDescription = contentDescription,
        tint = tint
    )
}

@Composable
fun IcHome(
    modifier: Modifier = Modifier,
    contentDescription: String?,
    tint: Color = LocalContentColor.current,
) {
    Icon(
        modifier = modifier.size(32.dp),
        painter = painterResource(id = R.drawable.ic_home),
        contentDescription = contentDescription,
        tint = tint
    )
}

@Composable
fun IcNavigate_before(
    modifier: Modifier = Modifier,
    contentDescription: String?,
    tint: Color = LocalContentColor.current,
) {
    Icon(
        modifier = modifier.size(32.dp),
        painter = painterResource(id = R.drawable.ic_navigate_before),
        contentDescription = contentDescription,
        tint = tint
    )
}

@Composable
fun IcNavigate_next(
    modifier: Modifier = Modifier,
    contentDescription: String?,
    tint: Color = LocalContentColor.current,

    ) {
    Icon(
        modifier = modifier,
        painter = painterResource(id = R.drawable.ic_navigate_next),
        contentDescription = contentDescription,
        tint = tint

    )
}

@Composable
fun IcNone(
    modifier: Modifier = Modifier,
    contentDescription: String?,
    tint: Color = LocalContentColor.current,
) {
    Icon(
        modifier = modifier.size(32.dp),
        painter = painterResource(id = R.drawable.ic_none),
        contentDescription = contentDescription,
        tint = tint
    )
}

@Composable
fun IcNotifications(
    modifier: Modifier = Modifier,
    contentDescription: String?,
    tint: Color = LocalContentColor.current,
) {
    Icon(
        modifier = modifier.size(32.dp),
        painter = painterResource(id = R.drawable.ic_notifications),
        contentDescription = contentDescription,
        tint = tint
    )
}

@Composable
fun IcPerson(
    modifier: Modifier = Modifier,
    contentDescription: String?,
    tint: Color = LocalContentColor.current,
) {
    Icon(
        modifier = modifier.size(32.dp),
        painter = painterResource(id = R.drawable.ic_person),
        contentDescription = contentDescription,
        tint = tint
    )
}