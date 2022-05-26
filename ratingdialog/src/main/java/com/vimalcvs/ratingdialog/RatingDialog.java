package com.vimalcvs.ratingdialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class RatingDialog extends BottomSheetDialogFragment {

    Context context;
    private RatingBar ratingBar;
    private ImageView rate_emoji;
    private TextView rate_result_tip, rate_result_title;
    private TextView lib_rate_button;

    public RatingDialog(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.lib_dialog_rating, container, false);

        rate_result_title = v.findViewById(R.id.rate_result_title);
        rate_result_tip = v.findViewById(R.id.rate_result_tip);
        lib_rate_button = v.findViewById(R.id.lib_rate_button);
        ratingBar = v.findViewById(R.id.rtb);
        rate_emoji = v.findViewById(R.id.rate_emoji);

        changeRating();
        onclick();
        return v;
    }
    public void changeRating() {
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            String getRating = String.valueOf(ratingBar.getRating());
            switch (getRating){
                case "1.0":
                    lib_rate_button.setText(getString(R.string.lib_rate_btn_rate));
                    rate_emoji.setImageResource(R.drawable.lib_rate_emoji_star_1);
                    rate_result_title.setText(getString(R.string.lib_rate_oh_no));
                    rate_result_tip.setText(getString(R.string.lib_rate_leave_feedback));
                    break;
                case "2.0":
                    lib_rate_button.setText(getString(R.string.lib_rate_btn_rate));
                    rate_emoji.setImageResource(R.drawable.lib_rate_emoji_star_2);
                    rate_result_title.setText(getString(R.string.lib_rate_oh_no));
                    rate_result_tip.setText(getString(R.string.lib_rate_leave_feedback));
                    break;
                case "3.0":
                    lib_rate_button.setText(getString(R.string.lib_rate_btn_rate));
                    rate_emoji.setImageResource(R.drawable.lib_rate_emoji_star_3);
                    rate_result_title.setText(getString(R.string.lib_rate_oh_no));
                    rate_result_tip.setText(getString(R.string.lib_rate_leave_feedback));
                    break;
                case "4.0":
                    lib_rate_button.setText(getString(R.string.lib_rate_btn_rate));
                    rate_emoji.setImageResource(R.drawable.lib_rate_emoji_star_4);
                    rate_result_title.setText(getString(R.string.lib_rate_like_you));
                    rate_result_tip.setText(getString(R.string.lib_rate_leave_feedback));
                    break;
                case "5.0":
                    lib_rate_button.setText(getString(R.string.lib_rate_btn_go_market));
                    rate_emoji.setImageResource(R.drawable.lib_rate_emoji_star_5);
                    rate_result_title.setText(getString(R.string.lib_rate_like_you));
                    rate_result_tip.setText(getString(R.string.lib_rate_thanks_feedback));
                    break;
                default:
                    lib_rate_button.setText(getString(R.string.lib_rate_btn_rate));
                    rate_emoji.setImageResource(R.drawable.lib_rate_emoji_star_0);
                    rate_result_title.setText(getString(R.string.lib_rate_dialog_tip));
                    rate_result_tip.setText(getString(R.string.lib_rate_five_stars_confirm_tip));
                    break;
            }
        });
    }
    public void onclick() {
        lib_rate_button.setOnClickListener(view -> {
            if (ratingBar.getRating() >= 5) {
                String packageName = (getActivity()).getPackageName();
                Intent it;
                try {
                    it = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));
                    startActivity(it);
                } catch (android.content.ActivityNotFoundException e) {
                    it = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
                    startActivity(it);
                }
                dismiss();
            } else if (ratingBar.getRating() > 0) {
                this.dismiss();
                Toast.makeText(getContext(),"Thank You for the Feedback!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}