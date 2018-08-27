package com.portfolio.jgsilveira.cesar.arraysandstring.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.portfolio.jgsilveira.cesar.arraysandstring.R;

import java.util.ArrayList;
import java.util.List;

import static com.portfolio.jgsilveira.cesar.arraysandstring.jumbledletters.JumbledLettersHelper.isPartialPermutation;
import static com.portfolio.jgsilveira.cesar.arraysandstring.typo.TyposHelper.hasTypo;

public class MainActivity extends AppCompatActivity {

    private EditText mEditTextText;

    private List<String> mContent;

    private WordsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newContent();
        mEditTextText = findViewById(R.id.activity_main_text);
        RecyclerView mRecyclerViewList = findViewById(R.id.activity_main_list);
        DeviderItemDecoration itemDecoration =
                new DeviderItemDecoration(this, DeviderItemDecoration.VERTICAL_LIST, 0);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerViewList.addItemDecoration(itemDecoration);
        mRecyclerViewList.setLayoutManager(manager);
        mAdapter = new WordsAdapter(mContent);
        mRecyclerViewList.setAdapter(mAdapter);
        ImageButton imageButtonSearch = findViewById(R.id.activity_main_search);
        mEditTextText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    search();
                    return true;
                }
                return false;
            }
        });
        imageButtonSearch.setOnClickListener(new OnSearchClicked());
    }

    @Override
    protected void onResume() {
        super.onResume();
        boolean isEmpty = mEditTextText.getText().toString().isEmpty();
        if (isEmpty) {
            mEditTextText.setText("");
        }
        search();
    }

    private void search() {
        String text = mEditTextText.getText().toString();
        List<String> result = new ArrayList<>();
        if (text.isEmpty()) {
            result.addAll(mContent);
        } else {
            for (String item : mContent) {
                boolean partialPermutation = isPartialPermutation(item, text);
                boolean hasTypo = hasTypo(item, text);
                if (partialPermutation && !hasTypo) {
                    result.add(item);
                } else if (hasTypo && !partialPermutation) {
                    result.add(item);
                }
            }
        }
        applyResult(result);
    }

    private void applyResult(List<String> result) {
        mAdapter.setData(result);
    }

    private void newContent() {
        mContent = new ArrayList<>();
        mContent.add("you");
        mContent.add("pale");
        mContent.add("despite");
        mContent.add("bake");
        mContent.add("lists");
        mContent.add("engeneering");
        mContent.add("factory");
        mContent.add("apps");
        mContent.add("world");
        mContent.add("smart");
        mContent.add("cast");
        mContent.add("random");
    }

    private class OnSearchClicked implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            search();
        }

    }

}
