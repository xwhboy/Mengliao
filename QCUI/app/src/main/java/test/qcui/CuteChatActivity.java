package test.qcui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 文浩 on 2015/8/15.
 */
public class CuteChatActivity extends Activity {
    private Button returnButton;
    private TextView showText;
    private Button mainButton;
    private Button loveButton;


//    测试
    private boolean iflove=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_cutechat);
        findView();
        setListener();
        initData();

    }
    private void findView(){
        returnButton=(Button)this.findViewById(R.id.bn_return);
        mainButton=(Button)this.findViewById(R.id.maike);
        loveButton=(Button)this.findViewById(R.id.bn_love);
        showText=(TextView)this.findViewById(R.id.show_text);

    }
    private void setListener(){
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(CuteChatActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mainButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Resources resources = CuteChatActivity.this.getResources();
                Drawable btnDrawable = resources.getDrawable(R.drawable.mky);
                mainButton.setBackgroundDrawable(btnDrawable);
                return false;
            }
        });
        loveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              iflove=false
                if(!iflove){
                    Resources resources = CuteChatActivity.this.getResources();
                    Drawable btnDrawable = resources.getDrawable(R.drawable.bn_lovewp);
                    loveButton.setBackgroundDrawable(btnDrawable);
                    iflove=true;

                }
                else
                {
                    Resources resources = CuteChatActivity.this.getResources();
                    Drawable btnDrawable = resources.getDrawable(R.drawable.bn_lovew);
                    loveButton.setBackgroundDrawable(btnDrawable);
                    iflove=false;
                }

            }
        });
    }
    private void initData(){

    }

}
