package by.paulharokh.calculatortransformerkotlin

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.udojava.evalex.Expression
import kotlinx.android.synthetic.main.calculator_layout.*
import java.math.BigDecimal

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var strFinal: String? = ""
    var strRes: String = ""
    var rez: BigDecimal? = null

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator_layout)
        val decorView = window.decorView
        val uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
        decorView.systemUiVisibility = uiOptions
        decorView.setOnSystemUiVisibilityChangeListener { visibility ->
            if (visibility and View.SYSTEM_UI_FLAG_FULLSCREEN == 0) {
                decorView.systemUiVisibility = uiOptions
            }
        }

        btn_Dot.setOnClickListener(this)
        btn_Del.setOnClickListener(this)
        btn_0.setOnClickListener(this)
        btn_1.setOnClickListener(this)
        btn_2.setOnClickListener(this)
        btn_3.setOnClickListener(this)
        btn_4.setOnClickListener(this)
        btn_5.setOnClickListener(this)
        btn_6.setOnClickListener(this)
        btn_7.setOnClickListener(this)
        btn_8.setOnClickListener(this)
        btn_9.setOnClickListener(this)
        btn_clear.setOnClickListener(this)
        btn_rez.setOnClickListener(this)
        btn_plus.setOnClickListener(this)
        btn_minus.setOnClickListener(this)
        btn_multiplic.setOnClickListener(this)
        btn_div.setOnClickListener(this)
        btn_lftbracket.setOnClickListener(this)
        btn_rightbrckt.setOnClickListener(this)
        try {
            btn_rnd?.setOnClickListener(this)
            btn_sqrt?.setOnClickListener(this)
            btn_pwr?.setOnClickListener(this)
            btn_rem_div?.setOnClickListener(this)
            btn_fctrl?.setOnClickListener(this)
            btn_abs?.setOnClickListener(this)
            btn_ln?.setOnClickListener(this)
            btn_lg?.setOnClickListener(this)
            btn_sin?.setOnClickListener(this)
            btn_cos?.setOnClickListener(this)
            btn_tg?.setOnClickListener(this)
            btn_ctg?.setOnClickListener(this)
            btn_Asin?.setOnClickListener(this)
            btn_Acos?.setOnClickListener(this)
            btn_AtgR?.setOnClickListener(this)
            btn_Actg?.setOnClickListener(this)
            btn_pi?.setOnClickListener(this)
            btn_e?.setOnClickListener(this)
            btn_rad?.setOnClickListener(this)
            btn_deg?.setOnClickListener(this)
        } catch (e: Exception) {
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("input_key", strFinal)
        outState.putString("res_key", strRes)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        strRes = savedInstanceState.getString("res_key")!!
        idResultView?.setText(strRes)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                btn_Dot.id -> strFinal = appendString(strFinal, ".")
                btn_Del.id -> {
                    var txt: String? = strFinal
                    if (strFinal?.length!! > 0) {
                        strFinal = "";
                        if (txt != null) {
                            idInputView?.setText(txt.substring(0, txt.length - 1))
                        }
                        if (txt != null) {
                            strFinal = txt.substring(0, txt.length - 1)
                        }
                    }
                }
                btn_0.id -> strFinal = appendString(strFinal, "0")
                btn_1.id -> strFinal = appendString(strFinal, "1")
                btn_2.id -> strFinal = appendString(strFinal, "2")
                btn_3.id -> strFinal = appendString(strFinal, "3")
                btn_4.id -> strFinal = appendString(strFinal, "4")
                btn_5.id -> strFinal = appendString(strFinal, "5")
                btn_6.id -> strFinal = appendString(strFinal, "6")
                btn_7.id -> strFinal = appendString(strFinal, "7")
                btn_8.id -> strFinal = appendString(strFinal, "8")
                btn_9.id -> strFinal = appendString(strFinal, "9")
                btn_clear.id -> {
                    strFinal = ""
                    idInputView.setText(strFinal)
                }
                btn_rez.id -> {
                    try {
                        val expression = Expression(strFinal)
                        expression.setPrecision(12)
                        rez = expression.eval()
                        strRes = rez.toString()
                        idResultView.setText(strRes)
                    } catch (e: java.lang.Exception) {
                        idResultView.setText("Are you kidding me?")
                    }
                }
                btn_plus.id -> strFinal = appendString(strFinal, "+")
                btn_minus.id -> strFinal = appendString(strFinal, "-")
                btn_multiplic.id -> strFinal = appendString(strFinal, "*")
                btn_div.id -> strFinal = appendString(strFinal, "/")
                btn_lftbracket.id -> strFinal = appendString(strFinal, "(")
                btn_rightbrckt.id -> strFinal = appendString(strFinal, ")")
                btn_rnd?.id -> strFinal = appendString(strFinal, "RANDOM()")
                btn_sqrt?.id -> strFinal = appendString(strFinal, "SQRT(")
                btn_pwr?.id -> strFinal = appendString(strFinal, "^")
                btn_rem_div?.id -> strFinal = appendString(strFinal, "%")
                btn_fctrl?.id -> strFinal = appendString(strFinal, "FACT(")
                btn_abs?.id -> strFinal = appendString(strFinal, "ABS(")
                btn_ln?.id -> strFinal = appendString(strFinal, "LOG(")
                btn_lg?.id -> strFinal = appendString(strFinal, "LOG10(")
                btn_sin?.id -> strFinal = appendString(strFinal, "SIN(")
                btn_cos?.id -> strFinal = appendString(strFinal, "COS(")
                btn_tg?.id -> strFinal = appendString(strFinal, "TAN(")
                btn_ctg?.id -> strFinal = appendString(strFinal, "COT(")
                btn_Asin?.id -> strFinal = appendString(strFinal, "ASIN(")
                btn_Acos?.id -> strFinal = appendString(strFinal, "ACOS(")
                btn_AtgR?.id -> strFinal = appendString(strFinal, "ATAN(")
                btn_Actg?.id -> strFinal = appendString(strFinal, "ACOT(")
                btn_pi?.id -> strFinal = appendString(strFinal, "PI")
                btn_e?.id -> strFinal = appendString(strFinal, "e")
                btn_rad?.id -> strFinal = appendString(strFinal, "RAD(")
                btn_deg?.id -> strFinal = appendString(strFinal, "DEG(")
            }
        }
    }

    fun appendString(inputStr: String?, btnText: String?): String? {
        var inputStr = inputStr
        inputStr += btnText
        idInputView.setText(inputStr)
        return inputStr
    }
}