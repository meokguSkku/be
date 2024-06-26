package com.restaurant.be.restaurant.repository.dto

import com.restaurant.be.category.domain.entity.Category
import com.restaurant.be.restaurant.domain.entity.Menu
import com.restaurant.be.restaurant.domain.entity.Restaurant
import com.restaurant.be.restaurant.presentation.controller.dto.common.RestaurantDetailDto
import com.restaurant.be.restaurant.presentation.controller.dto.common.RestaurantDto
import com.restaurant.be.review.domain.entity.Review

data class RestaurantProjectionDto(
    val restaurant: Restaurant,
    val isLike: Boolean,
    val menus: List<Menu>,
    val review: Review?,
    val categories: List<Category>
) {
    fun toDto(): RestaurantDto {
        return RestaurantDto(
            id = restaurant.id,
            representativeImageUrl = restaurant.representativeImageUrl,
            name = restaurant.name,
            ratingAvg = restaurant.ratingAvg,
            reviewCount = restaurant.reviewCount,
            likeCount = restaurant.likeCount,
            categories = categories.map { it.name },
            representativeMenu = menus.firstOrNull()?.toDto(),
            representativeReviewContent = review?.content,
            isLike = isLike,
            discountContent = restaurant.discountContent,
            longitude = restaurant.longitude,
            latitude = restaurant.latitude,
            naverRatingAvg = restaurant.naverRatingAvg,
            naverReviewCount = restaurant.naverReviewCount,
            detailInfo = RestaurantDetailDto(
                contactNumber = restaurant.contactNumber,
                address = restaurant.address,
                menus = menus.map { it.toDto() }
            )
        )
    }
}
