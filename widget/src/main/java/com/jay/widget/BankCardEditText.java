package com.jay.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;

/**
 * Created on 2016/4/20
 *
 * @author JaySeng
 * @version 1.0.0
 */
public class BankCardEditText extends AppCompatEditText {


    public BankCardEditText(Context context) {
        this(context, null);
    }

    public BankCardEditText(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.editTextStyle);
    }

    public BankCardEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setInputType(EditorInfo.TYPE_CLASS_NUMBER);
        addTextChangedListener(textWatcher);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            int length = s.toString().trim().length();
            if (length % 5 == 0 && length != 0) {
                StringBuilder sb = new StringBuilder(s);
                CharSequence text = sb.insert(s.length() - 1, " ");
                setText(text);
            }
            Selection.setSelection(getText(), length());
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

}
