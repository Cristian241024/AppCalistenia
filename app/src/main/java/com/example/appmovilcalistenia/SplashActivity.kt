import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.appmovilcalistenia.R // Cambia este paquete al nombre correcto


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val videoView = findViewById<VideoView>(R.id.videoView)
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.intro_video)
        videoView.setVideoURI(videoUri)
        videoView.start()

        // Después de 3 segundos, inicia la siguiente actividad
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            finish() // Termina la SplashActivity
        }, 3000) // 3000 ms = 3 segundos
    }
}
