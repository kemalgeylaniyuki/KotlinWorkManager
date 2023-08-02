package com.kemalgeylani.kotlinworkmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.WorkRequest
import java.util.concurrent.TimeUnit

/*
WorkManager, Android platformunda kullanılan bir arka plan görev yöneticisi ve zamanlayıcısıdır,
uygulamanın bataryayı ve kaynakları etkin bir şekilde kullanarak planlanmış görevleri,
tekrarlayan işleri ve kısıtlamalara uygun görevleri yönetir.
*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = Data.Builder().putInt("intKey",1).build()

        val constraints = Constraints.Builder()
            //.setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresCharging(false)
            .build()

        /*
        val workRequest : WorkRequest = OneTimeWorkRequestBuilder<RefreshDatabase>()
            .setConstraints(constraints)
            .setInputData(data)
            //.setInitialDelay(5,TimeUnit.SECONDS)
            //.addTag("firstRequest")
            .build()

        WorkManager.getInstance(this).enqueue(workRequest)
        */

        /*
        val periodicWorkRequest : WorkRequest = PeriodicWorkRequestBuilder<RefreshDatabase>(15,TimeUnit.MINUTES)
            .setInputData(data)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(this).enqueue(periodicWorkRequest)

        //Gözlemleme
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(periodicWorkRequest.id).observe(this,
            Observer {
                if (it.state == WorkInfo.State.RUNNING){
                    println("running")
                }
                else if (it.state == WorkInfo.State.FAILED){
                    println("failed")
                }
                else if (it.state == WorkInfo.State.SUCCEEDED){
                    println("succeeded")
                }
        })

        //iptal etmek
        WorkManager.getInstance(this).cancelAllWork()

        */

        //Chaining
        val oneTimeWorkRequest : OneTimeWorkRequest = OneTimeWorkRequestBuilder<RefreshDatabase>()
            .setConstraints(constraints)
            .setInputData(data)
            .build()

        WorkManager.getInstance(this).beginWith(oneTimeWorkRequest)
            .then(oneTimeWorkRequest)
            .then(oneTimeWorkRequest)
            .enqueue()

    }
}


