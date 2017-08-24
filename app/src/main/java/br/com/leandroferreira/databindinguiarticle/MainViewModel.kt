package br.com.leandroferreira.databindinguiarticle

import android.databinding.ObservableField
import android.os.Handler
import com.ebanx.numberkeyboard.OnKeyClick
import com.ebanx.numberkeyboard.utils.Actions

class MainViewModel {

    val textObservable = ObservableField<String?>()

    val onKeyClick : OnKeyClick = object : OnKeyClick {
        override fun handleClick(key: Char) {
            receiveText(key.toString())
        }
    }

    fun receiveText(text: String) {
        if (text.toCharArray().first() == Actions.ERASE_TEXT) {
            textObservable.set("")
        } else {
            if (textObservable.get().isNullOrEmpty()) {
                textObservable.set(text)
            } else {
                textObservable.set(textObservable.get().plus(text))
            }
        }
    }
}