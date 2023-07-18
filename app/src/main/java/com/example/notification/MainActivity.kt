package com.example.notification


import android.app.NotificationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.notification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.high.setOnClickListener {
            val notification = NotificationCompat.Builder(this, App().CHANNEL_ID1)
            notification.setContentTitle(binding.name.text.toString())
            notification.setContentText(binding.passWord.text.toString())
            notification.setSmallIcon(R.drawable.ic_launcher_foreground)
                    notification.setPriority(NotificationCompat.PRIORITY_HIGH)
                .build()
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(1,notification.build())
        }

        binding.low.setOnClickListener {
            val notification = NotificationCompat.Builder(this, App().CHANNEL_ID2)
            notification.setContentTitle(binding.name.text.toString())
            notification.setContentText(binding.passWord.text.toString())
            notification.setSmallIcon(R.drawable.ic_launcher_foreground)
            notification.setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(1,notification.build())
        }
    }
}