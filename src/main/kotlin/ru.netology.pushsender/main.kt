package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val token = "dtkQvYJkR7eImSjVrG8Ecp:APA91bEj_hIlU8IpUjfSFCXzloKw_VLmuCNSw8NO7vZvH8v-q3nPDl6Vz2ZJJPGfkko9Vues1tekRBntJzsJWJg59nOJa4n4GzsYyXub4GXADePTlmHKulWK1GIbQ7tnhmy6Jcw5c4LL"

    val message = Message.builder()
        .putData("action", "PUBLISHED")
        .putData("content", """{
          "userId": 1,         
          "postAuthor": "Netology",
          "postContent": "Важно: ни в коем случае не закидывайте в GitHub репозиторий учётные данные (файл google-services.json). Если вы всё-таки сделали это, то воспользуйтесь соответствующей утилитой для их удаления."
        }""".trimIndent())
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(message)
}