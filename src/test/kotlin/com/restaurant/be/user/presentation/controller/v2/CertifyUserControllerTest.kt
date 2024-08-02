package com.restaurant.be.user.presentation.controller.v2

import com.restaurant.be.common.IntegrationTest
import com.restaurant.be.user.domain.service.v2.CertifyUserService
import com.restaurant.be.user.repository.UserRepository
import com.restaurant.be.user.repository.v2.MemberRepository
import com.restaurant.be.user.repository.v2.certification.CertifyUserRepository
import org.springframework.test.web.servlet.MockMvc
import org.springframework.transaction.annotation.Transactional

@IntegrationTest
@Transactional
class CertifyUserControllerTest (
    private val mockMvc: MockMvc,
){
}