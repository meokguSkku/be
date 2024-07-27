package com.restaurant.be.point.domain

enum class PointDetail(
    val deltaPoint: Long,
    val detail: String
) {
    REGISTER(+50, "다이닝 버디 가입 포인트 지급")
}
