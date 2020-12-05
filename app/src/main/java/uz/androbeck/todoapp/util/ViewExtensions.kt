package uz.androbeck.todoapp.util

import android.view.View
import androidx.appcompat.widget.SearchView

inline fun SearchView.onQueryTextChanged(crossinline listener: (String) -> Unit){
    this.setOnQueryTextFocusChangeListener(object : SearchView.OnQueryTextListener,
        View.OnFocusChangeListener {

        override fun onQueryTextSubmit(query: String?): Boolean {
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            listener(newText.orEmpty())
            return true
        }

        override fun onFocusChange(p0: View?, p1: Boolean) {

        }
    })
}