@file:Suppress("NAME_SHADOWING")

package com.example.vocabulo

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.CycleInterpolator
import android.view.animation.TranslateAnimation
import kotlinx.android.synthetic.main.activity_main.*
import words.wordss
import java.util.*
import kotlin.random.Random
import kotlin.system.exitProcess

open class MainActivity() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this()

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Chama a função para forçar texto maiusculo e limite de palavras (1)
        capTxt()

        //Chama a função de gerar a palavra com a StringArray (BD) de Palavras
        generateRandomWord(wordss)

        //Faz o texto "pular" entre EditTexts
        runText()

        closeHowToPlay.setOnClickListener {
            howToPlayBox.visibility = View.INVISIBLE
            linearLayout1.visibility = View.VISIBLE
            linearLayout2.visibility = View.VISIBLE
            linearLayout3.visibility = View.VISIBLE
            linearLayout4.visibility = View.VISIBLE
            linearLayout5.visibility = View.VISIBLE
            button.visibility = View.VISIBLE
        }

    }

    //Mostrar o botão de configuração
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    @Suppress("UNSAFE_CALL_ON_PARTIALLY_DEFINED_RESOURCE")
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.howToPlay -> {
            howToPlayBox.visibility = View.VISIBLE
            linearLayout1.visibility = View.INVISIBLE
            linearLayout2.visibility = View.INVISIBLE
            linearLayout3.visibility = View.INVISIBLE
            linearLayout4.visibility = View.INVISIBLE
            linearLayout5.visibility = View.INVISIBLE
            button.visibility = View.INVISIBLE
            true
        }

        /*val a = arrayOf(R.id.editTxt1,R.id.editTxt1,R.id.editTxt1,R.id.editTxt1,R.id.editTxt1,R.id.editTxt1,R.id.editTxt1,
            R.id.editTxt1,R.id.editTxt1,R.id.editTxt1,R.id.editTxt1,)*/

        R.id.closeHowToPlay -> {
            howToPlayBox.visibility = View.INVISIBLE
            true
        }

        R.id.aboutDeveloper -> {
            val uri: Uri = Uri.parse("https://github.com/Pedro-1302")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
            true
        }
        else -> super.onOptionsItemSelected(item)
    }



    //Texto maiusculo e maximo de letras
    fun capTxt() {
        val maxLength = 1

        editTxt1.isAllCaps = true
        editTxt1.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt2.isAllCaps = true
        editTxt2.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt3.isAllCaps = true
        editTxt3.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt4.isAllCaps = true
        editTxt4.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt5.isAllCaps = true
        editTxt5.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt6.isAllCaps = true
        editTxt6.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt7.isAllCaps = true
        editTxt7.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt8.isAllCaps = true
        editTxt8.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt9.isAllCaps = true
        editTxt9.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt10.isAllCaps = true
        editTxt10.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt11.isAllCaps = true
        editTxt11.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt12.isAllCaps = true
        editTxt12.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt13.isAllCaps = true
        editTxt13.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt14.isAllCaps = true
        editTxt14.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt15.isAllCaps = true
        editTxt15.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt16.isAllCaps = true
        editTxt16.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt17.isAllCaps = true
        editTxt17.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt18.isAllCaps = true
        editTxt18.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt19.isAllCaps = true
        editTxt19.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt20.isAllCaps = true
        editTxt20.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt21.isAllCaps = true
        editTxt21.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt22.isAllCaps = true
        editTxt22.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt23.isAllCaps = true
        editTxt23.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt24.isAllCaps = true
        editTxt24.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
        editTxt25.isAllCaps = true
        editTxt25.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
    }

    //Função que gera uma palavra aleatoria
    fun generateRandomWord(words: Array<String>){
        var randomValue = Random.nextInt(words.size)
        var pdd = words[randomValue]

        //test.text = pdd

        //Faz a primeira checagem
        firstCheck(pdd)
    }

    //Faz a primeira checagem
    fun firstCheck(pdd:String){
        //Evento do clique do botão
        button.setOnClickListener{
            var i = 0

            if (editTxt1.text.toString() == "") {
                editTxt1.startAnimation(shakeError())
                editTxt1.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt1.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (editTxt2.text.toString() == "") {
                editTxt2.startAnimation(shakeError())
                editTxt2.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt2.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (editTxt3.text.toString() == "") {
                editTxt3.startAnimation(shakeError())
                editTxt3.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt3.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (editTxt4.text.toString() == "") {
                editTxt4.startAnimation(shakeError())
                editTxt4.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt4.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (editTxt5.text.toString() == "") {
                editTxt5.startAnimation(shakeError())
                editTxt5.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt5.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (i == 5){
                //Concatena o texto das EditTexts e o coloca no PDU - Palavra do Usuario
                var pdu: String =
                    editTxt1.text.toString() +
                            editTxt2.text.toString() +
                            editTxt3.text.toString() +
                            editTxt4.text.toString() +
                            editTxt5.text.toString()
                firstCompare(pdu, pdd)
            }
        }
    }

    //Faz a primeira comparação
    @SuppressLint("SetTextI18n")
    fun firstCompare(pdu: String, pdd: String) {
        var i = 0

        when (pdu[0]) {
            pdd[0] -> editTxt1.setBackgroundResource(R.drawable.correct)
            pdd[1] -> if (pdu[1] != pdd[1]) {
                editTxt1.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt1.setBackgroundResource(R.drawable.wrong)
            }
            pdd[2] -> if (pdu[2] != pdd[2]) {
                editTxt1.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt1.setBackgroundResource(R.drawable.wrong)
            }
            pdd[3] -> if (pdu[3] != pdd[3]) {
                editTxt1.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt1.setBackgroundResource(R.drawable.wrong)
            }
            pdd[4] -> if (pdu[4] != pdd[4]) {
                editTxt1.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt1.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt1.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[1]) {
            pdd[1] -> editTxt2.setBackgroundResource(R.drawable.correct)
            pdd[0] -> if (pdu[0] != pdd[0]) {
                editTxt2.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt2.setBackgroundResource(R.drawable.wrong)
            }
            pdd[2] -> if (pdu[2] != pdd[2]) {
                editTxt2.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt2.setBackgroundResource(R.drawable.wrong)
            }
            pdd[3] -> if (pdu[3] != pdd[3]) {
                editTxt2.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt2.setBackgroundResource(R.drawable.wrong)
            }
            pdd[4] -> if (pdu[4] != pdd[4]) {
                editTxt2.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt2.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt2.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[2]) {
            pdd[2] -> editTxt3.setBackgroundResource(R.drawable.correct)
            pdd[0] -> if (pdu[0] != pdd[0]) {
                editTxt3.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt3.setBackgroundResource(R.drawable.wrong)
            }
            pdd[1] -> if (pdu[1] != pdd[1]) {
                editTxt3.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt3.setBackgroundResource(R.drawable.wrong)
            }
            pdd[3] -> if (pdu[3] != pdd[3]) {
                editTxt3.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt3.setBackgroundResource(R.drawable.wrong)
            }
            pdd[4] -> if (pdu[4] != pdd[4]) {
                editTxt3.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt3.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt3.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[3]) {
            pdd[3] -> editTxt4.setBackgroundResource(R.drawable.correct)
            pdd[0] -> if (pdu[0] != pdd[0]) {
                editTxt4.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt4.setBackgroundResource(R.drawable.wrong)
            }
            pdd[1] -> if (pdu[1] != pdd[1]) {
                editTxt4.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt4.setBackgroundResource(R.drawable.wrong)
            }
            pdd[2] -> if (pdu[2] != pdd[2]) {
                editTxt4.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt4.setBackgroundResource(R.drawable.wrong)
            }
            pdd[4] -> if (pdu[4] != pdd[4]) {
                editTxt4.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt4.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt4.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[4]) {
            pdd[4] -> editTxt5.setBackgroundResource(R.drawable.correct)
            pdd[0] -> if (pdu[0] != pdd[0]) {
                editTxt5.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt5.setBackgroundResource(R.drawable.wrong)
            }
            pdd[1] -> if (pdu[1] != pdd[1]) {
                editTxt5.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt5.setBackgroundResource(R.drawable.wrong)
            }
            pdd[2] -> if (pdu[2] != pdd[2]) {
                editTxt5.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt5.setBackgroundResource(R.drawable.wrong)
            }
            pdd[3] -> if (pdu[3] != pdd[3]) {
                editTxt5.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt5.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt5.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[0]) { pdd[0] -> i += 1}
        when (pdu[1]) { pdd[1] -> i += 1}
        when (pdu[2]) { pdd[2] -> i += 1}
        when (pdu[3]) { pdd[3] -> i += 1}
        when (pdu[4]) { pdd[4] -> i += 1}

        if (i == 5){
            inLoseOrWinDisable()
            winBox.visibility = View.VISIBLE
            winBoxS.visibility = View.VISIBLE
            msgWin.text = "Você ganhou!!"


            playAgain.setOnClickListener {
                val intent = intent
                finish()
                startActivity(intent)
            }
            close.setOnClickListener {
                closeApp()
            }
        }

        else if (i != 5) {
            inLoseOrWinDisable()
            secondCheck(pdd)
        }
    }

    //Faz a segunda checagem
    fun secondCheck(pdd: String) {
        //Habilitar as proximas EditTexts
        enableEditsTexts()
        //Evento do clique do botão
        button.setOnClickListener{
            var i = 0

            if (editTxt6.text.toString() == "") {
                editTxt6.startAnimation(shakeError())
                editTxt6.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt6.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (editTxt7.text.toString() == "") {
                editTxt7.startAnimation(shakeError())
                editTxt7.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt7.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (editTxt8.text.toString() == "") {
                editTxt8.startAnimation(shakeError())
                editTxt8.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt8.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (editTxt9.text.toString() == "") {
                editTxt9.startAnimation(shakeError())
                editTxt9.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt9.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (editTxt10.text.toString() == "") {
                editTxt10.startAnimation(shakeError())
                editTxt10.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt10.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (i == 5){
                //Concatena o texto das EditTexts e o coloca no PDU - Palavra do Usuario
                var pdu: String =
                    editTxt6.text.toString() +
                            editTxt7.text.toString() +
                            editTxt8.text.toString() +
                            editTxt9.text.toString() +
                            editTxt10.text.toString()
                secondCompare(pdu, pdd)
            }
        }
    }

    //Faz a segunda comparação
    @SuppressLint("SetTextI18n")
    fun secondCompare(pdu: String, pdd: String){
        var i = 0

        when (pdu[0]) {
            pdd[0] -> editTxt6.setBackgroundResource(R.drawable.correct)
            pdd[1] -> if (pdu[1] != pdd[1]) {
                editTxt6.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt6.setBackgroundResource(R.drawable.wrong)
            }
            pdd[2] -> if (pdu[2] != pdd[2]) {
                editTxt6.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt6.setBackgroundResource(R.drawable.wrong)
            }
            pdd[3] -> if (pdu[3] != pdd[3]) {
                editTxt6.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt6.setBackgroundResource(R.drawable.wrong)
            }
            pdd[4] -> if (pdu[4] != pdd[4]) {
                editTxt6.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt6.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt6.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[1]) {
            pdd[1] -> editTxt7.setBackgroundResource(R.drawable.correct)
            pdd[0] -> if (pdu[0] != pdd[0]) {
                editTxt7.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt7.setBackgroundResource(R.drawable.wrong)
            }
            pdd[2] -> if (pdu[2] != pdd[2]) {
                editTxt7.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt7.setBackgroundResource(R.drawable.wrong)
            }
            pdd[3] -> if (pdu[3] != pdd[3]) {
                editTxt7.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt7.setBackgroundResource(R.drawable.wrong)
            }
            pdd[4] -> if (pdu[4] != pdd[4]) {
                editTxt7.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt7.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt7.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[2]) {
            pdd[2] -> editTxt8.setBackgroundResource(R.drawable.correct)
            pdd[0] -> if (pdu[0] != pdd[0]) {
                editTxt8.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt8.setBackgroundResource(R.drawable.wrong)
            }
            pdd[1] -> if (pdu[1] != pdd[1]) {
                editTxt8.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt8.setBackgroundResource(R.drawable.wrong)
            }
            pdd[3] -> if (pdu[3] != pdd[3]) {
                editTxt8.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt8.setBackgroundResource(R.drawable.wrong)
            }
            pdd[4] -> if (pdu[4] != pdd[4]) {
                editTxt8.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt8.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt8.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[3]) {
            pdd[3] -> editTxt9.setBackgroundResource(R.drawable.correct)
            pdd[0] -> if (pdu[0] != pdd[0]) {
                editTxt9.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt9.setBackgroundResource(R.drawable.wrong)
            }
            pdd[1] -> if (pdu[1] != pdd[1]) {
                editTxt9.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt9.setBackgroundResource(R.drawable.wrong)
            }
            pdd[2] -> if (pdu[2] != pdd[2]) {
                editTxt9.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt9.setBackgroundResource(R.drawable.wrong)
            }
            pdd[4] -> if (pdu[4] != pdd[4]) {
                editTxt9.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt9.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt9.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[4]) {
            pdd[4] -> editTxt10.setBackgroundResource(R.drawable.correct)
            pdd[0] -> if (pdu[0] != pdd[0]) {
                editTxt10.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt10.setBackgroundResource(R.drawable.wrong)
            }
            pdd[1] -> if (pdu[1] != pdd[1]) {
                editTxt10.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt10.setBackgroundResource(R.drawable.wrong)
            }
            pdd[2] -> if (pdu[2] != pdd[2]) {
                editTxt10.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt10.setBackgroundResource(R.drawable.wrong)
            }
            pdd[3] -> if (pdu[3] != pdd[3]) {
                editTxt10.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt10.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt10.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[0]) { pdd[0] -> i += 1}
        when (pdu[1]) { pdd[1] -> i += 1}
        when (pdu[2]) { pdd[2] -> i += 1}
        when (pdu[3]) { pdd[3] -> i += 1}
        when (pdu[4]) { pdd[4] -> i += 1}

        if (i == 5){
            inLoseOrWinDisable2()
            winBox.visibility = View.VISIBLE
            winBoxS.visibility = View.VISIBLE
            msgWin.text = "Você ganhou!!"

            playAgain.setOnClickListener {
                val intent = intent
                finish()
                startActivity(intent)
            }
            close.setOnClickListener {
                closeApp()
            }
        }

        else if (i != 5) {
            inLoseOrWinDisable2()
            thirdCheck(pdd)
        }
    }

    //Faz a segunda checagem
    fun thirdCheck(pdd: String){
        //Habilitar as proximas EditTexts
        enableEditsTexts2()
        //Evento do clique do botão
        button.setOnClickListener{
            var i = 0

            if (editTxt11.text.toString() == "") {
                editTxt11.startAnimation(shakeError())
                editTxt11.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt11.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (editTxt12.text.toString() == "") {
                editTxt12.startAnimation(shakeError())
                editTxt12.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt12.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (editTxt13.text.toString() == "") {
                editTxt13.startAnimation(shakeError())
                editTxt13.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt13.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (editTxt14.text.toString() == "") {
                editTxt14.startAnimation(shakeError())
                editTxt14.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt14.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (editTxt15.text.toString() == "") {
                editTxt15.startAnimation(shakeError())
                editTxt15.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt15.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (i == 5){
                //Concatena o texto das EditTexts e o coloca no PDU - Palavra do Usuario
                var pdu: String =
                    editTxt11.text.toString() +
                            editTxt12.text.toString() +
                            editTxt13.text.toString() +
                            editTxt14.text.toString() +
                            editTxt15.text.toString()
                thirdCompare(pdu, pdd)
            }
        }
    }

    //Faz a terceira comparação
    @SuppressLint("SetTextI18n")
    fun thirdCompare(pdu: String, pdd: String) {
        var i = 0

        when (pdu[0]) {
            pdd[0] -> editTxt11.setBackgroundResource(R.drawable.correct)
            pdd[1] -> if (pdu[1] != pdd[1]) {
                editTxt11.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt11.setBackgroundResource(R.drawable.wrong)
            }
            pdd[2] -> if (pdu[2] != pdd[2]) {
                editTxt11.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt11.setBackgroundResource(R.drawable.wrong)
            }
            pdd[3] -> if (pdu[3] != pdd[3]) {
                editTxt11.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt11.setBackgroundResource(R.drawable.wrong)
            }
            pdd[4] -> if (pdu[4] != pdd[4]) {
                editTxt11.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt11.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt11.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[1]) {
            pdd[1] -> editTxt12.setBackgroundResource(R.drawable.correct)
            pdd[0] -> if (pdu[0] != pdd[0]) {
                editTxt12.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt12.setBackgroundResource(R.drawable.wrong)
            }
            pdd[2] -> if (pdu[2] != pdd[2]) {
                editTxt12.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt12.setBackgroundResource(R.drawable.wrong)
            }
            pdd[3] -> if (pdu[3] != pdd[3]) {
                editTxt12.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt12.setBackgroundResource(R.drawable.wrong)
            }
            pdd[4] -> if (pdu[4] != pdd[4]) {
                editTxt12.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt12.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt12.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[2]) {
            pdd[2] -> editTxt13.setBackgroundResource(R.drawable.correct)
            pdd[0] -> if (pdu[0] != pdd[0]) {
                editTxt13.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt13.setBackgroundResource(R.drawable.wrong)
            }
            pdd[1] -> if (pdu[1] != pdd[1]) {
                editTxt13.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt13.setBackgroundResource(R.drawable.wrong)
            }
            pdd[3] -> if (pdu[3] != pdd[3]) {
                editTxt13.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt13.setBackgroundResource(R.drawable.wrong)
            }
            pdd[4] -> if (pdu[4] != pdd[4]) {
                editTxt13.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt13.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt13.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[3]) {
            pdd[3] -> editTxt14.setBackgroundResource(R.drawable.correct)
            pdd[0] -> if (pdu[0] != pdd[0]) {
                editTxt14.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt14.setBackgroundResource(R.drawable.wrong)
            }
            pdd[1] -> if (pdu[1] != pdd[1]) {
                editTxt14.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt14.setBackgroundResource(R.drawable.wrong)
            }
            pdd[2] -> if (pdu[2] != pdd[2]) {
                editTxt14.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt14.setBackgroundResource(R.drawable.wrong)
            }
            pdd[4] -> if (pdu[4] != pdd[4]) {
                editTxt14.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt14.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt14.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[4]) {
            pdd[4] -> editTxt15.setBackgroundResource(R.drawable.correct)
            pdd[0] -> if (pdu[0] != pdd[0]) {
                editTxt15.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt15.setBackgroundResource(R.drawable.wrong)
            }
            pdd[1] -> if (pdu[1] != pdd[1]) {
                editTxt15.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt15.setBackgroundResource(R.drawable.wrong)
            }
            pdd[2] -> if (pdu[2] != pdd[2]) {
                editTxt15.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt15.setBackgroundResource(R.drawable.wrong)
            }
            pdd[3] -> if (pdu[3] != pdd[3]) {
                editTxt15.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt15.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt15.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[0]) { pdd[0] -> i += 1}
        when (pdu[1]) { pdd[1] -> i += 1}
        when (pdu[2]) { pdd[2] -> i += 1}
        when (pdu[3]) { pdd[3] -> i += 1}
        when (pdu[4]) { pdd[4] -> i += 1}

        if (i == 5){
            inLoseOrWinDisable3()
            winBox.visibility = View.VISIBLE
            winBoxS.visibility = View.VISIBLE
            msgWin.text = "Você ganhou!!"

            playAgain.setOnClickListener {
                val intent = intent
                finish()
                startActivity(intent)
            }
            close.setOnClickListener {
                closeApp()
            }
        }

        else if (i != 5) {
            inLoseOrWinDisable3()
            fourthCheck(pdd)
        }
    }

    //Faz a quarta checagem
    fun fourthCheck(pdd: String) {
        //Habilitar as proximas EditTexts
        enableEditsTexts3()
        //Evento do clique do botão
        button.setOnClickListener{
            var i = 0

            if (editTxt16.text.toString() == "") {
                editTxt16.startAnimation(shakeError())
                editTxt16.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt16.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (editTxt17.text.toString() == "") {
                editTxt17.startAnimation(shakeError())
                editTxt17.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt17.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (editTxt18.text.toString() == "") {
                editTxt18.startAnimation(shakeError())
                editTxt18.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt18.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (editTxt19.text.toString() == "") {
                editTxt19.startAnimation(shakeError())
                editTxt19.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt19.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (editTxt20.text.toString() == "") {
                editTxt20.startAnimation(shakeError())
                editTxt20.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt20.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (i == 5){
                //Concatena o texto das EditTexts e o coloca no PDU - Palavra do Usuario
                var pdu: String =
                    editTxt16.text.toString() +
                            editTxt17.text.toString() +
                            editTxt18.text.toString() +
                            editTxt19.text.toString() +
                            editTxt20.text.toString()
                fourthCompare(pdu, pdd)
            }
        }
    }

    //Faz a quarta comparação
    @SuppressLint("SetTextI18n")
    fun fourthCompare(pdu: String, pdd: String) {
        var i = 0

        when (pdu[0]) {
            pdd[0] -> editTxt16.setBackgroundResource(R.drawable.correct)
            pdd[1] -> if (pdu[1] != pdd[1]) {
                editTxt16.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt16.setBackgroundResource(R.drawable.wrong)
            }
            pdd[2] -> if (pdu[2] != pdd[2]) {
                editTxt16.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt16.setBackgroundResource(R.drawable.wrong)
            }
            pdd[3] -> if (pdu[3] != pdd[3]) {
                editTxt16.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt16.setBackgroundResource(R.drawable.wrong)
            }
            pdd[4] -> if (pdu[4] != pdd[4]) {
                editTxt16.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt16.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt16.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[1]) {
            pdd[1] -> editTxt17.setBackgroundResource(R.drawable.correct)
            pdd[0] -> if (pdu[0] != pdd[0]) {
                editTxt17.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt17.setBackgroundResource(R.drawable.wrong)
            }
            pdd[2] -> if (pdu[2] != pdd[2]) {
                editTxt17.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt17.setBackgroundResource(R.drawable.wrong)
            }
            pdd[3] -> if (pdu[3] != pdd[3]) {
                editTxt17.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt17.setBackgroundResource(R.drawable.wrong)
            }
            pdd[4] -> if (pdu[4] != pdd[4]) {
                editTxt17.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt17.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt17.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[2]) {
            pdd[2] -> editTxt18.setBackgroundResource(R.drawable.correct)
            pdd[0] -> if (pdu[0] != pdd[0]) {
                editTxt18.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt18.setBackgroundResource(R.drawable.wrong)
            }
            pdd[1] -> if (pdu[1] != pdd[1]) {
                editTxt18.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt18.setBackgroundResource(R.drawable.wrong)
            }
            pdd[3] -> if (pdu[3] != pdd[3]) {
                editTxt18.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt18.setBackgroundResource(R.drawable.wrong)
            }
            pdd[4] -> if (pdu[4] != pdd[4]) {
                editTxt18.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt18.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt18.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[3]) {
            pdd[3] -> editTxt19.setBackgroundResource(R.drawable.correct)
            pdd[0] -> if (pdu[0] != pdd[0]) {
                editTxt19.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt19.setBackgroundResource(R.drawable.wrong)
            }
            pdd[1] -> if (pdu[1] != pdd[1]) {
                editTxt19.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt19.setBackgroundResource(R.drawable.wrong)
            }
            pdd[2] -> if (pdu[2] != pdd[2]) {
                editTxt19.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt19.setBackgroundResource(R.drawable.wrong)
            }
            pdd[4] -> if (pdu[4] != pdd[4]) {
                editTxt19.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt19.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt19.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[4]) {
            pdd[4] -> editTxt20.setBackgroundResource(R.drawable.correct)
            pdd[0] -> if (pdu[0] != pdd[0]) {
                editTxt20.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt20.setBackgroundResource(R.drawable.wrong)
            }
            pdd[1] -> if (pdu[1] != pdd[1]) {
                editTxt20.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt20.setBackgroundResource(R.drawable.wrong)
            }
            pdd[2] -> if (pdu[2] != pdd[2]) {
                editTxt20.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt20.setBackgroundResource(R.drawable.wrong)
            }
            pdd[3] -> if (pdu[3] != pdd[3]) {
                editTxt20.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt20.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt20.setBackgroundResource(R.drawable.wrong)
        }


        when (pdu[0]) { pdd[0] -> i += 1}
        when (pdu[1]) { pdd[1] -> i += 1}
        when (pdu[2]) { pdd[2] -> i += 1}
        when (pdu[3]) { pdd[3] -> i += 1}
        when (pdu[4]) { pdd[4] -> i += 1}

        if (i == 5){
            inLoseOrWinDisable4()
            winBox.visibility = View.VISIBLE
            winBoxS.visibility = View.VISIBLE
            msgWin.text = "Você ganhou!!"

            playAgain.setOnClickListener {
                val intent = intent
                finish()
                startActivity(intent)
            }
            close.setOnClickListener {
                closeApp()
            }
        }

        else if (i != 5) {
            inLoseOrWinDisable4()
            fifthCheck(pdd)
        }
    }

    //Faz a quinta checagem
    fun fifthCheck(pdd: String){
        //Habilitar as proximas EditTexts
        enableEditsTexts4()
        //Evento do clique do botão
        button.setOnClickListener{
            var i = 0

            if (editTxt21.text.toString() == "") {
                editTxt21.startAnimation(shakeError())
                editTxt21.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt21.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (editTxt22.text.toString() == "") {
                editTxt22.startAnimation(shakeError())
                editTxt22.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt22.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (editTxt23.text.toString() == "") {
                editTxt23.startAnimation(shakeError())
                editTxt23.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt23.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (editTxt24.text.toString() == "") {
                editTxt24.startAnimation(shakeError())
                editTxt24.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt24.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (editTxt25.text.toString() == "") {
                editTxt25.startAnimation(shakeError())
                editTxt25.setBackgroundResource(R.drawable.wrong)
            } else {
                editTxt25.setBackgroundResource(R.drawable.custom_edit)
                i += 1
            }

            if (i == 5){
                //Concatena o texto das EditTexts e o coloca no PDU - Palavra do Usuario
                var pdu: String =
                    editTxt21.text.toString() +
                            editTxt22.text.toString() +
                            editTxt23.text.toString() +
                            editTxt24.text.toString() +
                            editTxt25.text.toString()
                fifthCompare(pdu, pdd)
            }
        }
    }

    //Faz a quinta comparação
    @SuppressLint("SetTextI18n")
    fun fifthCompare(pdu: String, pdd: String){
        var i = 0

        when (pdu[0]) {
            pdd[0] -> editTxt21.setBackgroundResource(R.drawable.correct)
            pdd[1] -> if (pdu[1] != pdd[1]) {
                editTxt21.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt21.setBackgroundResource(R.drawable.wrong)
            }
            pdd[2] -> if (pdu[2] != pdd[2]) {
                editTxt21.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt21.setBackgroundResource(R.drawable.wrong)
            }
            pdd[3] -> if (pdu[3] != pdd[3]) {
                editTxt21.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt21.setBackgroundResource(R.drawable.wrong)
            }
            pdd[4] -> if (pdu[4] != pdd[4]) {
                editTxt21.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt21.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt21.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[1]) {
            pdd[1] -> editTxt22.setBackgroundResource(R.drawable.correct)
            pdd[0] -> if (pdu[0] != pdd[0]) {
                editTxt22.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt22.setBackgroundResource(R.drawable.wrong)
            }
            pdd[2] -> if (pdu[2] != pdd[2]) {
                editTxt22.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt22.setBackgroundResource(R.drawable.wrong)
            }
            pdd[3] -> if (pdu[3] != pdd[3]) {
                editTxt22.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt22.setBackgroundResource(R.drawable.wrong)
            }
            pdd[4] -> if (pdu[4] != pdd[4]) {
                editTxt22.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt22.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt22.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[2]) {
            pdd[2] -> editTxt23.setBackgroundResource(R.drawable.correct)
            pdd[0] -> if (pdu[0] != pdd[0]) {
                editTxt23.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt23.setBackgroundResource(R.drawable.wrong)
            }
            pdd[1] -> if (pdu[1] != pdd[1]) {
                editTxt23.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt23.setBackgroundResource(R.drawable.wrong)
            }
            pdd[3] -> if (pdu[3] != pdd[3]) {
                editTxt23.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt23.setBackgroundResource(R.drawable.wrong)
            }
            pdd[4] -> if (pdu[4] != pdd[4]) {
                editTxt23.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt23.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt23.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[3]) {
            pdd[3] -> editTxt24.setBackgroundResource(R.drawable.correct)
            pdd[0] -> if (pdu[0] != pdd[0]) {
                editTxt24.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt24.setBackgroundResource(R.drawable.wrong)
            }
            pdd[1] -> if (pdu[1] != pdd[1]) {
                editTxt24.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt24.setBackgroundResource(R.drawable.wrong)
            }
            pdd[2] -> if (pdu[2] != pdd[2]) {
                editTxt24.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt24.setBackgroundResource(R.drawable.wrong)
            }
            pdd[4] -> if (pdu[4] != pdd[4]) {
                editTxt24.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt24.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt24.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[4]) {
            pdd[4] -> editTxt25.setBackgroundResource(R.drawable.correct)
            pdd[0] -> if (pdu[0] != pdd[0]) {
                editTxt25.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt25.setBackgroundResource(R.drawable.wrong)
            }
            pdd[1] -> if (pdu[1] != pdd[1]) {
                editTxt25.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt25.setBackgroundResource(R.drawable.wrong)
            }
            pdd[2] -> if (pdu[2] != pdd[2]) {
                editTxt25.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt25.setBackgroundResource(R.drawable.wrong)
            }
            pdd[3] -> if (pdu[3] != pdd[3]) {
                editTxt25.setBackgroundResource(R.drawable.otherposition)
            } else {
                editTxt25.setBackgroundResource(R.drawable.wrong)
            }
            else -> editTxt25.setBackgroundResource(R.drawable.wrong)
        }

        when (pdu[0]) { pdd[0] -> i += 1}
        when (pdu[1]) { pdd[1] -> i += 1}
        when (pdu[2]) { pdd[2] -> i += 1}
        when (pdu[3]) { pdd[3] -> i += 1}
        when (pdu[4]) { pdd[4] -> i += 1}

        if (i == 5){
            inLoseOrWinDisable5()
            winBox.visibility = View.VISIBLE
            winBoxS.visibility = View.VISIBLE
            msgWin.text = "Você ganhou!!"

            playAgain.setOnClickListener {
                val intent = intent
                finish()
                startActivity(intent)
            }
            close.setOnClickListener {
                closeApp()
            }
        }

        else if (i != 5) {
            inLoseOrWinDisable5()
            loseBox.visibility = View.VISIBLE
            loseBoxS.visibility = View.VISIBLE
            msgLose.text = "A palavra era: $pdd"

            playAgainLose.setOnClickListener {
                val intent = intent
                finish()
                startActivity(intent)
            }
            closeLose.setOnClickListener {
                closeApp()
            }
        }
    }

    //Desabilia as EditTexts que já passaram
    fun inLoseOrWinDisable() {
        editTxt1.isEnabled = false
        editTxt2.isEnabled = false
        editTxt3.isEnabled = false
        editTxt4.isEnabled = false
        editTxt5.isEnabled = false
    }

    //Desabilia as EditTexts que já passaram
    fun inLoseOrWinDisable2() {
        editTxt6.isEnabled = false
        editTxt7.isEnabled = false
        editTxt8.isEnabled = false
        editTxt9.isEnabled = false
        editTxt10.isEnabled = false
    }

    //Desabilia as EditTexts que já passaram
    fun inLoseOrWinDisable3() {
        editTxt11.isEnabled = false
        editTxt12.isEnabled = false
        editTxt13.isEnabled = false
        editTxt14.isEnabled = false
        editTxt15.isEnabled = false
    }

    //Desabilia as EditTexts que já passaram
    fun inLoseOrWinDisable4() {
        editTxt16.isEnabled = false
        editTxt17.isEnabled = false
        editTxt18.isEnabled = false
        editTxt19.isEnabled = false
        editTxt20.isEnabled = false
    }

    fun inLoseOrWinDisable5() {
        editTxt21.isEnabled = false
        editTxt22.isEnabled = false
        editTxt23.isEnabled = false
        editTxt24.isEnabled = false
        editTxt25.isEnabled = false
    }

    //Habilita as proximas EditTexts
    fun enableEditsTexts(){
        editTxt6.isEnabled = true
        editTxt6.setBackgroundResource(R.drawable.custom_edit)
        editTxt7.isEnabled = true
        editTxt7.setBackgroundResource(R.drawable.custom_edit)
        editTxt8.isEnabled = true
        editTxt8.setBackgroundResource(R.drawable.custom_edit)
        editTxt9.isEnabled = true
        editTxt9.setBackgroundResource(R.drawable.custom_edit)
        editTxt10.isEnabled = true
        editTxt10.setBackgroundResource(R.drawable.custom_edit)
    }

    //Habilita as proximas EditTexts
    fun enableEditsTexts2(){
        editTxt11.isEnabled = true
        editTxt11.setBackgroundResource(R.drawable.custom_edit)
        editTxt12.isEnabled = true
        editTxt12.setBackgroundResource(R.drawable.custom_edit)
        editTxt13.isEnabled = true
        editTxt13.setBackgroundResource(R.drawable.custom_edit)
        editTxt14.isEnabled = true
        editTxt14.setBackgroundResource(R.drawable.custom_edit)
        editTxt15.isEnabled = true
        editTxt15.setBackgroundResource(R.drawable.custom_edit)
    }

    //Habilita as proximas EditTexts
    fun enableEditsTexts3(){
        editTxt16.isEnabled = true
        editTxt16.setBackgroundResource(R.drawable.custom_edit)
        editTxt17.isEnabled = true
        editTxt17.setBackgroundResource(R.drawable.custom_edit)
        editTxt18.isEnabled = true
        editTxt18.setBackgroundResource(R.drawable.custom_edit)
        editTxt19.isEnabled = true
        editTxt19.setBackgroundResource(R.drawable.custom_edit)
        editTxt20.isEnabled = true
        editTxt20.setBackgroundResource(R.drawable.custom_edit)
    }

    //Habilita as proximas EditTexts
    fun enableEditsTexts4(){
        editTxt21.isEnabled = true
        editTxt21.setBackgroundResource(R.drawable.custom_edit)
        editTxt22.isEnabled = true
        editTxt22.setBackgroundResource(R.drawable.custom_edit)
        editTxt23.isEnabled = true
        editTxt23.setBackgroundResource(R.drawable.custom_edit)
        editTxt24.isEnabled = true
        editTxt24.setBackgroundResource(R.drawable.custom_edit)
        editTxt25.isEnabled = true
        editTxt25.setBackgroundResource(R.drawable.custom_edit)
    }

    //Fecha o App
    fun closeApp(){
        exitProcess(-1)
    }

    fun runText(){
        editTxt1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt1.setText(s)
                    editTxt1.setSelection(editTxt1.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt1.text.toString()) {
                        editTxt1.startAnimation(shakeError())
                        editTxt1.requestFocus()
                        editTxt1.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt1.text.toString() != "" && c == 0) {
                    editTxt2.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt2.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt2.text.toString() != "") {
                    editTxt2.setText("")
                }
                else if (editTxt2.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt1.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt2.setText(s)
                    editTxt2.setSelection(editTxt2.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt2.text.toString()) {
                        editTxt2.startAnimation(shakeError())
                        editTxt2.requestFocus()
                        editTxt2.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt2.text.toString() != "" && c == 0) {
                    editTxt3.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt3.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt3.text.toString() != "") {
                    editTxt3.setText("")
                }
                else if (editTxt3.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt2.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt3.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt3.setText(s)
                    editTxt3.setSelection(editTxt3.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt3.text.toString()) {
                        editTxt3.startAnimation(shakeError())
                        editTxt3.requestFocus()
                        editTxt3.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt3.text.toString() != "" && c == 0) {
                    editTxt4.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt4.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt4.text.toString() != "") {
                    editTxt4.setText("")
                }
                else if (editTxt4.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt3.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt4.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt4.setText(s)
                    editTxt4.setSelection(editTxt4.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt4.text.toString()) {
                        editTxt4.startAnimation(shakeError())
                        editTxt4.requestFocus()
                        editTxt4.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt4.text.toString() != "" && c == 0) {
                    editTxt5.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt5.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt5.text.toString() != "") {
                    editTxt5.setText("")
                }
                else if (editTxt5.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt4.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt5.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt5.setText(s)
                    editTxt5.setSelection(editTxt5.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt5.text.toString()) {
                        editTxt5.startAnimation(shakeError())
                        editTxt5.requestFocus()
                        editTxt5.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt5.text.toString() != "" && c == 0) {
                    editTxt6.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt6.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt6.text.toString() != "") {
                    editTxt6.setText("")
                }
                else if (editTxt6.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt5.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt6.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt6.setText(s)
                    editTxt6.setSelection(editTxt6.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt6.text.toString()) {
                        editTxt6.startAnimation(shakeError())
                        editTxt6.requestFocus()
                        editTxt6.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt6.text.toString() != "" && c == 0) {
                    editTxt7.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt7.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt7.text.toString() != "") {
                    editTxt7.setText("")
                }
                else if (editTxt7.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt6.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt7.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt7.setText(s)
                    editTxt7.setSelection(editTxt7.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt7.text.toString()) {
                        editTxt7.startAnimation(shakeError())
                        editTxt7.requestFocus()
                        editTxt7.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt7.text.toString() != "" && c == 0) {
                    editTxt8.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt8.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt8.text.toString() != "") {
                    editTxt8.setText("")
                }
                else if (editTxt8.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt7.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt8.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt8.setText(s)
                    editTxt8.setSelection(editTxt8.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt8.text.toString()) {
                        editTxt8.startAnimation(shakeError())
                        editTxt8.requestFocus()
                        editTxt8.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt8.text.toString() != "" && c == 0) {
                    editTxt9.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt9.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt9.text.toString() != "") {
                    editTxt9.setText("")
                }
                else if (editTxt9.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt8.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt9.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt9.setText(s)
                    editTxt9.setSelection(editTxt9.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt9.text.toString()) {
                        editTxt9.startAnimation(shakeError())
                        editTxt9.requestFocus()
                        editTxt9.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt9.text.toString() != "" && c == 0) {
                    editTxt10.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt10.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt10.text.toString() != "") {
                    editTxt10.setText("")
                }
                else if (editTxt10.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt9.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt10.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt10.setText(s)
                    editTxt10.setSelection(editTxt10.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt10.text.toString()) {
                        editTxt10.startAnimation(shakeError())
                        editTxt10.requestFocus()
                        editTxt10.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt10.text.toString() != "" && c == 0) {
                    editTxt11.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt11.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt11.text.toString() != "") {
                    editTxt11.setText("")
                }
                else if (editTxt11.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt10.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt11.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt11.setText(s)
                    editTxt11.setSelection(editTxt11.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt11.text.toString()) {
                        editTxt11.startAnimation(shakeError())
                        editTxt11.requestFocus()
                        editTxt11.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt11.text.toString() != "" && c == 0) {
                    editTxt12.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt12.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt12.text.toString() != "") {
                    editTxt12.setText("")
                }
                else if (editTxt12.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt11.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt12.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt12.setText(s)
                    editTxt12.setSelection(editTxt12.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt12.text.toString()) {
                        editTxt12.startAnimation(shakeError())
                        editTxt12.requestFocus()
                        editTxt12.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt12.text.toString() != "" && c == 0) {
                    editTxt13.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt13.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt13.text.toString() != "") {
                    editTxt13.setText("")
                }
                else if (editTxt13.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt12.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt13.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt13.setText(s)
                    editTxt13.setSelection(editTxt13.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt13.text.toString()) {
                        editTxt13.startAnimation(shakeError())
                        editTxt13.requestFocus()
                        editTxt13.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt13.text.toString() != "" && c == 0) {
                    editTxt14.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt14.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt14.text.toString() != "") {
                    editTxt14.setText("")
                }
                else if (editTxt14.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt13.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt14.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt14.setText(s)
                    editTxt14.setSelection(editTxt14.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt14.text.toString()) {
                        editTxt14.startAnimation(shakeError())
                        editTxt14.requestFocus()
                        editTxt14.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt14.text.toString() != "" && c == 0) {
                    editTxt15.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt15.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt15.text.toString() != "") {
                    editTxt15.setText("")
                }
                else if (editTxt15.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt14.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt15.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt15.setText(s)
                    editTxt15.setSelection(editTxt15.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt15.text.toString()) {
                        editTxt15.startAnimation(shakeError())
                        editTxt15.requestFocus()
                        editTxt15.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt15.text.toString() != "" && c == 0) {
                    editTxt16.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt16.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt16.text.toString() != "") {
                    editTxt16.setText("")
                }
                else if (editTxt16.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt15.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt16.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt16.setText(s)
                    editTxt16.setSelection(editTxt16.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt16.text.toString()) {
                        editTxt16.startAnimation(shakeError())
                        editTxt16.requestFocus()
                        editTxt16.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt16.text.toString() != "" && c == 0) {
                    editTxt17.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt17.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt17.text.toString() != "") {
                    editTxt17.setText("")
                }
                else if (editTxt17.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt16.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt17.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt17.setText(s)
                    editTxt17.setSelection(editTxt17.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt17.text.toString()) {
                        editTxt17.startAnimation(shakeError())
                        editTxt17.requestFocus()
                        editTxt17.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt17.text.toString() != "" && c == 0) {
                    editTxt18.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt18.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt18.text.toString() != "") {
                    editTxt18.setText("")
                }
                else if (editTxt18.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt17.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt18.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt18.setText(s)
                    editTxt18.setSelection(editTxt18.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt18.text.toString()) {
                        editTxt18.startAnimation(shakeError())
                        editTxt18.requestFocus()
                        editTxt18.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt18.text.toString() != "" && c == 0) {
                    editTxt19.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt19.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt19.text.toString() != "") {
                    editTxt19.setText("")
                }
                else if (editTxt19.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt18.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt19.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt19.setText(s)
                    editTxt19.setSelection(editTxt19.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt19.text.toString()) {
                        editTxt19.startAnimation(shakeError())
                        editTxt19.requestFocus()
                        editTxt19.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt19.text.toString() != "" && c == 0) {
                    editTxt20.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt20.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt20.text.toString() != "") {
                    editTxt20.setText("")
                }
                else if (editTxt20.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt19.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt20.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt20.setText(s)
                    editTxt20.setSelection(editTxt20.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt20.text.toString()) {
                        editTxt20.startAnimation(shakeError())
                        editTxt20.requestFocus()
                        editTxt20.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt20.text.toString() != "" && c == 0) {
                    editTxt21.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt21.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt21.text.toString() != "") {
                    editTxt21.setText("")
                }
                else if (editTxt21.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt20.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt21.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt21.setText(s)
                    editTxt21.setSelection(editTxt21.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt21.text.toString()) {
                        editTxt21.startAnimation(shakeError())
                        editTxt21.requestFocus()
                        editTxt21.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt21.text.toString() != "" && c == 0) {
                    editTxt22.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt22.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt22.text.toString() != "") {
                    editTxt22.setText("")
                }
                else if (editTxt22.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt21.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt22.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt22.setText(s)
                    editTxt22.setSelection(editTxt22.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt22.text.toString()) {
                        editTxt22.startAnimation(shakeError())
                        editTxt22.requestFocus()
                        editTxt22.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt22.text.toString() != "" && c == 0) {
                    editTxt23.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt23.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt23.text.toString() != "") {
                    editTxt23.setText("")
                }
                else if (editTxt23.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt22.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt23.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt23.setText(s)
                    editTxt23.setSelection(editTxt23.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt23.text.toString()) {
                        editTxt23.startAnimation(shakeError())
                        editTxt23.requestFocus()
                        editTxt23.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt23.text.toString() != "" && c == 0) {
                    editTxt22.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt24.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt24.text.toString() != "") {
                    editTxt24.setText("")
                }
                else if (editTxt24.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt23.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt24.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt24.setText(s)
                    editTxt24.setSelection(editTxt24.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt24.text.toString()) {
                        editTxt24.startAnimation(shakeError())
                        editTxt24.requestFocus()
                        editTxt24.setText("")
                        c += 1
                    }
                    i++
                }
                if (editTxt24.text.toString() != "" && c == 0) {
                    editTxt25.requestFocus()
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        editTxt25.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(editTxt25.text.toString() != "") {
                    editTxt25.setText("")
                }
                else if (editTxt25.text.toString() == "") {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        editTxt24.requestFocus()
                    }
                }
                return false
            }
        })

        editTxt25.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var i = 0
                var c = 0

                var s: String = s.toString()
                if (s != s.uppercase(Locale.getDefault())) {
                    s = s.uppercase(Locale.getDefault())
                    editTxt25.setText(s)
                    editTxt25.setSelection(editTxt25.length())
                }
                while (i < 10) {
                    if (i.toString() == editTxt25.text.toString()) {
                        editTxt25.startAnimation(shakeError())
                        editTxt25.requestFocus()
                        editTxt25.setText("")
                        c += 1
                    }
                    i++
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }

    fun shakeError(): TranslateAnimation {
        val shake = TranslateAnimation(0F, 10F, 0F, 0F)
        shake.duration = 250
        shake.interpolator = CycleInterpolator(3F)
        return shake
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}
