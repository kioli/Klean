package kioli.clean.presentation.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kioli.clean.App
import kioli.clean.R
import kioli.clean.presentation.view.QuoteView
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

internal class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var view: QuoteView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.component.inject(this)

        view.create()
        container.addView(view as View)
    }

    override fun onDestroy() {
        super.onDestroy()
        view.destroy()
    }
}
