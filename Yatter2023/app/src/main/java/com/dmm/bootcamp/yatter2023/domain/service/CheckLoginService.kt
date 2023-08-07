package com.dmm.bootcamp.yatter2023.domain.service

// domain/service/CheckLoginService.kt
interface CheckLoginService {
  suspend fun execute(): Boolean
}