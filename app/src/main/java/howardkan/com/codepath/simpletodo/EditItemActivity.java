package howardkan.com.codepath.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    EditText etUpdateText;
    int updatedIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        etUpdateText = (EditText) findViewById(R.id.etUpdateText);
        etUpdateText.setText(getIntent().getStringExtra("item_text"));
        etUpdateText.setSelection(etUpdateText.length());
        updatedIndex = getIntent().getIntExtra("item_index", 0);
    }

    public void onSave(View v) {
        Intent data = new Intent();
        data.putExtra("updatedText", etUpdateText.getText().toString());
        data.putExtra("updatedIndex", updatedIndex);
        setResult(RESULT_OK, data);
        finish();
    }
}
