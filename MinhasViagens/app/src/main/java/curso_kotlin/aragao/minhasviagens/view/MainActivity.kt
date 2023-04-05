package curso_kotlin.aragao.minhasviagens.view

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.snackbar.Snackbar
import curso_kotlin.aragao.minhasviagens.R
import curso_kotlin.aragao.minhasviagens.data.MeusLugares
import curso_kotlin.aragao.minhasviagens.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val paris = MeusLugares("Luvre", "Visitar o quadro Monalisa");
        incluirLugar(paris)

        val barcelona = MeusLugares("Sagrada Família", "É uma Igreja famosa");
        incluirLugar(barcelona)

        val victoria = MeusLugares("victoria Station", "É um prédio histórico");
        incluirLugar(victoria)

        val bonito = MeusLugares("Gruta Lagoa Azul", "Paraíso ecológico do pantanal MS");
        incluirLugar(bonito)


        // Log.d("AppKotlin", "2 Meu lugar ${barcelona.nomeDoLugar} ${barcelona.justificativa}")
        // Log.w("AppKotlin", "3 Meu lugar ${victoria.nomeDoLugar} ${victoria.justificativa}")
        // Log.v("AppKotlin", "4 Meu lugar ${bonito.nomeDoLugar} ${bonito.justificativa}")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}

    fun nomeDoMetodo() : Boolean{
        return true
    }

    fun incluirLugar(meusLugares: MeusLugares) {
        Log.e("AppKotlin", "Objeto: Meu lugar ${meusLugares.nomeDoLugar} ${meusLugares.justificativa}")
    }