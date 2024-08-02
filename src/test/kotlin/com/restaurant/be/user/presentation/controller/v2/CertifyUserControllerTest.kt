package com.restaurant.be.user.presentation.controller.v2

import com.restaurant.be.common.IntegrationTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.transaction.annotation.Transactional

@IntegrationTest
@Transactional
class CertifyUserControllerTest(
    private val mockMvc: MockMvc
)
