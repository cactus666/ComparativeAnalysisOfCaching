package com.crafttalk.chat.domain.usecase.message

import com.crafttalk.chat.domain.repository.IMessageRepository

class SendMessages constructor(
    private val messageRepository: IMessageRepository
) {

    suspend operator fun invoke(message: String, success: () -> Unit, fail: (ex: Throwable) -> Unit) {
        try {
            messageRepository.sendMessages(message)
            success()
        }
        catch (ex: Throwable) {
            fail(ex)
        }
    }

}