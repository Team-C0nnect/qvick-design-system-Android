package com.hs.dgsw.qvick_design_module.ui.util

fun formattingToDate(date: String?): String {
    return if(date != null) {
        if(date.contains(Pattern.dateRegex)) {
            date.substringBefore("T").replace("-", ". ")
        } else { date }
    } else {
        "정보를 가져올 수 없음"
    }
}