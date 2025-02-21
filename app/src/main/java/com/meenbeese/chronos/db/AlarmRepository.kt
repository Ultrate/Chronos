package com.meenbeese.chronos.db

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class AlarmRepository(private val alarmDao: AlarmDao) {
    suspend fun insert(alarm: AlarmEntity): Long = withContext(Dispatchers.IO) {
        alarmDao.insert(alarm)
    }

    suspend fun update(alarm: AlarmEntity) = withContext(Dispatchers.IO) {
        alarmDao.update(alarm)
    }

    suspend fun delete(alarm: AlarmEntity) = withContext(Dispatchers.IO) {
        alarmDao.delete(alarm)
    }

    suspend fun getAlarmById(id: Int): AlarmEntity? = withContext(Dispatchers.IO) {
        alarmDao.getAlarmById(id)
    }

    suspend fun getAllAlarms(): List<AlarmEntity> = withContext(Dispatchers.IO) {
        alarmDao.getAllAlarms()
    }
}
