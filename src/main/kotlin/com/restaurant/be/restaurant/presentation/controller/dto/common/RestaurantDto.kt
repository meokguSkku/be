package com.restaurant.be.restaurant.presentation.controller.dto.common

import io.swagger.v3.oas.annotations.media.Schema

data class RestaurantDto(
    @Schema(description = "식당 id")
    val id: Long,
    @Schema(description = "식당 대표 이미지 URL")
    val representativeImageUrl: String,
    @Schema(description = "식당 이름")
    val name: String,
    @Schema(description = "식당 평점 평균")
    val ratingAvg: Double,
    @Schema(description = "식당 리뷰 수")
    val reviewCount: Long,
    @Schema(description = "식당 좋아요 수")
    val likeCount: Long,
    @Schema(description = "식당 카테고리")
    val categories: List<String>,
    @Schema(description = "식당 대표 메뉴")
    val representativeMenu: MenuDto?,
    @Schema(description = "식당 대표 리뷰 내용")
    val representativeReviewContent: String?,
    @Schema(description = "식당 좋아요 여부(로그인한 유저)")
    val isLike: Boolean,
    @Schema(description = "식당 할인 내용")
    val discountContent: String?,
    @Schema(description = "longitude")
    val longitude: Double,
    @Schema(description = "latitude")
    val latitude: Double,

    @Schema(description = "네이버 평점 평균")
    val naverRatingAvg: Double,
    @Schema(description = "네이버 리뷰 수")
    val naverReviewCount: Int,

    @Schema(description = "식당 상세 정보")
    val detailInfo: RestaurantDetailDto
)

data class RestaurantDetailDto(
    @Schema(description = "식당 전화번호")
    val contactNumber: String,
    @Schema(description = "식당 주소")
    val address: String,
    @Schema(description = "메뉴 정보")
    val menus: List<MenuDto>
)

data class MenuDto(
    @Schema(description = "메뉴 이름")
    val name: String,
    @Schema(description = "메뉴 가격")
    val price: Int,
    @Schema(description = "메뉴 설명")
    val description: String,
    @Schema(description = "대표 메뉴 여부")
    val isRepresentative: Boolean,
    @Schema(description = "메뉴 이미지 URL")
    val imageUrl: String? = null
)
