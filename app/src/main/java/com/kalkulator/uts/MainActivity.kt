package com.kalkulator.uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mEditTextBilanganPertama = findViewById<EditText>(R.id.Angka1)
        val mEditTextBilanganKedua = findViewById<EditText>(R.id.Angka2)
        val mSpinnerOperator = findViewById<Spinner>(R.id.spn_operator)
        val mButtonHitung = findViewById<Button>(R.id.btn_hitung)
        val mButtonTambah = findViewById<Button>(R.id.Tambah)
        val mButtonKali = findViewById<Button>(R.id.Kali)
        val mTextViewHasil = findViewById<TextView>(R.id.Hasil)

        mButtonTambah.setOnClickListener {
            if (mEditTextBilanganPertama.text.toString().isEmpty() || mEditTextBilanganKedua.text.toString().isEmpty()) {
                mEditTextBilanganPertama.setError("Semua input harus diisi!")
            } else {
                val a = mEditTextBilanganPertama.text.toString().toDouble()
                val b = mEditTextBilanganKedua.text.toString().toDouble()
                val c = a + b
                mTextViewHasil.setText(c.toString())
            }
        }

        mButtonKali.setOnClickListener {
            if (mEditTextBilanganPertama.text.toString().isEmpty() || mEditTextBilanganKedua.text.toString().isEmpty()) {
                mEditTextBilanganPertama.setError("Semua input harus diisi!")
            } else {
                val a = mEditTextBilanganPertama.text.toString().toDouble()
                val b = mEditTextBilanganKedua.text.toString().toDouble()
                val c = a * b
                mTextViewHasil.setText(c.toString())
            }
        }

        mButtonHitung.setOnClickListener {
            if (mEditTextBilanganPertama.text.toString() == "") {
                mEditTextBilanganPertama.error = "Kamu Belum Memasukkan Bilangan Pertama"
                return@setOnClickListener
            }

            if (mEditTextBilanganKedua.text.toString() == "") {
                mEditTextBilanganKedua.error = "Kamu Belum Memasukkan Bilangan Kedua"
                return@setOnClickListener
            }

            val mBilanganPertama = mEditTextBilanganPertama.text.toString().toDouble()
            val mBilanganKedua = mEditTextBilanganKedua.text.toString().toDouble()

            val mOperator = mSpinnerOperator.selectedItem.toString()

            var mHasilPerhitungan = 0.0

            when (mOperator) {
                "+" -> mHasilPerhitungan = mBilanganPertama + mBilanganKedua
                "-" -> mHasilPerhitungan = mBilanganPertama - mBilanganKedua
                "x" -> mHasilPerhitungan = mBilanganPertama * mBilanganKedua
                "/" -> mHasilPerhitungan = mBilanganPertama / mBilanganKedua
                else -> {
                    Toast.makeText(this, "Kamu belum memilih operator", Toast.LENGTH_SHORT).show()
                }
            }

            mTextViewHasil.text = mHasilPerhitungan.toString()
        }
    }
}