package com.javasoul.swframework.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.javasoul.swframework.R;

public class SWActionBar extends RelativeLayout {

    private TextView tvTitle;
    private EditText txtSearch;
    private ImageView ivActionButton;

    private Boolean SEARCH_STATE = false;

    public SWActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.sw_action_bar, this);

        tvTitle = findViewById(R.id.tv_action_bar_title);
        txtSearch = findViewById(R.id.txt_action_bar_search);
        ivActionButton = findViewById(R.id.iv_action_button);

        for (int i = 0; i < attrs.getAttributeCount(); i++) {
            Integer value = Integer.parseInt(attrs.getAttributeValue(i));

            if(value == Type.DEFAULT_ACTION_BAR.get()) {
                txtSearch.setVisibility(View.GONE);
                ivActionButton.setVisibility(View.GONE);
            } else if(value == Type.SEARCH_ACTION_BAR.get()) {
                txtSearch.setVisibility(View.VISIBLE);
                ivActionButton.setVisibility(View.VISIBLE);
            } else if(value == Type.SAVE_ACTION_BAR.get()) {
                txtSearch.setVisibility(View.GONE);
                ivActionButton.setVisibility(View.VISIBLE);
                ivActionButton.setBackground(getResources().getDrawable(R.drawable.ic_save));
            }
        }
    }

    public void listenSearch(final SearchListener searchListener) {
        txtSearch.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(SEARCH_STATE) {
                    tvTitle.setVisibility(View.VISIBLE);
                    txtSearch.setVisibility(View.GONE);
                } else {
                    tvTitle.setVisibility(View.GONE);
                    txtSearch.setVisibility(View.VISIBLE);
                }
                searchListener.onSearch();
            }
        });
    }

    public void listenSave(final SaveListener saveListener) {
        ivActionButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                saveListener.onSave();
            }
        });
    }

    public interface SaveListener {
        void onSave();
    }

    public interface SearchListener {
        void onSearch();
    }

    private enum Type {
        DEFAULT_ACTION_BAR(0),
        SEARCH_ACTION_BAR(1),
        SAVE_ACTION_BAR(2);

        int type;
        Type(int type) {
            this.type = type;
        }

        public int get() {
            return type;
        }
    }
}
