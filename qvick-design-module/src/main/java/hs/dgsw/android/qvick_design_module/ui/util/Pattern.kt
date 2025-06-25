package com.hs.dgsw.qvick_design_module.ui.util

object Pattern {
    val dateRegex = """^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}\.\d{1,6}$""".toRegex()
    val urlRegex = "(https?://\\S+?)(?=\\s|$)".toRegex()
}