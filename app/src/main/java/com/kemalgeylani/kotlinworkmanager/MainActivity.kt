package com.kemalgeylani.kotlinworkmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
WorkManager, Android platformunda kullanılan bir arka plan görev yöneticisi ve zamanlayıcısıdır,
uygulamanın bataryayı ve kaynakları etkin bir şekilde kullanarak planlanmış görevleri,
tekrarlayan işleri ve kısıtlamalara uygun görevleri yönetir.
*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}