package hs.dgsw.android.qvick_design_system_aos.util

fun formattingToDate(date: String?): String {
    return if(date != null) {
        if(date.contains(Pattern.dateRegex)) {
            date.substringBefore("T").replace("-", ". ")
        } else { date }
    } else {
        "정보를 가져올 수 없음"
    }
}