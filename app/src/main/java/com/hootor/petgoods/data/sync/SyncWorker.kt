package com.hootor.petgoods.data.sync

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.hootor.petgoods.data.sync.MessageSync.*
import com.hootor.petgoods.domain.base.Failure
import com.hootor.petgoods.domain.base.None
import com.hootor.petgoods.domain.sync.SyncRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext

class SyncWorker(
    private val syncRepository: SyncRepository,
    ctx: Context,
    params: WorkerParameters
) : CoroutineWorker(ctx, params) {

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            syncRepository.sync(::listenMessage).either(::listenFailed, ::listenSuccess)
            Result.success()
        } catch (e: Exception) {
            _syncStatus.update { Error("Загрузка завершена с ошибкой: ${e.toString()}") }
            Result.failure()
        }
    }

    private fun listenFailed(fail: Failure) {
        _syncStatus.update { Error("Загрузка завершена с ошибкой") }
    }

    private fun listenSuccess(none: None) {
        _syncStatus.update { Success("Загрузка завершена") }
    }

    private fun listenMessage(message: String) =_syncStatus.update { Loading(message) }

    companion object {
        private val _syncStatus = MutableStateFlow<MessageSync>(Init(""))
        val syncStatus = _syncStatus.asStateFlow()
    }
}

sealed class MessageSync(val title: String) {
    class Init(title: String) : MessageSync(title)
    class Loading(title: String) : MessageSync(title)
    class Error(title: String) : MessageSync(title)
    class Success(title: String) : MessageSync(title)
}