package com.kemalgeylani.kotlinworkmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class RefreshDatabase(val context: Context, workerParams: WorkerParameters) : Worker(context,
    workerParams
) {
    override fun doWork(): Result {
        val getData = inputData
        val incomingNumber = getData.getInt("intKey",0)
        refreshDatabase(incomingNumber)
        return Result.success()
    }

    private fun refreshDatabase(incomingNumber : Int){
        val sharedPreferences = context.getSharedPreferences("com.kemalgeylani.kotlinworkmanager",Context.MODE_PRIVATE)
        var mySavedNumber = sharedPreferences.getInt("myNumber",0)
        mySavedNumber += incomingNumber
        println(mySavedNumber)
        sharedPreferences.edit().putInt("myNumber",mySavedNumber).apply()
    }

}