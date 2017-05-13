package com.example.resume.resume;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.resume.R;
import com.example.resume.model.ResumeElement;
import com.example.resume.ui.custom.ExpandingTextView;
import com.squareup.picasso.Picasso;

class ResumeElementViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.resume_element_iv) ImageView imageIv;
    @BindView(R.id.resume_element_name_tv) TextView nameTv;
    @BindView(R.id.details_etv) ExpandingTextView detailsEtv;

    ResumeElementViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    static int getLayoutId() {
        return R.layout.resume_element_layout;
    }

    void bind(ResumeElement resumeElement) {
        nameTv.setText(resumeElement.name());
        Picasso.with(itemView.getContext()).load(resumeElement.imageUrl()).into(imageIv);
        detailsEtv.setText(resumeElement.details());
    }
}
