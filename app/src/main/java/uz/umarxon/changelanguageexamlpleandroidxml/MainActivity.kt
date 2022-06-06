package uz.umarxon.changelanguageexamlpleandroidxml

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ninja.saad.wizardoflocale.util.LocaleHelper
import uz.umarxon.changelanguageexamlpleandroidxml.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChangeLanguageEn.setOnClickListener {
            LocaleHelper().setLocale(this@MainActivity, "en")
            recreate()
        }

        binding.btnChangeLanguageUz.setOnClickListener {
            LocaleHelper().setLocale(this@MainActivity, "uz")
            recreate()
        }
    }

    override fun attachBaseContext(base: Context) {
        LocaleHelper().setLocale(base, LocaleHelper().getLanguage(base))
        super.attachBaseContext(LocaleHelper().onAttach(base))
    }
}
